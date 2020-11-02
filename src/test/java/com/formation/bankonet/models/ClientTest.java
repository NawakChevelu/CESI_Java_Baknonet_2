package com.formation.bankonet.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest extends Client{

    @BeforeEach
    void setUp() {
        this.nom = "Patrick";
        this.prenom = "Patrick";
        CompteCourant compteTest = new CompteCourant();
        compteTest.setTauxInteret(1);
        compteTest.setSolde(10);
        compteTest.setIntitule("Test");
        this.compteList.add(compteTest);
    }

    @Test
    void set_nom_change_nom() {
        this.setNom("Franck");

        assertEquals(this.nom,"Franck");
    }

    @Test
    void get_nom_retourne_nom() {
        assertEquals(this.getNom(),"Patrick");
    }

    @Test
    void set_prenom_change_prenom() {
        this.setPrenom("Franck");

        assertEquals(this.prenom,"Franck");
    }

    @Test
    void get_prenom_retourne_prenom() {
        assertEquals(this.getPrenom(),"Patrick");
    }


    @Test
    void testToString() {
        assertEquals(this.toString(), "Client{" +
                "identifiant=" + 0 +
                ", nom='" + this.nom + '\'' +
                ", prenom='" + this.prenom + '\'' +
                ", compteList=" + this.compteList +
                '}');
    }
}