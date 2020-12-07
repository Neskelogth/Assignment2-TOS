////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends Throwable{

    private String msg;
    
  public TakeAwayBillException(String m){
      
      this.msg = m;
  }
  
  public String getMessage() {
      
      return msg;
  }
}
