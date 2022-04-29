package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menuuu implements Serializable {
    public int id;
    public String mname;
    public byte[] images;
    public BigDecimal price;
    public String kind;

    public Menuuu(int id, String mname, byte[] images, BigDecimal price, String kind) {
        this.id = id;
        this.mname = mname;
        this.images=images;
        this.price = price;
        this.kind = kind;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
