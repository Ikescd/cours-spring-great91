package fr.greta91.coursSpring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.greta91.coursSpring.model.Panier;
import fr.greta91.coursSpring.model.Produit;
import fr.greta91.coursSpring.service.ProduitService;

@Controller
@RequestMapping("/panier")
public class PanierController {
	@Autowired
	Panier panier;

	@Autowired
	ProduitService produitService;

	@GetMapping("/add/{id}")
	public String add(@PathVariable Long id) {
		// récupérer produit
		Produit produit = produitService.findById(id);
		
		panier.addProduit(produit);
		return "redirect:/panier/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		Set<Produit> liste = panier.getListeProduits();
		model.addAttribute("produits", liste);
		model.addAttribute("panierCount", liste.size());
		return "panier/list";
	}
}