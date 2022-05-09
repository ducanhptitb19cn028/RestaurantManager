package dao;

import view.auth.AdminLogin;
import dao.db.DBConnection;
import model.Labour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LabourDAO {
    public static void addLabour(Labour labour){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO tbllabour(name,date_ofBirth,email,phone,address,position,salary,added_by) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, labour.name);
            ps.setString(2, labour.date_ofBirth);
            ps.setString(3, labour.email);
            ps.setString(4,labour.phone);
            ps.setString(5,labour.address);
            ps.setString(6,labour.position);
            ps.setBigDecimal(7,labour.salary);
            ps.setString(8, AdminLogin.getUsernametext());
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteLabours(String name){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM tbllabour WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateLabours(Labour labour,String name){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE tbllabour SET name = ?, date_ofBirth = ?,email = ?,phone = ?, address = ?, position = ?, salary = ? WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, labour.name);
            ps.setString(2,labour.date_ofBirth);
            ps.setString(3, labour.email);
            ps.setString(4, labour.phone);
            ps.setString(5, labour.address);
            ps.setString(6, labour.position);
            ps.setBigDecimal(7, labour.salary);
            ps.setString(8,name);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
