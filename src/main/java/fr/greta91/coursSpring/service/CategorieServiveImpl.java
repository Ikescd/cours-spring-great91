package fr.greta91.coursSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.greta91.coursSpring.model.Categorie;
import fr.greta91.coursSpring.temp.LocalDB;
@Service
public class CategorieServiveImpl implements CategorieService {

	@Autowired
	private LocalDB db;
	
	@Override
	public List<Categorie> findAll() {
		return db.getCategories();
	}

	@Override
	public Categorie findById(int catId) {
		// TODO Auto-generated method stub
		return db.findCategorieById(catId);
	}

}
