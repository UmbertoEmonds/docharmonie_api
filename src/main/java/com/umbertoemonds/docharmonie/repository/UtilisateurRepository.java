package com.umbertoemonds.docharmonie.repository;

import com.umbertoemonds.docharmonie.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    boolean existsByEmail(String email);
    Utilisateur findByEmail(String email);
}