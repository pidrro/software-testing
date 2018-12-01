package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.exception.NoAvailableCopiesException;
import org.junit.Assert;
import org.junit.Test;

public class NoAvailableCopiesExceptionTest extends IllegalStateException{

    private static final String MESSAGE = "Test message.";
    private final NoAvailableCopiesException exception = new NoAvailableCopiesException(MESSAGE);

    @Test
    public NoAvailableCopiesExceptionTestWithMsg(){
        Assert.assertEquals(exception.getMessage(),MESSAGE);
    }

}