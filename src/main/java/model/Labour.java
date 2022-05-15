package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Labour implements Serializable {
    private String email;
    private String date_ofBirth;
    private String phone;
    private String address;
    private String position;
    private String name;

    private BigDecimal salary;
    private String added_by;
    public Labour(String name,String date_ofBirth ,String email,String phone,String address,String position, BigDecimal salary,String added_by) {
        this.name = name;
        this.date_ofBirth = date_ofBirth;
        this.email=email;
        this.phone = phone;
        this.address = address;
        this.position = position;
        this.salary = salary;
        this.added_by = added_by;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getAdded_by() {
        return added_by;
    }
    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_ofBirth() {
        return date_ofBirth;
    }

    public void setDate_ofBirth(String date_ofBirth) {
        this.date_ofBirth = date_ofBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}