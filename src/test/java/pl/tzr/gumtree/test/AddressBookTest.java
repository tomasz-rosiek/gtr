package pl.tzr.gumtree.test;

import org.junit.Test;
import pl.tzr.gumtree.AddressBook;
import pl.tzr.gumtree.Person;
import pl.tzr.gumtree.PersonNotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

public class AddressBookTest {

    AddressBook addressBook1 = new AddressBook(newArrayList(
                    new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1977, Month.MARCH, 16)),
                    new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 16)),
                    new Person("Gemma Lane", Person.Sex.FEMALE, LocalDate.of(1991, Month.NOVEMBER, 20)),
                    new Person("Sarah Stone", Person.Sex.FEMALE, LocalDate.of(1980, Month.SEPTEMBER, 20)),
                    new Person("Wes Jackson", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 14))
            )
    );

    AddressBook addressBook2 = new AddressBook(newArrayList(
                    new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1957, Month.MARCH, 16)),
                    new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 16)),
                    new Person("Gemma Lane", Person.Sex.FEMALE, LocalDate.of(1991, Month.NOVEMBER, 20)),
                    new Person("Tomasz Rosiek", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 15)),
                    new Person("Wes Jackson", Person.Sex.MALE, LocalDate.of(1974, Month.AUGUST, 14))
            )
    );

    AddressBook emptyAddressBook = new AddressBook(newArrayList());

    @Test
    public void addressBookShouldProperlyCountMales() {
        assertThat(addressBook1.maleCount()).isEqualTo(3);
    }

    @Test
    public void addressBookShouldProperlyCountMalesInAnotherDataset() {
        assertThat(addressBook2.maleCount()).isEqualTo(4);
    }

    @Test
    public void addressBookShouldProperlyCountMalesInEmptyDataset() {
        assertThat(emptyAddressBook.maleCount()).isEqualTo(0);
    }

    @Test
    public void addressBookShouldFindOldestPerson() {
        assertThat(addressBook1.oldestPerson()).isEqualTo(Optional.of("Wes Jackson"));
    }

    @Test
    public void addressBookShouldFindOldestPersonInAnotherDataset() {
        assertThat(addressBook2.oldestPerson()).isEqualTo(Optional.of("Bill McKnight"));
    }

    @Test
    public void addressBookShouldReturnNoneInEmptyDataset() {
        assertThat(emptyAddressBook.oldestPerson()).isEqualTo(Optional.empty());
    }

    @Test
    public void addressBookShouldCalculateAgeDifferenceBetweenBillAndPaul() {
        assertThat(addressBook1.calculateAgeDifferenceInDays("Bill McKnight", "Paul Robinson")).isEqualTo(2863);
    }

    @Test
    public void addressBookShouldCalculateAgeDifferenceBetweenTomaszAndWes() {
        assertThat(addressBook2.calculateAgeDifferenceInDays("Wes Jackson", "Tomasz Rosiek")).isEqualTo(1);
    }

    @Test
    public void addressBookShouldCalculateAgeDifferenceBetweenWesAndTomasz() {
        assertThat(addressBook2.calculateAgeDifferenceInDays("Tomasz Rosiek", "Wes Jackson")).isEqualTo(1);
    }

    @Test
    public void addressBookShouldThrowExceptionIfCalculatingAgeDifferenceForMissingPerson1() {
        assertThatThrownBy(() -> assertThat(addressBook2.calculateAgeDifferenceInDays("Tony Halik", "Wes Jackson"))).
                isInstanceOf(PersonNotFoundException.class)
                .hasMessageContaining("Tony Halik");
    }

    @Test
    public void addressBookShouldThrowExceptionIfCalculatingAgeDifferenceForMissingPerson2() {
        assertThatThrownBy(() -> assertThat(addressBook2.calculateAgeDifferenceInDays("Wes Jackson", "Tony Halik"))).
                isInstanceOf(PersonNotFoundException.class)
                .hasMessageContaining("Tony Halik");
    }
}
