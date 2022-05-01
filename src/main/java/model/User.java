package model;

import java.io.Serializable;




public class User implements Serializable {
    public String phone;
    private Long id;

    public String name;
    public String email;
    public String position;
    public String username;
    public String password;
    public User() {

    }


    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }
    public String getUsername(){return username;}
    public String getPassword() {return password;}
}