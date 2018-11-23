package hu.uni.miskolc.iit.swtest.team3.model.exception;

public class IllegalStatusChangeException extends RuntimeException {
    public IllegalStatusChangeException() {
        super();
    }

    public IllegalStatusChangeException(String message) {
        super(message);
    }

    public IllegalStatusChangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalStatusChangeException(Throwable cause) {
        super(cause);
    }
}
