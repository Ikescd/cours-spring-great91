package fr.greta91.coursSpring.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.greta91.coursSpring.model.Categorie;
import fr.greta91.coursSpring.model.Produit;
import fr.greta91.coursSpring.service.CategorieService;
import fr.greta91.coursSpring.service.ProduitService;

@Controller
public class ProduitController {
	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieService categorieService;

	@RequestMapping(value = { "/produit/list" }, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, @RequestParam(required = false) String search) {
		List<Produit> produits = null;
		if (null == search) {
			produits = produitService.findAll();
		} else {
			produits = produitService.findByNom(search);
		}
		mv.addObject("produits", produits);
		mv.addObject("titrePage", "Liste des produits");
		mv.setViewName("produits/list");
		return mv;
	}

	@GetMapping("/admin/produit/add")
	public ModelAndView add(ModelAndView mv) {
		List<Categorie> cats = categorieService.findAll();
		mv.addObject("produit", new Produit());
		mv.addObject("categories", cats);
		mv.addObject("titrePage", "Ajouter un produit");
		mv.setViewName("produits/add");
		return mv;
	}

	public ModelAndView traiterFormV0(@RequestParam String nom, @RequestParam String designation,
			@RequestParam Integer stock, @RequestParam Double prixHT, @RequestParam Integer categorie,
			ModelAndView mv) {

		List<Categorie> cats = categorieService.findAll();
		mv.addObject("categories", cats);
		mv.addObject("titrePage", "Ajouter un produit");
		Produit p = new Produit(nom, designation, stock, prixHT);
		Map<String, String> erreurs = p.validate();

		if (erreurs.size() > 0) {
			System.out.println(erreurs);
			mv.addObject("erreurs", erreurs);
			mv.setViewName("produits/add");
			return mv;
		}
		Categorie catObj = categorieService.findById(categorie);
		p.setCategorie(catObj);
		produitService.save(p);
		mv.setViewName("redirect:/produit/list");
		return mv;
	}

	@PostMapping("/admin/produit/add")
	public ModelAndView traiterForm(@ModelAttribute("produit") @Valid Produit produit, BindingResult errors,
			ModelAndView mv) {
		
		if (errors.hasErrors()) {
			List<Categorie> cats = categorieService.findAll();
			mv.addObject("categories", cats);
			mv.addObject("produit", produit);
			mv.addObject("titrePage", "Ajouter un produit");
			mv.setViewName("produits/add");
		} else {
			produitService.save(produit);
			mv.setViewName("redirect:/produit/list");
		}
		return mv;
	}

	// /produit/show/{id} /produit/show/1 pour afficher le produit avec l'id 1
	@GetMapping("/produit/show/{id}")
	public ModelAndView show(@PathVariable("id") long prodId, ModelAndView mv) {
		Produit produit = produitService.findById(prodId);
		if (produit == null) {
			// rediriger vers "/produit/list"
			mv.setViewName("redirect:/produit/list");
		} else {
			// transferer le controle à produit/show.jsp
			mv.addObject("produit", produit);
			mv.addObject("titrePage", produit.getNom());
			mv.setViewName("produits/show");
		}
		return mv;
	}

	// /produit/update?id={0}
	@GetMapping("/admin/produit/update")
	public String showUpdate(@RequestParam(required = false) Long id, Model model) {
		//si id == null, redirige l'user vers l'url /produit/list
		if(null == id) {
			return "redirect:/produit/list";
		}
		//récupérer le produit qui a l'id = id
		Produit produit = produitService.findById(id);
		
		List<Categorie> cats = categorieService.findAll();
		if(produit.getCategorie() != null) {
			cats = cats.stream().filter(c -> c.getId() != produit.getCategorie().getId()
			).collect(Collectors.toList());
		}
		model.addAttribute("categories", cats);
		model.addAttribute("produit", produit);
		model.addAttribute("titrePage", "Modifier un produit");
		return "produits/update";
	}

	@PostMapping("/admin/produit/update")
	public ModelAndView update(@ModelAttribute @Valid Produit produit, BindingResult errors, ModelAndView mv) {
		if (errors.hasErrors()) {
			List<Categorie> cats = categorieService.findAll();
			mv.addObject("categories", cats);
			mv.addObject("produit", produit);
			mv.addObject("titrePage", "Modifier un produit");
			mv.setViewName("produits/update");
		} else {
			produitService.update(produit);
			mv.setViewName("redirect:/produit/list");
		}
		return mv;
	}

	@PostMapping("/admin/produit/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		produitService.delete(id);
		return null;
	}

}
