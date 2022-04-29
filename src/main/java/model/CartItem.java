
package model;

import java.math.BigDecimal;

public class CartItem {
    
    public String cname;
    public BigDecimal price;

    public int quantity;
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
