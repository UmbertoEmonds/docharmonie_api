package com.umbertoemonds.docharmonie.model.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UtilisateurDTOIn {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public UtilisateurDTOIn(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}