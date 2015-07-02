package pl.tzr.gumtree;


import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.abs;
import static java.time.LocalDate.from;

public class AddressBook {

    private final List<Person> people;

    public AddressBook(List<Person> people) {
        this.people = people;
    }

    public long maleCount() {
        return people.stream().filter(p -> p.getSex() == Person.Sex.MALE).count();
    }

    public Optional<String> oldestPerson() {
        return people.stream().sorted((o1, o2) -> o1.getBirthDate().compareTo(o2.getBirthDate())).
                findFirst().
                map(p -> p.getName());
    }

    public long calculateAgeDifferenceInDays(String personName1, String personName2) {
        Person person1 = searchForPersonByName(personName1);
        Person person2 = searchForPersonByName(personName2);
        return abs(from(person1.getBirthDate()).until(person2.getBirthDate(), ChronoUnit.DAYS));
    }

    private Person searchForPersonByName(String personName) {
        return people.stream().
                filter(p -> p.getName().equals(personName)).
                findFirst().
                orElseThrow(() -> new PersonNotFoundException(personName));
    }
}
