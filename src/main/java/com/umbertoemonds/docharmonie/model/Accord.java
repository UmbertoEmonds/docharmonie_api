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
@Table(name = "accord", schema = "docharmonie")
public class Accord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "position")
    private int position;

    @Column(name = "grille_accord_id")
    private int grilleId;

    @Column(name = "note_id")
    private int noteId;

    @Column(name = "nature_id")
    private int natureId;

    @Column(name = "enrichissement_id")
    private Integer enrichissementId;

}
