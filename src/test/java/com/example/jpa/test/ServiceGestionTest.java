package com.example.jpa.test;

import com.example.jpa.entities.Salle;
import com.example.jpa.entities.Utilisateur;
import com.example.jpa.service.ServiceGestion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceGestionTest {

    private ServiceGestion service;

    @Before
    public void setUp() {
        service = new ServiceGestion();
    }

    @After
    public void tearDown() {
        service.fermer();
    }

    @Test
    public void testCreationEtRechercheSalle() {
        Salle salle = new Salle("Salle Test", 20);
        service.ajouterSalle(salle);

        List<Salle> salles = service.listerSalles();
        assertFalse(salles.isEmpty());
        assertEquals("Salle Test", salles.get(0).getNom());
    }

    @Test
    public void testCreationUtilisateurAvecSalle() {
        Salle salle = new Salle("Salle B", 15);
        service.ajouterSalle(salle);

        Utilisateur utilisateur = new Utilisateur("Alice", "alice@example.com", salle);
        service.ajouterUtilisateur(utilisateur);

        List<Utilisateur> utilisateurs = service.listerUtilisateurs();
        assertFalse(utilisateurs.isEmpty());
        assertEquals("Alice", utilisateurs.get(0).getNom());
        assertEquals("Salle B", utilisateurs.get(0).getSalle().getNom());
    }

    @Test
    public void testRechercheUtilisateursParSalle() {
        Salle salle = new Salle("Salle C", 30);
        service.ajouterSalle(salle);

        Utilisateur u1 = new Utilisateur("Bob", "bob@example.com", salle);
        Utilisateur u2 = new Utilisateur("Carol", "carol@example.com", salle);
        service.ajouterUtilisateur(u1);
        service.ajouterUtilisateur(u2);

        List<Utilisateur> utilisateurs = service.utilisateursParSalle("Salle C");
        assertEquals(2, utilisateurs.size());
    }

    @Test
    public void test_de_recherchement_de_salle_par_capacite_minimal() {
        Salle petiteSalle = new Salle("Petite salle", 40);
        Salle grandeSalle = new Salle("Grande salle", 60);
        service.ajouterSalle(petiteSalle);
        service.ajouterSalle(grandeSalle);

        List<Salle> salles = service.sallesParCapaciteMin(60);
        assertEquals(1, salles.size());
        assertEquals("Grande salle", salles.get(0).getNom());
        assertEquals(60, salles.get(0).getCapacite());
    }

    @Test
    public void test_de_recherchement_de_salle_par_capacite_maximal() {
        Salle petiteSalle = new Salle("Petite salle max", 5);
        Salle grandeSalle = new Salle("Grande salle max", 10);
        service.ajouterSalle(petiteSalle);
        service.ajouterSalle(grandeSalle);

        List<Salle> salles = service.sallesParCapaciteMax(5);
        assertEquals(1, salles.size());
        assertEquals("Petite salle max", salles.get(0).getNom());
        assertEquals(5, salles.get(0).getCapacite());
    }
}
