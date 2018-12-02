package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.exception.NoAvailableCopiesException;
import org.junit.Assert;
import org.junit.Test;
import java.lang.RuntimeException;

public class NoAvailableCopiesExceptionTest{

    private static final String MESSAGE = "Test message.";

    @Test
    public void NoAvailableCopiesExceptionTestNoArg(){
        NoAvailableCopiesException exception = new NoAvailableCopiesException();
        Assert.assertNull(exception.getMessage());
    }

    @Test
    public void NoAvailableCopiesExceptionTestWithMsg(){
        NoAvailableCopiesException exception = new NoAvailableCopiesException(MESSAGE);
        Assert.assertEquals(exception.getMessage(),MESSAGE);
    }

    @Test
    public void NoAvailableCopiesExceptionTestWithMsgAndCause(){
        RuntimeException e = new RuntimeException(MESSAGE + " Tested!");
        NoAvailableCopiesException exception = new NoAvailableCopiesException(MESSAGE, e);

        Assert.assertEquals(exception.getMessage(),MESSAGE);
        Assert.assertNotNull(exception.getCause());
    }

    @Test
    public void NoAvailableCopiesExceptionTestWithCause(){
        RuntimeException e = new RuntimeException(MESSAGE + " Tested!");
        NoAvailableCopiesException exception = new NoAvailableCopiesException(e);

        Assert.assertEquals(exception.getMessage(),e.getMessage());
        Assert.assertEquals(exception.getCause(),e);
    }
}