package com.umbertoemonds.docharmonie.model;

import org.hibernate.annotations.Type;

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

    @Column(name = "position")
    private int position;

    @Column(name = "grille_id")
    private int grilleId;

    @Column(name = "demi_tons", columnDefinition = "integer[]")
    @Type(type = "com.umbertoemonds.docharmonie.utils.CustomIntArrayType")
    private Integer[] demiTons;
    
}