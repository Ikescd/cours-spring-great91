package fr.greta91.coursSpring.model;

import java.util.HashSet;
import java.util.Set;

public class Panier {
	Set<Produit> listeProduits;
	
	public Panier() {
		listeProduits = new HashSet<Produit>();
	}
	
	public Set<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(Set<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public void addProduit(Produit produit) {
		this.listeProduits.add(produit);
	}
	
	public void removeProduit(Produit produit) {
		this.listeProduits.remove(produit);
	}

}
