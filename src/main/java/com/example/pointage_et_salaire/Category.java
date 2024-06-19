package com.example.pointage_et_salaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private String name;
    private int normalWorkingHour;
    private double normalSalary;
    //private double compensation;

    public double getHourlyRate() {
        return normalSalary / normalWorkingHour;
    }
}
