package com.umbertoemonds.docharmonie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "id_note")
    private int noteId;

    @Column(name = "id_nature")
    private int natureId;

    @Column(name = "position")
    private int position;

    @Column(name = "id_grille")
    private int grilleId;
}
