package dao;

import model.User;
import view.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    public static void getAuthenticatedUser(User user){
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm= conn.createStatement();
            String query = "SELECT*FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.name=rs.getString("name");
                user.email=rs.getString("email");
                user.phone=rs.getString("phone");
                user.username=rs.getString("username");
                user.password=rs.getString("password");
            }
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
