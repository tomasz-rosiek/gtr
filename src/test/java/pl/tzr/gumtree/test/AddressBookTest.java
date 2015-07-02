package pl.tzr.gumtree.test;

import org.junit.Test;
import pl.tzr.gumtree.AddressBook;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class AddressBookTest {

    AddressBook addressBook = new AddressBook();

    @Test
    public void addressBookShouldProperlyCountMales() {
        assertThat(addressBook.maleCount()).isEqualTo(3);
    }

    @Test
    public void addressBookShouldFindOldestPerson() {
        assertThat(addressBook.oldestPerson()).isEqualTo("Wes Jackson");
    }

    @Test
    public void addressBookShouldCalculateAgeDifferenceBetweenBillAndPaul() {
        assertThat(addressBook.calculateAgeDifferenceInDays("Bill McKnight", "Paul Robinson")).isEqualTo(1024);
    }

}
