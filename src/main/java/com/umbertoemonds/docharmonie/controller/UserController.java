package com.umbertoemonds.docharmonie.controller;

import java.util.List;
import java.util.Optional;

import com.umbertoemonds.docharmonie.model.Grille;
import com.umbertoemonds.docharmonie.model.Utilisateur;
import com.umbertoemonds.docharmonie.model.dto.UtilisateurDTO;
import com.umbertoemonds.docharmonie.service.GrilleService;
import com.umbertoemonds.docharmonie.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UtilisateurService userService;

    @Autowired
    private GrilleService grilleService;

    @GetMapping("/{id}")
    public Optional<Utilisateur> findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/grilles")
    public List<Grille> findGrillesByUserId(@PathVariable("id") Integer id){
        return grilleService.findAllByUserId(id);
    }

    @PostMapping()
    public Utilisateur add(@RequestBody UtilisateurDTO userDTO){
        return userService.add(userDTO);
    }
    
}