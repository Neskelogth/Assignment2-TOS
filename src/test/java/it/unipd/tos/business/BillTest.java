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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class BillTest {

    Bill bi; 
    List<MenuItem> li;
    User us;
    
    @Rule
    public Timeout globalTimeout= new Timeout(1000);
    
    @Before
    public void setup (){
        us = new User("Samuel","Kostadinov",21, 1);
        bi = new Bill(LocalTime.of(12,0,0,0), us);
        li = new ArrayList<MenuItem>();
    }
    
    @Test
    public void getUserTest() {
        assertEquals(us,bi.getUser());
    }
    
    @Test
    public void getLocalTimeTest() {
        assertEquals(LocalTime.of(12,0,0,0),bi.getLocalTime());
    }
    
    @Test
    public void getGiftedTest() {
        assertFalse(bi.getWasGifted());
    }

    @Test
    public void ComputeTotalTest() {
        
        li.add(new MenuItem("Cola",MenuItem.items.Bevanda,2.50));
        li.add(new MenuItem("Coppa Nafta",MenuItem.items.Gelato, 4.00));
        li.add(new MenuItem("Banana split",MenuItem.items.Gelato, 10.00));
        try {
            assertEquals(16.50,bi.getOrderPrice(li,us),0.0);
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
    
    @Test
    public void ComputeTotalWith10PercentDiscountTest() {
        
        li.add(new MenuItem("Banana split",MenuItem.items.Gelato, 10.00));
        li.add(new MenuItem("Banana split",MenuItem.items.Gelato, 10.00));
        li.add(new MenuItem("Banana split",MenuItem.items.Gelato, 10.00));
        li.add(new MenuItem("Biancaneve",MenuItem.items.Budino, 10.00));
        li.add(new MenuItem("Biancaneve",MenuItem.items.Budino, 10.00));
        try {
            assertEquals(45,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
            System.out.println("Error");
        }
    }
    
    @Test (expected = TakeAwayBillException.class)
    public void ErrorForNumberOfOrders() throws TakeAwayBillException{
        
        
        for(int i = 0; i < 30; i++) {
            
            li.add(new MenuItem("Cola",MenuItem.items.Bevanda,2.50));
        }
     
        bi.getOrderPrice(li, us);
    }
    
    @Test
    public void lessThen10EurosCommissionTest() {
        
        li.add(new MenuItem("Cola",MenuItem.items.Bevanda,2.50));
        
        try {
            assertEquals(3,bi.getOrderPrice(li,us),0.0);
        }catch(TakeAwayBillException e) {
            System.out.println("Error");
        }
    }
    
    @Test
    public void GiftTest() {
        
        boolean trueFound = false;
        for (int i = 0; i < 1000; i++) {
        
            Bill b = new Bill(LocalTime.of(18,30),new User("Samuel", "Kostadinov", 15, i + 1));
            if(b.getWasGifted()) {
            
                trueFound = true;
            }
        }
        assertTrue(trueFound);
    }
    
    @After
    public void EmptyList() {
     
        li.clear();
    }    
}
