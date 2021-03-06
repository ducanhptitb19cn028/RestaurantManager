package dao;

import view.auth.Login;
import dao.db.DBConnection;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemDAO {
    public Item item;
    public static void addItem(Item item) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO tblitem(name,price,quantity,import_date,imported_by) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setBigDecimal(2,item.getPrice());
            ps.setInt(3,item.getQuantity());
            ps.setDate(4,item.getImported_date());
            ps.setString(5, item.getImported_by());
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateItem(String name, Item item){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE tblitem SET name = ?, price = ?, quantity = ?  WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,item.getName());
            ps.setBigDecimal(2,item.getPrice());
            ps.setInt(3,item.getQuantity());
            ps.setString(4,name);
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteItem(String name) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM tblitem WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean existsItem(String name) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT name FROM tblitem WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
