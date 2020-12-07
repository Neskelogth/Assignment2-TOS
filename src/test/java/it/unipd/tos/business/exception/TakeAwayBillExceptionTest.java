package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TakeAwayBillExceptionTest {

    @Test
    public void getMessageTest() {
        
        String s = "Too much orders";
        TakeAwayBillException exc = new TakeAwayBillException(s);
        assertEquals(s, exc.getMessage());
    }
    
}
