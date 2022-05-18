package com.umbertoemonds.docharmonie.model;

import java.sql.Array;

import org.hibernate.annotations.Type;
import org.hibernate.mapping.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accord_chroma", schema = "docharmonie")
public class Accord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /*
    @Column(name = "demi_tons")
    private Integer[] demi_tons;
    */

    @Column(name = "position")
    private int position;

    @Column(name = "grille_id")
    private int grilleId;
}
