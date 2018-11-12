package hu.uni.miskolc.iit.swtest.team3.model.test;

import hu.uni.miskolc.iit.swtest.team3.model.BorrowStatus;
import org.junit.Assert;
import org.junit.Test;

public class BorrowStatusTest {

    private static final String REQUESTED_NAME =  "REQUESTED";
    private static final String BORROWED_NAME =  "BORROWED";
    private static final String RETURNED_NAME =  "RETURNED";

    @Test
    public void statusTest() {
        BorrowStatus status = BorrowStatus.valueOf(REQUESTED_NAME);
        Assert.assertEquals(REQUESTED_NAME, status.name());

        status = BorrowStatus.valueOf(BORROWED_NAME);
        Assert.assertEquals(BORROWED_NAME, status.name());

        status = BorrowStatus.valueOf(RETURNED_NAME);
        Assert.assertEquals(RETURNED_NAME, status.name());
    }
}
