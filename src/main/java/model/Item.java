package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Item implements Serializable {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private java.sql.Date import_date;
    private String imported_by;
    public Item() {
    }
    public Item(String name, BigDecimal price, Integer quantity, java.sql.Date import_date,String imported_by) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.import_date = import_date;
        this.imported_by = imported_by;
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

    public String getImported_by() {
        return imported_by;
    }

    public void setImported_by(String imported_by) {
        this.imported_by = imported_by;
    }
}
