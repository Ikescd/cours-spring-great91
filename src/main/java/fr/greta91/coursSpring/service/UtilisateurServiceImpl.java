package fr.greta91.coursSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.greta91.coursSpring.model.Utilisateur;
import fr.greta91.coursSpring.temp.LocalDB;

@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService{
	@Autowired
	private LocalDB db;

	
	@Override
	public Optional<Utilisateur> findByUsername(String user) {
		return db.findUtilisateurByUsername(user);
	}

	@Override
	public void save(Utilisateur u) {
		db.saveUtilisateur(u);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> optUser = findByUsername(username);
		if(optUser.isEmpty()) throw new UsernameNotFoundException("inconnu");
		Utilisateur utilisateur = optUser.get();
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		if (utilisateur.getUsername().equals("admin")) auths.add(new SimpleGrantedAuthority("ADMIN"));
		else auths.add(new SimpleGrantedAuthority("USER"));
		return new User(utilisateur.getUsername(), utilisateur.getPassword(), auths);
	}

}