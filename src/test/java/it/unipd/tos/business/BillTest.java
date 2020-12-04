////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.Bill;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class BillTest {

    Bill bi; 
    List<MenuItem> li;
    User us;

    @Before
    public void setup (){
        bi = new Bill(LocalTime.of(12,0,0,0));
        li = new ArrayList<MenuItem>();
        li.add(new MenuItem("Cola",MenuItem.items.Budino,2.50));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        us = new User("Samuel","Kostadinov",21, 1);
    }

    @Test
    public void ComputeTotalTest() {
        
        try {
        assertEquals(6.50,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Error");
        }
    }
}
