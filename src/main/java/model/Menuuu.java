package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menuuu implements Serializable {
    private int id;
    private String mname;
    private byte[] images;
    private BigDecimal price;
    private String kind;
    private String added_by;

    public Menuuu(int id, String mname, byte[] images, BigDecimal price, String kind) {
        this.id = id;
        this.mname = mname;
        this.images=images;
        this.price = price;
        this.kind = kind;
    }
    public Menuuu(String added_by){
        this.added_by = added_by;
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

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }
}
