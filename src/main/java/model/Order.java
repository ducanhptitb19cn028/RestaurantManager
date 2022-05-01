package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Order implements Serializable {
    private int quantity;


    private BigDecimal price;
    private java.sql.Date orderday;

    public Order(  int quantity, BigDecimal price,java.sql.Date orderday) {
        this.quantity = quantity;
        this.price = price;
        this.orderday= orderday;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrderday() {
        return orderday;
    }

    public void setOrderday(Date orderday) {
        this.orderday = orderday;
    }
}
