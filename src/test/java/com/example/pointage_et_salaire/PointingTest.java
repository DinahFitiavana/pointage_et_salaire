package com.example.pointage_et_salaire;

import java.time.LocalDate;

public class PointingTest {
    public static void main(String[] args) {
        Category cadreSuperieur = new Category("Cadre supérieur", 40, 150000);
        Category normal = new Category("Normal", 40, 100000);
        Category gardien = new Category("Gardien", 56, 110000);
        Category chauffeur = new Category("Chauffeur", 48, 120000);

        Employee Rakoto = new Employee("Rakoto", "123", LocalDate.of(1980, 10, 20),
                LocalDate.of(2020, 05, 10), LocalDate.of(2024, 12, 31), 110000, gardien);
        Employee Rabe = new Employee("Rabe", "124", LocalDate.of(1982, 02, 16),
                LocalDate.of(2021, 04, 20), LocalDate.of(2024, 11, 05), 110000, gardien);

        Calendar calendar = new Calendar();
        calendar.addHolidays(LocalDate.of(2024, 06, 17));
        calendar.addHolidays(LocalDate.of(2024, 06, 25));
        calendar.addHolidays(LocalDate.of(2024, 06, 26));

        calculHoursAndSalary(Rakoto, Rabe, calendar);
    }

    private static void calculHoursAndSalary(Employee rakoto, Employee rabe, Calendar calendar) {
        int workDays = 30;
        int holidays = 3;
        int dayTime = 14;
        int NightTime = 10;

        int normalHourRakoto = dayTime * (workDays - holidays);
        int normalHourRabe = NightTime * (workDays - holidays);

        int holidayTimeRakoto = holidays * dayTime;
        int holidayTimeRabe = holidays * NightTime;

        int additionalHourRakoto = 20;
        int increasedHourRakoto = 2 * 10;

        double salaireBrutRakoto = (normalHourRakoto * rakoto.getCategory().getHourlyRate()) +
                (holidayTimeRakoto * rakoto.getCategory().getHourlyRate() * 1.5) +
                (additionalHourRakoto * rakoto.getCategory().getHourlyRate());

        double grossSalaryRabe = (normalHourRabe * rabe.getCategory().getHourlyRate()) +
                (holidayTimeRabe * rabe.getCategory().getHourlyRate() * 1.3);

        System.out.println("Heures normales Rakoto : " + normalHourRakoto);
        System.out.println("Heures supplémentaires Rakoto : " + additionalHourRakoto);
        System.out.println("Heures fériées Rakoto : " + holidayTimeRakoto);
        System.out.println("Salaire brut Rakoto: " + salaireBrutRakoto);
        System.out.println("Salaire net Rakoto: " + salaireBrutRakoto * 0.8);

        System.out.println("Heures normales Rabe : " + normalHourRabe);
        System.out.println("Heures fériées Rabe : " + holidayTimeRabe);
        System.out.println("Salaire brut Rabe: " + grossSalaryRabe);
        System.out.println("Salaire net Rabe: " + grossSalaryRabe * 0.8);
    }
}