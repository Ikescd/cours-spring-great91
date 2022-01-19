package fr.greta91.coursSpring.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{13}$")
	private String isbn;
	
	@NotNull
	private String nom;
	
	private String designation="";

	@NotNull
	@Min(value = 0, message = "Stock doit être supérieur ou égal à 0")
	private int stock;

	@NotNull
	@DecimalMin("0.01")
	private double prixHT;
	
	@NotNull
	private Categorie categorie;

	public Produit() {
	}

	public Produit(String nom, String designation, int stock, double prixHT) {
		super();
		this.nom = nom;
		this.designation = designation;
		this.stock = stock;
		this.prixHT = prixHT;
	}

	public Produit(long id, String isbn, String nom, String designation, int stock, double prixHT) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.nom = nom;
		this.designation = designation;
		this.stock = stock;
		this.prixHT = prixHT;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Map<String, String> validate() {
		Map<String, String> erreurs = new HashMap<>();
		// 1.tester si nom
		// 	1.1 n'est pas vide
		// 	1.2 ne contient pas que les espaces
		if (nom == null || nom.trim().isEmpty()) {
			erreurs.put("nom", "ce champ est obligatoire");
		}
		// 2. tester si stock n'est pas negatif
		if (stock < 0) {
			erreurs.put("stock", "Stock doit être supérieur à 0");
		}
		// 3. tester si prixHT n'est pas negatif
		if (prixHT <= 0) {
			erreurs.put("prixHT", "Prix doit être supérieur à 0");
		}
		// 4. tester si categorie n'est pas null
		if (null == categorie) {
			erreurs.put("categorie", "ce champ est obligatoire");
		}
		// 5. tester si isbn comporte 13 chiffres
		if(!java.util.regex.Pattern.matches("^[0-9]{13}$", isbn)) {
			erreurs.put("isbn", "isbn doit comporter 13 chiffres");
		}
		return erreurs;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Produit)) {
            return false;
        }

        Produit produit = (Produit) o;

        return produit.id == id;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)id;
        result = 31 * result + nom.hashCode();
        result = 31 * result + designation.hashCode();
        result = 31 * result + stock;
        result = 31 * result + (int)prixHT;
        return result;
    }

}
