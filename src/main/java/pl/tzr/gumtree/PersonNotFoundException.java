package pl.tzr.gumtree;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String personName) {
        super("Person " + personName + " not found.");
    }
}
