////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;
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
        
        for(MenuItem mi : itemsOrdered) {
            
            tot += mi.getPrice();
            
            if(mi.getType().equals(MenuItem.items.Gelato)) {
                
                icereamCounter++;
                if(mi.getPrice() < minPriceForIcecream) {
                    
                    minPriceForIcecream = mi.getPrice();
                }
            }
        }
        
        if(icereamCounter >= 5) {
         
            tot -= minPriceForIcecream / 2;
        }
        
        return tot;
    }
}
