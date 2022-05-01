
package model;

import java.io.Serializable;
import java.math.BigDecimal;


public class Cart implements Serializable {
   private String cname;
   private BigDecimal price;
   private int num;
   public Cart(String cname, BigDecimal price, int num){
       this.cname = cname;
       this.price = price;
       this.num = num;
   }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
}
