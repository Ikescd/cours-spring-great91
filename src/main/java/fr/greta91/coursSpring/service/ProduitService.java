package fr.greta91.coursSpring.service;

import java.util.List;

import javax.validation.Valid;

import fr.greta91.coursSpring.model.Produit;

public interface ProduitService {

	List<Produit> findAll();

	List<Produit> findByNom(String search);

	void save(Produit p);

	Produit findById(long prodId);

	void update(@Valid Produit produit);

	void delete(long id);

}
