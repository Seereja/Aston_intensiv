package hw6.custamSpringBootStarter.exception_handing;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
