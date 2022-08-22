package com.umbertoemonds.docharmonie.model.dto.out;

public class AccordDTOOut {
    private int position;
    private String rawName;
    private String simplifiedName;
    private int[] demiTons;

    public AccordDTOOut(){}

    public int getPosition() {
        return position;
    }

    public String getRawName() {
        return rawName;
    }

    public String getSimplifiedName() {
        return simplifiedName;
    }

    public int[] getDemiTons() {
        return demiTons;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRawName(String rawName) {
        this.rawName = rawName;
    }

    public void setSimplifiedName(String simplifiedName) {
        this.simplifiedName = simplifiedName;
    }

    public void setDemiTons(int[] demiTons) {
        this.demiTons = demiTons;
    }
}
