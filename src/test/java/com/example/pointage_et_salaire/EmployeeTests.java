package com.example.pointage_et_salaire;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTests {
    @Test
    void testWorkHoursAndSalary() {
        Category gardien = new Category("Gardien", 56, 100000);

        Employee rakoto = new Employee("Rakoto", "123", LocalDate.of(1980, 10, 20),
                LocalDate.of(2020, 05, 10), LocalDate.of(2024, 12, 31), 100000, gardien);
        Employee rabe = new Employee("Rabe", "124", LocalDate.of(1982, 02, 16),
                LocalDate.of(2021, 04, 20), LocalDate.of(2024, 11, 05), 100000, gardien);

        Calendar calendar = new Calendar();
        calendar.addHolidays(LocalDate.of(2024, 06, 26));

        int workDays = 42;
        int dayTime = 10;
        int nightTime = 14;

        int normalHourRakoto = dayTime * (workDays - 1);
        int holidayHourRakoto = dayTime;
        assertEquals(410, normalHourRakoto);
        assertEquals(10, holidayHourRakoto);

        int normalHourRabe = nightTime * (workDays - 1);
        int holidayHourRabe = nightTime;
        assertEquals(574, normalHourRabe);
        assertEquals(14, holidayHourRabe);

        double hourlyRateRakoto = rakoto.getGrossSalary() / 70;
        double grossSalaryRakoto = (normalHourRakoto * hourlyRateRakoto) +
                (holidayHourRakoto * hourlyRateRakoto * 1.5);
        assertEquals(607142.8, grossSalaryRakoto);

        double hourlyRateRabe = hourlyRateRakoto;
        double grossSalaryRabe = (normalHourRabe * hourlyRateRabe) +
                (holidayHourRabe * hourlyRateRabe );
        assertEquals(770714.29, grossSalaryRabe);

        double netSalaryRakoto = grossSalaryRakoto * 0.8;
        double netSalaryRabe = grossSalaryRabe * 0.8;

        assertEquals(485714.29, netSalaryRakoto);
        assertEquals(616571.43, netSalaryRabe);
    }
}
