package model;

import java.io.Serializable;

public class User implements Serializable {
    public String phone;

    public String name;
    public String email;
    public String position;
    public String username;
    public String password;
    public User() {

    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public User (String name, String email, String phone,String position ,String username, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }
    public String getUsername(){return username;}
    public String getPassword() {return password;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}