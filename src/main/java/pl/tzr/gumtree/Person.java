package pl.tzr.gumtree;

import com.google.common.base.MoreObjects;

import java.time.LocalDate;

public class Person {

    public enum Sex { MALE, FEMALE}

    final String name;

    final Sex sex;
    final LocalDate birthDate;

    public Person(String name, Sex sex, LocalDate birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("sex", sex).add("birthDate", birthDate).toString();
    }

}
