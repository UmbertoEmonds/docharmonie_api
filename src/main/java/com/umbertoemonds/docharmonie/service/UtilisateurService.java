package com.umbertoemonds.docharmonie.service;

import com.umbertoemonds.docharmonie.repository.UtilisateurRepository;

import java.util.Optional;

import com.umbertoemonds.docharmonie.model.Utilisateur;
import com.umbertoemonds.docharmonie.model.dto.UtilisateurDTO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService implements UserDetailsService {

    private final static Log LOG = LogFactory.getLog(UtilisateurService.class);

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Utilisateur add(UtilisateurDTO userDTO){

        var user = new Utilisateur(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public Optional<Utilisateur> findById(long id){
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByEmail(username);
        return new UtilisateurDTO(user);
    }

}