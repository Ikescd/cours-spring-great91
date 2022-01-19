package fr.greta91.coursSpring;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

import fr.greta91.coursSpring.model.Categorie;
import fr.greta91.coursSpring.model.Panier;
import fr.greta91.coursSpring.model.Produit;
import fr.greta91.coursSpring.model.Utilisateur;
import fr.greta91.coursSpring.temp.LocalDB;
//CGLIB 
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true) 
//@Configuration
//@EnableAutoConfiguration //convention sur la configuration
//@ComponentScan
public class CoursSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoursSpringApplication.class, args);
	}
	
	@Bean
	public String test() {
		return "Hello world !";
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LocalDB localDB() {
		LocalDB db = new LocalDB();
		
		ArrayList<Produit> produits = new ArrayList<Produit>();
		Produit produit = new Produit(1, "0123456789123", "Produit 1", "Designation 1", 15, 10.99);
		produits.add(produit);
		produit = new Produit(2, "0123479789123", "Produit 2", "Designation 2", 25, 20.99);
		produits.add(produit);
		produit = new Produit(3, "0123478789123", "Produit 3", "Designation 3", 35, 30.99);
		produits.add(produit);
		produit = new Produit(4, "0123445889123", "Produit 4", "Designation 4", 45, 40.99);
		produits.add(produit);
		db.setProduits(produits);
		
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		Categorie categorie = new Categorie(1, "cat 1");
		categories.add(categorie);
		categorie = new Categorie(2, "cat 2");
		categories.add(categorie);
		db.setCategories(categories);
		
		//créer les utilisateurs
		Utilisateur u = new Utilisateur();
		u.setId(1);
		u.setUsername("toto");
		u.setPassword(passwordEncoder().encode("toto"));
		db.saveUtilisateur(u);
		
		u = new Utilisateur();
		u.setId(2);
		u.setUsername("titi");
		u.setPassword(passwordEncoder().encode("titi"));
		db.saveUtilisateur(u);
		return db;
	}
	
	@Bean
	@SessionScope
	public Panier panier() {
		return new Panier();
	}

}
