package fr.greta91.coursSpring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String libelle;

	public Categorie() {
	} 
	
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	} 
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Categorie)) {
            return false;
        }

        Categorie categorie = (Categorie) o;

        return categorie.id == id;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)id;
        result = 31 * result + libelle.hashCode();
        return result;
    }
	
}
