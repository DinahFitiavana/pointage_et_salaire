package com.example.pointage_et_salaire;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Calendar {
    private List<LocalDate> holidays;

    public Calendar() {
        this.holidays = new ArrayList<>();
    }

    public void addHolidays(LocalDate date){
        holidays.add(date);
    }
}
