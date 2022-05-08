package dao;

import model.Cart;
import model.CartItem;
import dao.db.DBConnection;

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
    public static boolean ExistsCartItem(Cart cart){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname FROM cartitem WHERE cname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cart.getCname());
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
    public static void UpdateQuantity( CartItem cartItem, Cart cart){
        try{
            Connection conn= DBConnection.getConnection();
            String query = "UPDATE cartitem SET cquantity = ?  WHERE cname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,cartItem.getQuantity()-cart.getNum());
            ps.setString(2, cartItem.getCname());
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void ReturnQuantity(){
        try{
            ArrayList<CartItem> cartItems = getAllCartItems();
            ArrayList<Cart> carts = CartDAO.getAllCart();
            Connection conn= DBConnection.getConnection();
            for (Cart i:carts){
                for (CartItem j : cartItems){
                    if(i.getCname().equalsIgnoreCase(j.getCname())){
                        String query = "UPDATE cartitem SET cquantity = ?  WHERE cname = ?";
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setInt(1, j.getQuantity() + i.getNum());
                        ps.setString(2, j.getCname());
                        ps.executeUpdate();
                    }
                }
            }
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
    public CartItem GetCartItemByname(Cart cart){

        ArrayList<CartItem> cartItems = getAllCartItems();
        for (CartItem i:cartItems ) {
            if (i.getCname().equalsIgnoreCase(cart.getCname()) ) {
                return i;
            }
        }
        return null;
    }
}
