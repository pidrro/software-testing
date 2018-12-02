package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.exception.NoAvailableCopiesException;
import org.junit.Assert;
import org.junit.Test;

public class NoAvailableCopiesExceptionTest{

    private static final String MESSAGE = "Test message.";

    @Test
    public NoAvailableCopiesExceptionTest(){
        NoAvailableCopiesException exception = new NoAvailableCopiesException();
        Assert.assertNull(exception.getMessage());
    }

    @Test
    public NoAvailableCopiesExceptionTestWithMsg(){
        NoAvailableCopiesException exception = new NoAvailableCopiesException(MESSAGE);
        Assert.assertEquals(exception.getMessage(),MESSAGE);
    }

    @Test
    public NoAvailableCopiesExceptionTestWithMsgAndCause(){
        RuntimeException e = new RuntimeExcpetion(MESSAGE + " Tested!");
        NoAvailableCopiesException exception = new NoAvailableCopiesException(MESSAGE, e);

        Assert.assertEquals(exception.getMessage(),MESSAGE);
        Assert.assertNotNull(exception.getCause());
    }

    @Test
    public NoAvailableCopiesExceptionTestWithCause(){
        RuntimeException e = new RuntimeExcpetion(MESSAGE + " Tested!");
        NoAvailableCopiesException exception = new NoAvailableCopiesException(e);

        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(exception.getCause(),e);
    }



}