package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.exception.IllegalStatusChangeException;
import org.junit.Assert;
import org.junit.Test;
import java.lang.RuntimeException;

public class IllegalStatusChangeExceptionTest{

    private static final String MESSAGE = "Test message.";

    @Test
    public void IllegalStatusChangeExceptionTestNoArg(){
        IllegalStatusChangeException exception = new IllegalStatusChangeException();
        Assert.assertNull(exception.getMessage());
    }

    @Test
    public void IllegalStatusChangeExceptionTestWithMsg(){
        IllegalStatusChangeException exception = new IllegalStatusChangeException(MESSAGE);
        Assert.assertEquals(exception.getMessage(),MESSAGE);
    }

    @Test
    public void IllegalStatusChangeExceptionTestWithMsgAndCause(){
        RuntimeException e = new RuntimeException(MESSAGE + " Tested!");
        IllegalStatusChangeException exception = new IllegalStatusChangeException(MESSAGE, e);

        Assert.assertEquals(exception.getMessage(),MESSAGE);
        Assert.assertNotNull(exception.getCause());
    }

    @Test
    public void IllegalStatusChangeExceptionTestWithCause(){
        RuntimeException e = new RuntimeException(MESSAGE + " Tested!");
        IllegalStatusChangeException exception = new IllegalStatusChangeException(e);

        Assert.assertNotNull(exception.getMessage());
        Assert.assertEquals(exception.getCause(),e);
    }
}