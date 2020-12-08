////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.User;
import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class CashDesk {

    private List<Bill> billList;
    private List<User> userList;
    private LocalTime initialTime = LocalTime.of(18, 00);
    private LocalTime finalTime = LocalTime.of(19, 00);
    private int giftedCount = 0;

    CashDesk(){
        billList = new ArrayList<Bill>();
        userList = new ArrayList<User>();
    }

    CashDesk(List<Bill> bList,List<User> uList){
        billList = bList;
        userList = uList; 
    }

    public List<Bill> getListBill(){
        return billList;
    }

    public List<User> getListUser(){
        return userList;
    }

    public int getGiftedCount(){
    
        return giftedCount;
    }

    public void addBill(Bill b){
        billList.add(b);
        userList.add(b.getUser());
    }

    public boolean gift(){

    if(!(billList.get(billList.size()-1).getLocalTime().isAfter(initialTime) && billList.get(billList.size()-1).getLocalTime().isBefore(finalTime)) || (!userList.get(userList.size()-1).isMinorenne())){ 
        return false;
    }
    for(int i = 0;i <= userList.size()-2;i++) {
        if(userList.get(i).getId()== (userList.get(userList.size()-1).getId()) && userList.get(i).getName()== (userList.get(userList.size()-1).getName()) && userList.get(i).getSurname()== (userList.get(userList.size()-1).getSurname()) && userList.get(i).getAge()== (userList.get(userList.size()-1).getAge())) {
                        return false;
        }
    }
        
    if(new Random().nextInt()%2==1 && giftedCount<10){ 
        giftedCount++;
        return true;
    }
    return false;
    }
}