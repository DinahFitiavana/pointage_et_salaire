package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Employee {
    private String name;
    private String registrationNumber;
    private LocalDate birthDate;
    private LocalDate hiringDate;
    private LocalDate endContractDate;
    private float grossSalary;
    private float netSalary;
    private Category category;

    public Employee(String name, String registrationNumber, LocalDate birthDate, LocalDate hiringDate,
                    LocalDate endContractDate, float grossSalary, Category category) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.birthDate = birthDate;
        this.hiringDate = hiringDate;
        this.endContractDate = endContractDate;
        this.grossSalary = grossSalary;
        this.netSalary = (float) (grossSalary * 0.8);
        this.category = category;
    }
}