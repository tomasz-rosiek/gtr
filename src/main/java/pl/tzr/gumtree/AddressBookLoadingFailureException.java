package pl.tzr.gumtree;

public class AddressBookLoadingFailureException extends RuntimeException {

    public AddressBookLoadingFailureException(String message) {
        super(message);
    }

    public AddressBookLoadingFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
