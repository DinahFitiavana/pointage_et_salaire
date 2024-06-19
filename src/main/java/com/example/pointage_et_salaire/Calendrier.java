package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Calendrier {
    private Set<LocalDate> joursFeries;

    public Calendrier() {
        this.joursFeries = new HashSet<>();
    }

    public void ajouterJourFerie(LocalDate date){
        joursFeries.add(date);
    }

    public boolean estJourFerie(LocalDate date){
        return joursFeries.contains(date);
    }
}
