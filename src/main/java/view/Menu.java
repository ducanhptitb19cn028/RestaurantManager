package view;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menu implements Serializable {
    public String food;
    public String images;
    public BigDecimal price;
    public String unit;

    public Menu(String food, String images, BigDecimal price, String unit) {
        this.food=food;
        this.images=images;
        this.price = price;
        this.unit = unit;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return images;
    }
}
