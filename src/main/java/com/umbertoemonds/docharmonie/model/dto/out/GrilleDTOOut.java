package com.umbertoemonds.docharmonie.model.dto.out;

import com.umbertoemonds.docharmonie.model.Projet;

public class GrilleDTOOut {

    private long id;
    private String nom;
    private String description;
    private int tempo;
    private String tonalite_note;
    private String tonalite_mode;
    private Projet projet;
    private String style;

    public GrilleDTOOut(){}

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getTempo() {
        return tempo;
    }

    public String getTonalite_note() {
        return tonalite_note;
    }

    public String getTonalite_mode() {
        return tonalite_mode;
    }

    public Projet getProjet() {
        return projet;
    }

    public String getStyle() {
        return style;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setTonalite_note(String tonalite_note) {
        this.tonalite_note = tonalite_note;
    }

    public void setTonalite_mode(String tonalite_mode) {
        this.tonalite_mode = tonalite_mode;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}