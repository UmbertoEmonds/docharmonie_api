package com.umbertoemonds.docharmonie.controller;

import java.util.Optional;

import com.umbertoemonds.docharmonie.model.Utilisateur;
import com.umbertoemonds.docharmonie.model.dto.UtilisateurDTO;
import com.umbertoemonds.docharmonie.security.JWTAuthenticationFilter;
import com.umbertoemonds.docharmonie.service.GrilleService;
import com.umbertoemonds.docharmonie.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final static Log LOG = LogFactory.getLog(JWTAuthenticationFilter.class);

    @Autowired
    private UtilisateurService userService;

    @GetMapping()
    public UtilisateurDTO find(){
        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = user.getName();
        
        Optional<Utilisateur> utilisateur = userService.findById(Integer.parseInt(userId));

        return new UtilisateurDTO(utilisateur.get());
    }

    @PostMapping()
    public Utilisateur add(@RequestBody UtilisateurDTO userDTO){
        return userService.add(userDTO);
    }

}