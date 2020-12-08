////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class Bill implements TakeAwayBill {

    private LocalTime t;
    private boolean wasGifted = false;
    private User u;
    private static CashDesk cd = new CashDesk();
    
    public Bill(LocalTime t, User user){
        this.t = t;
        this.u = user;
        cd.addBill(this);
        this.wasGifted = cd.gift();
    }
    
    public LocalTime getLocalTime() {
        return t;
    }    
    
    public User getUser() {
        return u;
    }
    
    public boolean getWasGifted() {
        return wasGifted;
    }

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icereamCounter = 0;
        double minPriceForIcecream = Double.MAX_VALUE;
        double totWithoutDrinks = 0; 
        
        if(itemsOrdered.size() >= 30) {
            
            throw new TakeAwayBillException("Too much orders");
        }
        
        if(!wasGifted){
            
            for(MenuItem mi : itemsOrdered) {
                
                if(mi.getType() == MenuItem.items.Gelato) {
                    
                    icereamCounter++;
                    if(mi.getPrice() < minPriceForIcecream) {
                        
                        minPriceForIcecream = mi.getPrice();
                    }
                }
                if(mi.getType() != MenuItem.items.Bevanda) {
                    
                    totWithoutDrinks += mi.getPrice();
                }
                tot += mi.getPrice();
            }
        
            if (tot < 10) {
            
                tot += 0.5;
            }
        
            if(totWithoutDrinks >= 50) {
                tot *= 0.9;
            }
        
            if(icereamCounter >= 5) {
         
                tot -= minPriceForIcecream / 2;
            }
        }
        return tot;
    
    }
}
