package tn.esprit.spring.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.repositoryUtilisateur;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  repositoryUtilisateur userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Utilisateur user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
  public Utilisateur loadUserInformations(String username) {
	 return userRepository.findByUsername(username).orElse(null);
  }
}
