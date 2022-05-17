package com.umbertoemonds.docharmonie.model.dto.in;

public class AccordDTOIn {

    private int idNote;
    private int idNature;
    private int position;

    public AccordDTOIn(int idNote, int idNature, int position){
        this.idNote = idNote;
        this.idNature = idNature;
        this.position = position;
    }

    public int getIdNote() {
        return idNote;
    }

    public int getIdNature() {
        return idNature;
    }

    public int getPosition() {
        return position;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public void setIdNature(int idNature) {
        this.idNature = idNature;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
