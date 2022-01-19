package fr.greta91.coursSpring.temp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.greta91.coursSpring.model.Categorie;
import fr.greta91.coursSpring.model.Produit;
import fr.greta91.coursSpring.model.Utilisateur;

public class LocalDB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Produit> produits = new ArrayList<Produit>();
	private List<Categorie> categories = new ArrayList<Categorie>();
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	public List<Produit> getProduits() {
		return produits;
	}
	
	public void setProduits(List<Produit> produits) {
		this.produits = produits;	
	}
	
	public List<Categorie> getCategories() {
		return categories;
		
	}
	
	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
		
	}

	public void saveProduit(Produit p) {
		produits.add(p);
	}
	
	public List<Produit> findProduitByNom(String search) {
		return produits.stream()
	      .filter(produit -> search.equals(produit.getNom()))
	      .collect(Collectors.toList());
	}
	
	public Produit findProduitById(long prodId) {
		Produit p = null;
		Optional<Produit> opt = produits.stream()
	      .filter(produit -> prodId == produit.getId())
	      .findFirst();
		if(opt.isPresent()) {
			p = opt.get();
		}
		return p;
	}

	public void updateProduit(Produit produit) {
		produits = produits.stream().map(p -> {
			if(p.getId() == produit.getId()) {
				return produit;
			}
			else {
				return p;
			}
		}).collect(Collectors.toList());
	}
	
	public void deleteProduit(long id) {
		produits = produits.stream()
			      .filter(produit -> id != produit.getId())
			      .collect(Collectors.toList());
		
	}

	public Categorie findCategorieById(int catId) {
		Categorie p = null;
		Optional<Categorie> opt = categories.stream()
	      .filter(categorie -> catId == categorie.getId())
	      .findFirst();
		if(opt.isPresent()) {
			p = opt.get();
		}
		return p;
	}
	public Optional<Utilisateur> findUtilisateurByUsername(String username) {
		return utilisateurs.stream()
	      .filter(user -> username.equals(user.getUsername())).findFirst();
		
	}
	
	public void saveUtilisateur(Utilisateur u) {
		utilisateurs.add(u);
	}
	
}
