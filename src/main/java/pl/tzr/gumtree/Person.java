package pl.tzr.gumtree;

import java.util.Date;

public class Person {

    public enum Sex { MALE, FEMALE}

    final String name;
    final String surname;
    final Sex sex;
    final Date birthDate;

    public Person(String name, String surname, Sex sex, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthDate = birthDate;
    }

}
