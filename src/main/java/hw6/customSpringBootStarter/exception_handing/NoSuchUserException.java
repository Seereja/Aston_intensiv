package hw6.customSpringBootStarter.exception_handing;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
