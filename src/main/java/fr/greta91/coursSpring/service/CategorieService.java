package fr.greta91.coursSpring.service;

import java.util.List;

import fr.greta91.coursSpring.model.Categorie;

public interface CategorieService {

	List<Categorie> findAll();

	Categorie findById(int categorie);

}
