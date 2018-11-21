package hu.uni.miskolc.iit.swtest.team3.model.exception;

public class UnsuccessfulOperationException extends RuntimeException {
    public UnsuccessfulOperationException() {
        super();
    }

    public UnsuccessfulOperationException(String message) {
        super(message);
    }

    public UnsuccessfulOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsuccessfulOperationException(Throwable cause) {
        super(cause);
    }
}
