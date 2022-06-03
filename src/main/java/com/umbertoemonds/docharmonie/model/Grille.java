package com.umbertoemonds.docharmonie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "grille", schema = "docharmonie")
public class Grille {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "tempo")
    private Integer tempo;

    @Column(name = "id_note")
    private Integer noteId;

    @Column(name = "id_mode")
    private Integer modeId;

    @Column(name = "id_style")
    private Integer styleId;

    @Column(name = "id_projet")
    private Integer projetId;

    @Column(name = "id_user")
    private Integer userId;
}