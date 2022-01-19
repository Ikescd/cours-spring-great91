package fr.greta91.coursSpring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.greta91.coursSpring.model.Produit;
import fr.greta91.coursSpring.temp.LocalDB;

@Service
public class ProduitServiceImpl implements ProduitService{
	@Autowired
	private LocalDB db;
	@Override
	public List<Produit> findAll() {
		return db.getProduits();
	}

	@Override
	public List<Produit> findByNom(String search) {
		return db.findProduitByNom(search);
	}

	@Override
	public void save(Produit p) {
		db.saveProduit(p);
		
	}

	@Override
	public Produit findById(long prodId) {
		
		return db.findProduitById(prodId);
	}

	@Override
	public void update(Produit produit) {
		db.updateProduit(produit);
	}

	@Override
	public void delete(long id) {
		db.deleteProduit(id);
		
	}

}
