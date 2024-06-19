package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Pointage {
    private Employe employe;
    private Map<LocalDate, Integer> heuresTravail;

    public Pointage(Employe employe) {
        this.employe = employe;
        this.heuresTravail = new HashMap<>();
    }

    public void ajouterHeures(LocalDate date, int heures) {
        heuresTravail.put(date, heures);
    }

    public int calculerHeuresNormales() {
        int totalHeures = heuresTravail.values().stream().mapToInt(Integer::intValue).sum();
        int heuresNormales = Math.min(totalHeures, employe.getCategorie().getHeuresNormales());
        return heuresNormales;
    }

    public int calculerHeuresSupplementaires() {
        int totalHeures = heuresTravail.values().stream().mapToInt(Integer::intValue).sum();
        int heuresSupplementaires = Math.max(0, totalHeures - employe.getCategorie().getHeuresNormales());
        return Math.min(heuresSupplementaires, 20);
    }

    public double calculerSalaire() {
        int heuresNormales = calculerHeuresNormales();
        int heuresSupplementaires = calculerHeuresSupplementaires();

        double tauxHoraire = employe.getCategorie().getTauxHoraire();
        double salaire = heuresNormales * tauxHoraire;

        if (heuresSupplementaires > 0) {
            int hs30 = Math.min(heuresSupplementaires, 8);
            int hs50 = Math.max(0, heuresSupplementaires - 8);
            salaire += hs30 * tauxHoraire * 1.3 + hs50 * tauxHoraire * 1.5;
        }

        return salaire;
    }

}
