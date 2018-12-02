package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.exception.UnsuccessfulOperationException;
import org.junit.Assert;
import org.junit.Test;
import java.lang.RuntimeException;

public class NoAvailableCopiesExceptionTest{

    private static final String MESSAGE = "Test message.";

    @Test
    public void UnsuccessfulOperationExceptionTestNoArg(){
        UnsuccessfulOperationException exception = new UnsuccessfulOperationException();
        Assert.assertNull(exception.getMessage());
    }

    @Test
    public void UnsuccessfulOperationExceptionTestWithMsg(){
        UnsuccessfulOperationException exception = new UnsuccessfulOperationException(MESSAGE);
        Assert.assertEquals(exception.getMessage(),MESSAGE);
    }

    @Test
    public void UnsuccessfulOperationExceptionTestWithMsgAndCause(){
        RuntimeException e = new RuntimeExcpetion(MESSAGE + " Tested!");
        UnsuccessfulOperationException exception = new UnsuccessfulOperationException(MESSAGE, e);

        Assert.assertEquals(exception.getMessage(),MESSAGE);
        Assert.assertNotNull(exception.getCause());
    }

    @Test
    public void UnsuccessfulOperationExceptionTestWithCause(){
        RuntimeException e = new RuntimeExcpetion(MESSAGE + " Tested!");
        UnsuccessfulOperationException exception = new UnsuccessfulOperationException(e);

        Assert.assertEquals(exception.getCause(),e);
        Assert.assertNull(exception.getMessage());
    }
}