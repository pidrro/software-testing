package hu.uni.miskolc.iit.swtest.team3.model.exception;

public class NoAvailableCopiesException extends IllegalStateException {
    public NoAvailableCopiesException() {
        super();
    }

    public NoAvailableCopiesException(String s) {
        super(s);
    }

    public NoAvailableCopiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAvailableCopiesException(Throwable cause) {
        super(cause);
    }
}
