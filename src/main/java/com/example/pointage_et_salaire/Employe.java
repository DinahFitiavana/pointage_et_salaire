package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Employe {
    private String nom;
    private String matricule;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateFinContrat;
    private double salaireBrut;
    private double salaireNet;
    private Categorie categorie;

    public Employe(String nom, String matricule, LocalDate dateNaissance, LocalDate dateEmbauche,
                   LocalDate dateFinContrat, double salaireBrut, Categorie categorie) {
        this.nom = nom;
        this.matricule = matricule;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
        this.salaireBrut = salaireBrut;
        this.categorie = categorie;
        this.salaireNet = salaireBrut * 0.8;
    }
}