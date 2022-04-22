package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menuuu implements Serializable {
    public int id;
    public String food;
    public byte[] images;
    public BigDecimal price;
    public String unit;

    public Menuuu(int id, String food, byte[] images, BigDecimal price, String unit) {
        this.id = id;
        this.food=food;
        this.images=images;
        this.price = price;
        this.unit = unit;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
