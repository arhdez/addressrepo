package example.addressrepo.validation;

public class DoesNotExistsException extends RuntimeException {
    public DoesNotExistsException(String message) {
        super(message);
    }
}
