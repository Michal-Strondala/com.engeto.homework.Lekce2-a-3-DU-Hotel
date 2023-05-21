package com.engeto.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Guest {

    //region Guest`s Attributes
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    //endregion

    //region Guest`s Constructors
    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public Guest(String name) {
        this.name = name;

    }
    //endregion

    //region Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    @Override
    public String toString() {
        if (dateOfBirth == null && surname == null) {
            return name;
        }

        return name + " " + surname + " (" + this.formatDate(dateOfBirth) + ")";
    }

    //Metoda na zformátování data z anglického na české
    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("cs", "CZ"));
        return date.format(formatter);
    }
    //endregion
}

