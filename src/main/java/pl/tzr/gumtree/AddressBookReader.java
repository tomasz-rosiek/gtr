package pl.tzr.gumtree;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class AddressBookReader {

    public List<Person> load(String location) {

        return newArrayList(
                new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1977, Month.MARCH, 16)),
                new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 16)),
                new Person("Gemma Lane", Person.Sex.FEMALE, LocalDate.of(1991, Month.NOVEMBER, 20)),
                new Person("Sarah Stone", Person.Sex.FEMALE, LocalDate.of(1980, Month.SEPTEMBER, 20)),
                new Person("Wes Jackson", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 14)));

    }
}
