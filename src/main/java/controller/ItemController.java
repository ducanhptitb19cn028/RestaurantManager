package controller;

import modules.db.DBConnection;
import view.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class ItemController {
    private static Date import_date;
    public Item item;
    public static ArrayList<Item> GetItems() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM items";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            ArrayList<Item> ls = new ArrayList<>();
            while (rs.next()) {
               Item item = new Item(rs.getString("name"),rs.getBigDecimal("price"), rs.getInt("quantity"),rs.getDate("import_date"));
               ls.add(item);
            }
            return ls;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void addItem(String name, BigDecimal price, int quantity,java.sql.Date import_date) {
        Item item = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO items(name,price,quantity,import_date) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setBigDecimal(2,price);
            ps.setInt(3,quantity);
            ps.setDate(4,import_date);
            int addedRows = ps.executeUpdate();
            if (addedRows > 0) {
                item.name=name;
                item.price = price;
                item.quantity=quantity;
                item.import_date=import_date;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void updateItem(String newname, BigDecimal newprice, int newquantity,String name){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE items SET name = ?, price = ?, quantity = ? WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,newname);
            ps.setBigDecimal(2,newprice);
            ps.setInt(3,newquantity);
            ps.setString(4,name);
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void deleteItem() {
        Item item = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM items WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, item.getName());


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
