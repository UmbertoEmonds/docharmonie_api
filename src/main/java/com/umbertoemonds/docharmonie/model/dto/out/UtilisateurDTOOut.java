package com.umbertoemonds.docharmonie.model.dto.out;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umbertoemonds.docharmonie.model.Utilisateur;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UtilisateurDTOOut implements UserDetails {

    private long id;
    private String firstname;
    private String lastname;
    private String email;

    @JsonIgnore
    private String password;

    public UtilisateurDTOOut(Utilisateur utilisateur){
        this.id = utilisateur.getId();
        this.firstname = utilisateur.getFirstname();
        this.lastname = utilisateur.getLastname();
        this.email = utilisateur.getEmail();
        this.password = utilisateur.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}