package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Labour implements Serializable {
    public String email;
    public String date_ofBirth;
    public String phone;
    public String address;
    public String position;
    public String name;

    public BigDecimal salary;

    public Labour(String name,String date_ofBirth ,String email,String phone,String address,String position, BigDecimal salary) {
        this.name = name;
        this.date_ofBirth = date_ofBirth;
        this.email=email;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.salary = salary;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
