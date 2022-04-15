package controller;

import modules.db.DBConnection;
import view.Labour;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LabourController {
    public static void addLabour(String name,String date_ofBirth ,String email,String phone,String address,String position, BigDecimal salary){
        Labour labour = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO labour(name,date_ofBirth,email,phone,address,position,salary) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, date_ofBirth);
            ps.setString(3,email);
            ps.setString(4,phone);
            ps.setString(5,address);
            ps.setString(6,position);
            ps.setBigDecimal(7,salary);
            int addedRows = ps.executeUpdate();
            if (addedRows > 0) {
                labour.name=name;
                labour.date_ofBirth= date_ofBirth;
                labour.email=email;
                labour.phone=phone;
                labour.address= address;
                labour.position=position;
                labour.salary= salary;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
