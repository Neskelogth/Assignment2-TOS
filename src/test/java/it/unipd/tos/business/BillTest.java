////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class BillTest {

    Bill bi; 
    List<MenuItem> li;
    User us;

    @Before
    public void setup (){
        bi = new Bill(LocalTime.of(12,0,0,0));
        li = new ArrayList<MenuItem>();
        us = new User("Samuel","Kostadinov",21, 1);
    }

    @Test
    public void ComputeTotalTest() {
        
        li.add(new MenuItem("Cola",MenuItem.items.Bevanda,2.50));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        try {
            assertEquals(6.50,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
            System.out.println("Error");
        }
    }
    
    @Test
    public void ComputeTotlaWith5IcecreamsTest() {
        
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        try {
            assertEquals(18.00,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
            System.out.println("Error");
        }
    }
    
    @After
    public void EmptyList() {
     
        li.clear();
    }    
}
