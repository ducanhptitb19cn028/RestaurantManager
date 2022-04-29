package dao;

import model.Cart;
import model.CartItem;
import view.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartItemDAO {
    public static void addCartItem(CartItem cartItem) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO cartitem(cname,price,cquantity) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cartItem.cname);
            ps.setBigDecimal(2,cartItem.price);
            ps.setInt(3,cartItem.quantity);
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public ArrayList<CartItem> BindtoTable() {
//        ArrayList<CartItem> list = new ArrayList<>();
//        Connection conn;
//        try {
//            conn = DBConnection.getConnection();
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        Statement st;
//        ResultSet rs;
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery("SELECT cname,price,cquantity FROM cart");
//            while (rs.next()) {
//               CartItem ci = new CartItem(rs.getString("cname"),rs.getBigDecimal("price"),rs.getInt("cquantity"));
//                list.add(ci);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    public static void UpdateCartItem(String cname, int cquantity){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE cartitem SET cquantity = ?  WHERE cname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,cquantity);
            ps.setString(2,cname);
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean ExistsCartItem(String cname){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname FROM cartitem WHERE cname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cname);
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
    public static void UpdateQuantity(String name, CartItem cartItem, Cart cart){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE cartitem SET cquantity = ?  WHERE cname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,cartItem.getQuantity()-cart.getNum());
            ps.setString(2,name);
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<CartItem> getAllCartItems(){
        ArrayList<CartItem> cartItems = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname,price,cquantity FROM cartitem";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            cartItems = new ArrayList<>();
            while (rs.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setCname(rs.getString("cname"));
                cartItem.setPrice(rs.getBigDecimal("price"));
                cartItem.setQuantity(rs.getInt("cquantity"));
                cartItems.add(cartItem);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
    public CartItem GetCartItemByname(String cname){
        ArrayList<CartItem> cartItems = getAllCartItems();
        if (cartItems.get(0).getCname().equals(cname)){
            return cartItems.get(0);
        }
        return null;
    }
}