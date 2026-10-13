package com.example.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nomS;

    @Column(nullable = false)
    private int capaciteS;

    // Constructeurs
    public Salle() {}

    public Salle(String nom, int capacite) {
        this.nomS = nom;
        this.capaciteS = capacite;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nomS;
    }

    public void setNom(String nom) {
        this.nomS = nom;
    }

    public int getCapacite() {
        return capaciteS;
    }

    public void setCapacite(int capacite) {
        this.capaciteS = capacite;
    }

    @Override
    public String toString() {
        return "Salle [id=" + id + ", nom=" + nomS+ ", capacite=" + capaciteS + "]";
    }
}