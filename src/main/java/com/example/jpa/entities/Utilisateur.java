package com.example.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomU;

    @Column(nullable = false, unique = true)
    private String emailU;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String email, Salle salle) {
        this.nomU = nom;
        this.emailU = email;
        this.salle = salle;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nomU;
    }

    public void setNom(String nom) {
        this.nomU = nom;
    }

    public String getEmail() {
        return emailU;
    }

    public void setEmail(String email) {
        this.emailU = email;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nomU + ", email=" + emailU + ", salle=" + (salle != null ? salle.getNom() : "aucune") + "]";
    }
}