package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Calendar {
    private Set<LocalDate> holidays;

    public Calendar() {
        this.holidays = new HashSet<>();
    }

    public void addHolidays(LocalDate date){
        holidays.add(date);
    }
}
