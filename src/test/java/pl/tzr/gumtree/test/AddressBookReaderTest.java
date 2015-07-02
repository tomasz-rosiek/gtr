package pl.tzr.gumtree.test;

import org.junit.Test;
import pl.tzr.gumtree.AddressBookReader;
import pl.tzr.gumtree.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookReaderTest {

    AddressBookReader reader = new AddressBookReader();

    @Test
    public void shouldProperlyLoadAddressBook() {
        //given
        List<Person> expectedContent =
        newArrayList(
                new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1977, Month.MARCH, 16)),
                new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 15)),
                new Person("Gemma Lane", Person.Sex.FEMALE, LocalDate.of(1991, Month.NOVEMBER, 20)),
                new Person("Sarah Stone", Person.Sex.FEMALE, LocalDate.of(1980, Month.SEPTEMBER, 20)),
                new Person("Wes Jackson", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 14)));

        //when
        List<Person> addressBook = reader.load("AddressBook");

        //then
        assertThat(addressBook).usingFieldByFieldElementComparator().hasSameElementsAs(expectedContent);
    }

    @Test
    public void shouldProperlyLoadAddressBook2() {
        //given
        List<Person> expectedContent =
                newArrayList(
                        new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1957, Month.MARCH, 16)),
                        new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 15)),
                        new Person("Gemma Lane", Person.Sex.FEMALE, LocalDate.of(1991, Month.NOVEMBER, 20)),
                        new Person("Tomasz Rosiek", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 15)),
                        new Person("Wes Jackson", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 14)));

        //when
        List<Person> addressBook = reader.load("AddressBook2");

        //then
        assertThat(addressBook).usingFieldByFieldElementComparator().hasSameElementsAs(expectedContent);
    }

}
