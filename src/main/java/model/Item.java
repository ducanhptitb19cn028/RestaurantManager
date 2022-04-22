package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Item {
    public String name;
    public BigDecimal price;
    public Integer quantity;
    public java.sql.Date import_date;

    public Item() {
    }
    public Item(String name, BigDecimal price, Integer quantity, java.sql.Date import_date) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.import_date = import_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getImported_date() {
        return import_date;
    }

    public void setImported_date(Date import_date) {
        this.import_date = import_date;
    }
}
