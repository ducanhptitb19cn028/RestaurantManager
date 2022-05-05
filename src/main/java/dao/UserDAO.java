package dao;

import model.User;
import view.db.DBConnection;

import java.sql.*;

public class UserDAO {
    public static boolean getAuthenticatedUser(User user){
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm= conn.createStatement();
            String query = "SELECT*FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               return true;
            }
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void insert(User user) {
        try{
            String query = "INSERT INTO users (name,email,phone,position,username,password) VALUES"+"(?,?,?,?,?,?)";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPosition());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {

        }
    }

    public void Update(User user, String newPassword) {
        try{
            String query = "UPDATE users SET password = ? WHERE username = ?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(2, user.getUsername());
            ps.setString(1, user.getPassword());
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {

        }
    }
}
