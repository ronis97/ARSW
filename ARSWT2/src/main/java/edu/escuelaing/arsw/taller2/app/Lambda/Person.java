package edu.escuelaing.arsw.taller2.app.Lambda;

import java.time.LocalDate;

public class Person {
    public enum Sex {MALE, FEMALE}

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 0;
        // ...
    }

    public void printPerson() {
        // ...
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
