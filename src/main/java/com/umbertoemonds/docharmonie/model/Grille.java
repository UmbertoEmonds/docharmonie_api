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
@Table(name = "grille_accord", schema = "docharmonie")
public class Grille {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tempo")
    private int tempo;

    @Column(name = "note_id")
    private int noteId;

    @Column(name = "mode_id")
    private int modeId;

    @Column(name = "style_id")
    private int styleId;

    @Column(name = "projet_id")
    private int projetId;

    @Column(name = "utilisateur_id")
    private int userId;

}