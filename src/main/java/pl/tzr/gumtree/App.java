package pl.tzr.gumtree;


public class App {

    public static void main(String[] args) {
        AddressBookReader addressBookReader = new AddressBookReader();
        AddressBook addressBook = new AddressBook(addressBookReader.load("AddressBook"));

        System.out.println("There are " + addressBook.maleCount() + " males in the address book.");
        System.out.println("The oldest person in the address book is " + addressBook.oldestPerson().get() + ".");
        System.out.println("Bill is older than Paul by " + addressBook.calculateAgeDifferenceInDays("Bill McKnight", "Paul Robinson") + " days.");
    }
}
