package com.example.pointage_et_salaire;

import java.time.LocalDate;
import java.util.logging.Logger;

public class PointingTest {
    private static final Logger logger = Logger.getLogger(PointingTest.class.getName());

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
        int dayTime = 8;
        int NightTime = 8;

        int normalHourRakoto = dayTime * (workDays - holidays);
        int normalHourRabe = NightTime * (workDays - holidays);

        int holidayTimeRakoto = holidays * dayTime;
        int holidayTimeRabe = holidays * NightTime;

        int additionalHourRakoto = 16;
        int increasedHourRakoto = 2 * 8;

        double salaireBrutRakoto = (normalHourRakoto * rakoto.getCategory().getHourlyRate()) +
                (holidayTimeRakoto * rakoto.getCategory().getHourlyRate() * 1.3) +
                (additionalHourRakoto * rakoto.getCategory().getHourlyRate());

        double grossSalaryRabe = (normalHourRabe * rabe.getCategory().getHourlyRate()) +
                (holidayTimeRabe * rabe.getCategory().getHourlyRate() * 1.5);


        logger.info("Heures normales Rakoto : " + normalHourRakoto + " heures");
        logger.info("Heures supplémentaires Rakoto : " + additionalHourRakoto + " heures");
        logger.info("Heures fériées Rakoto : " + holidayTimeRakoto + " heures");
        logger.info("Salaire brut Rakoto: " + salaireBrutRakoto + " Ariary");
        logger.info("Salaire net Rakoto: " + salaireBrutRakoto * 0.8);

        logger.info("Heures normales Rabe : " + normalHourRabe + " heures");
        logger.info("Heures supplémentaires Rabe: " + 0 + " heures");
        logger.info("Heures fériées Rabe : " + holidayTimeRabe + " heures");
        logger.info("Salaire brut Rabe: " + grossSalaryRabe + " Ariary");
        logger.info("Salaire net Rabe: " + grossSalaryRabe * 0.8 + " Ariary");
    }
}