package com.example.pointage_et_salaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Categorie {
    private String nom;
    private int heuresNormales;
    private double salaireNormal;
    //private double indemnité;

    public double getTauxHoraire() {
        return salaireNormal / heuresNormales;
    }
}
