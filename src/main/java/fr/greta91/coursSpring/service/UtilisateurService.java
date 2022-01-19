package fr.greta91.coursSpring.service;

import java.util.Optional;

import fr.greta91.coursSpring.model.Utilisateur;

public interface UtilisateurService {

	Optional<Utilisateur> findByUsername(String user);

	void save(Utilisateur u);

}
