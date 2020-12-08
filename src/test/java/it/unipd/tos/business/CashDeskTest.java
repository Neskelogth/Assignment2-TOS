////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.User;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;



public class CashDeskTest {

    private List<Bill> billList;
    private List<User> userList;
    private CashDesk cd;
    private User u;
    
    @Before
    public void setUp() {
        billList = new ArrayList<Bill> ();
        userList = new ArrayList<User> ();
        cd = new CashDesk();
        u = new User("Samuel", "Kostadinov", 21, 1);
    }
    
    @Test
    public void getGiftedCountTest(){
        
        billList = new ArrayList<Bill>();
        userList = new ArrayList<User>();
        
        billList.add(new Bill(LocalTime.of(15, 0), u));
        userList.add(u);
        
        assertEquals(0,cd.getGiftedCount());
    }
    
    @Test
    public void getListBillTest(){
        
        billList = new ArrayList<Bill>();
        userList = new ArrayList <User> ();
        
        Bill b = new Bill(LocalTime.of(17, 0), u);
        
        billList.add(b);
        userList.add(u);
        
        CashDesk cad = new CashDesk(billList, userList);
        
        assertEquals(billList,cad.getListBill());
    }
    
    @Test
    public void getListUserTest(){
        
        billList = new ArrayList<Bill>();
        userList = new ArrayList <User> ();
        
        Bill b = new Bill(LocalTime.of(17, 0), u);
        
        billList.add(b);
        userList.add(u);
        
        cd = new CashDesk(billList, userList);
        
        assertEquals(userList,cd.getListUser());
    }
    
    @Test
    public void addBilltest(){
        
        cd = new CashDesk();
        
        Bill b = new Bill(LocalTime.of(12,0,0,0), u);
        cd.addBill(b);
        assertEquals(b,cd.getListBill().get(cd.getListBill().size()-1));
    }
    
   @Test
    public void giftFailureWithUserNotUnderageAndPossibleTimeTest(){
        cd.addBill(new Bill(LocalTime.of(18,40), u));
        assertFalse(cd.gift());
    }
    
    @Test
    public void giftFailureWithTimeNotBetween18And19AndPossibleUserTest(){
        User user = new User("Samuel", "Kostadinov", 15, 2);
        cd.addBill(new Bill(LocalTime.of(19,40), user));
        assertFalse(cd.gift());
    }
    
    @Test
    public void giftFailureForUserBothNotUnderageAndInWrongTimeSlotTest(){
        
        cd.addBill(new Bill(LocalTime.of(17,10),u));
        assertFalse(cd.gift());
    }
    
    @Test
    public void giftFailureForUserComingAgainInTheShop(){
        
        User user = new User("Samuel", "Kostadinov", 17, 3);
        cd.addBill(new Bill(LocalTime.of(18,40), user));
        cd.addBill(new Bill(LocalTime.of(18,50), user));
        assertFalse(cd.gift());
    }

    @Test
    public void giftSuccessByHavingBothATrueResultAndAFalseResultFinalTest(){
        
        boolean trueFound = false, falseFound = true;
        for(int i = 0;i < 1000;i++) {
        
            cd.addBill(new Bill(LocalTime.of(18,40),new User("Samuel","Kostadinov",10, i)));
            boolean b = cd.gift();
            if(b){
            
                trueFound=b;
            }
            else falseFound=b;
        }
        assertTrue(trueFound && !falseFound);
    }
}