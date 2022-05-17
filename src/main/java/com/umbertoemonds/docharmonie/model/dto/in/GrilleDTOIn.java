package com.umbertoemonds.docharmonie.model.dto.in;

import java.util.List;

public class GrilleDTOIn {

    private String nom;
    private String description;
    private int tempo;
    private int idNote;
    private int idMode;
    private int idStyle;
    private int idProjet;
    private List<AccordDTOIn> accords;

    GrilleDTOIn(String nom, 
                String description, 
                int tempo, 
                int idNote, 
                int idMode, 
                int idStyle, 
                int idProjet, 
                List<AccordDTOIn> accords){
        this.nom = nom;
        this.description = description;
        this.tempo = tempo;
        this.idNote = idNote;
        this.idMode = idMode;
        this.idStyle = idStyle;
        this.idProjet = idProjet;
        this.accords = accords;
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

    public int getIdMode() {
        return idMode;
    }

    public int getIdNote() {
        return idNote;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public List<AccordDTOIn> getAccords() {
        return accords;
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

    public void setIdMode(int idMode) {
        this.idMode = idMode;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setAccords(List<AccordDTOIn> accords) {
        this.accords = accords;
    }

}