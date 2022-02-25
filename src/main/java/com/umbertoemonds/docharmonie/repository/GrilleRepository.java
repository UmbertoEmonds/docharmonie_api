package com.umbertoemonds.docharmonie.repository;

import java.util.List;

import com.umbertoemonds.docharmonie.model.Grille;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrilleRepository extends JpaRepository<Grille, Long>{
    
    // le nom de la méthode est interprété comme une clause where par l'ORM
    List<Grille> findAllByUserId(Integer userId);

}