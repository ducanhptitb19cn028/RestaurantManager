
package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    
    private String cname;
    private BigDecimal price;

    private int quantity;
    public CartItem(){

    }
    public CartItem(String cname, BigDecimal price,int quantity){
        this.cname = cname;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
