package com.example.pointage_et_salaire;

import java.time.LocalDate;
import java.util.List;

public class PointageTest {
    public static void main(String[] args) {
        Categorie cadreSuperieur = new Categorie("Cadre supérieur", 40, 150000);
        Categorie normal = new Categorie("Normal", 40, 100000);
        Categorie gardien = new Categorie("Gardien", 56, 110000);
        Categorie chauffeur = new Categorie("Chauffeur", 48, 120000);

        Employe Rakoto = new Employe("Rakoto", "123", LocalDate.of(1980, 10, 20),
                LocalDate.of(2020, 05, 10), LocalDate.of(2024, 12, 31), 110000, gardien);
        Employe Rabe = new Employe("Rabe", "124", LocalDate.of(1982, 02, 16),
                LocalDate.of(2021, 04, 20), LocalDate.of(2024, 11, 05), 110000, gardien);

        Calendrier calendrier = new Calendrier();
        calendrier.ajouterJourFerie(LocalDate.of(2024, 06, 17));
        calendrier.ajouterJourFerie(LocalDate.of(2024, 06, 25));
        calendrier.ajouterJourFerie(LocalDate.of(2024, 06, 26));

        calculerHeuresEtSalaire(Rakoto, Rabe, calendrier);
    }

    private static void calculerHeuresEtSalaire(Employe rakoto, Employe rabe, Calendrier calendrier) {
        int joursTravail = 30;
        int joursFeries = 3;
        int heuresJour = 14;
        int heuresNuit = 10;

        int heuresNormalesRakoto = heuresJour * (joursTravail - joursFeries);
        int heuresNormalesRabe = heuresNuit * (joursTravail - joursFeries);

        int heuresFerieesRakoto = joursFeries * heuresJour;
        int heuresFerieesRabe = joursFeries * heuresNuit;

        int heuresSupRakoto = 20;
        int heuresMajoreesRakoto = 2 * 10;

        double salaireBrutRakoto = (heuresNormalesRakoto * rakoto.getCategorie().getTauxHoraire()) +
                (heuresFerieesRakoto * rakoto.getCategorie().getTauxHoraire() * 1.5) +
                (heuresSupRakoto * rakoto.getCategorie().getTauxHoraire());

        double salaireBrutRabe = (heuresNormalesRabe * rabe.getCategorie().getTauxHoraire()) +
                (heuresFerieesRabe * rabe.getCategorie().getTauxHoraire() * 1.3);

        System.out.println("Heures normales Rakoto : " + heuresNormalesRakoto);
        System.out.println("Heures supplémentaires Rakoto : " + heuresSupRakoto);
        System.out.println("Heures fériées Rakoto : " + heuresFerieesRakoto);
        System.out.println("Salaire brut Rakoto: " + salaireBrutRakoto);
        System.out.println("Salaire net Rakoto: " + salaireBrutRakoto * 0.8);

        System.out.println("Heures normales Rabe : " + heuresNormalesRabe);
        System.out.println("Heures fériées Rabe : " + heuresFerieesRabe);
        System.out.println("Salaire brut Rabe: " + salaireBrutRabe);
        System.out.println("Salaire net Rabe: " + salaireBrutRabe * 0.8);
    }

    private static double calculerHeuresMajorees(int heures, double tauxHoraire, double coefficient) {
        return heures * tauxHoraire * coefficient;
    }
}
