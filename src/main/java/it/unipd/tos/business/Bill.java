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

    public Bill(LocalTime t){
        this.t = t;
    }

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icereamCounter = 0;
        double minPriceForIcecream = Double.MAX_VALUE;
        double totWithoutDrinks = 0; 
        
        if(itemsOrdered.size() >= 30) {
            
            throw new TakeAwayBillException("Too much orders");
        }
        
        for(MenuItem mi : itemsOrdered) {
            
            tot += mi.getPrice();
            
            if(!mi.getType().equals(MenuItem.items.Bevanda)) {
                
                totWithoutDrinks += mi.getPrice();
            }
            
            if(mi.getType().equals(MenuItem.items.Gelato)) {
                
                icereamCounter++;
                if(mi.getPrice() < minPriceForIcecream) {
                    
                    minPriceForIcecream = mi.getPrice();
                }
            }
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
        
        return tot;
    }
}
