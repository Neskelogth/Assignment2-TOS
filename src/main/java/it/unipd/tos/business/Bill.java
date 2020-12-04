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
        
        for(MenuItem mi : itemsOrdered) {
            
            tot += mi.getPrice();
        }
        
        return tot;
    }

}
