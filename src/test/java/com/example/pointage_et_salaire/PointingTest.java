package com.example.pointage_et_salaire;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointingTest {
    @Test
    void tester() {
        Category cadreSuperieur = new Category("Cadre supérieur", 40, 150000);
        Category normal = new Category("Normal", 40, 100000);
        Category gardien = new Category("Gardien", 56, 110000);
        Category chauffeur = new Category("Chauffeur", 48, 120000);

        Employee rakoto = new Employee("Rakoto", "123", LocalDate.of(1980, 10, 20),
                LocalDate.of(2020, 05, 10), LocalDate.of(2024, 12, 31), 110000, gardien);
        Employee rabe = new Employee("Rabe", "124", LocalDate.of(1982, 02, 16),
                LocalDate.of(2021, 04, 20), LocalDate.of(2024, 11, 05), 110000, gardien);

        Calendar calendar = new Calendar();
        calendar.addHolidays(LocalDate.of(2024, 06, 17));
        calendar.addHolidays(LocalDate.of(2024, 06, 25));
        calendar.addHolidays(LocalDate.of(2024, 06, 26));

        int workDays = 42;
        int holidays = 3;
        int dayTime = 10;
        int NightTime = 14;

        int normalHourRakoto = dayTime * (workDays - holidays);
        assertEquals(420, normalHourRakoto);

        int normalHourRabe = NightTime * (workDays - holidays);
        assertEquals(588, normalHourRabe);

        int holidayTimeRakoto = holidays * dayTime;
        int holidayTimeRabe = holidays * NightTime;

        int additionalHourRakoto = 28;
        int increasedHourRakoto = 20;

        double grossSalaryRakoto = (normalHourRakoto * rakoto.getCategory().getHourlyRate()) +
                (holidayTimeRakoto * rakoto.getCategory().getHourlyRate() * 1.3) +
                (additionalHourRakoto * rakoto.getCategory().getHourlyRate());
        assertEquals(796713.918, grossSalaryRakoto);

        double grossSalaryRabe = (normalHourRabe * rabe.getCategory().getHourlyRate()) +
                (holidayTimeRabe * rabe.getCategory().getHourlyRate() * 1.5);
        assertEquals(780000, grossSalaryRabe);
    }
}