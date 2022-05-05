package dao;

import view.auth.Login;
import view.db.DBConnection;
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
            String query = "INSERT INTO items(name,price,quantity,import_date,imported_by) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, item.name);
            ps.setBigDecimal(2,item.price);
            ps.setInt(3,item.quantity);
            ps.setDate(4,item.import_date);
            ps.setString(5, Login.getUsernametext());
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateItem(String name, Item item){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE items SET name = ?, price = ?, quantity = ?  WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,item.name);
            ps.setBigDecimal(2,item.price);
            ps.setInt(3,item.quantity);
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
            String query = "DELETE FROM items WHERE name = ?";
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
            String query = "SELECT name FROM items WHERE name = ?";
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
