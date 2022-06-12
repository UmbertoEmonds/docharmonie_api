package com.umbertoemonds.docharmonie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

    @ManyToOne
    @JoinColumn(name = "id_projet")
    private Projet projet;

    @Column(name = "id_user")
    private Integer userId;

    public Grille(){}

    public Grille(long id, String nom, String description, Integer tempo, Integer noteId, Integer modeId, Integer styleId, Projet projet, Integer userId){
        this.id = id;
        this.description = description;
        this.tempo = tempo;
        this.noteId = noteId;
        this.modeId = modeId;
        this.styleId = styleId;
        this.projet = projet;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTempo() {
        return tempo;
    }

    public Integer getNoteId() {
        return noteId;
    }
    
    public Integer getModeId() {
        return modeId;
    }

    public Projet getProjet() {
        return projet;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModeId(Integer modeId) {
        this.modeId = modeId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}