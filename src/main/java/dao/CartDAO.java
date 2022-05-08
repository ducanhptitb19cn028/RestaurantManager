package dao;

import model.Cart;
import model.CartItem;
import dao.db.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CartDAO {
    private Cart cart;

    public CartDAO() {
    }

    public void addToCart( CartItem cartItem,Cart cart) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO cart(cname,price,num) VALUES(?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cartItem.getCname());
            ps.setBigDecimal(2,cartItem.getPrice().multiply(BigDecimal.valueOf(cart.getNum())));
            ps.setInt(3,cart.getNum());
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void clearCart() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM cart";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int getSumQuantity(){
        int sum;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT SUM(num) FROM cart");
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            sum = resultSet.getInt(1);
        } catch (Exception e) {
            sum = Integer.parseInt(null);
        }
        return sum;
    }
    public static BigDecimal getTotalPrice() {
        BigDecimal totalPrice;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT SUM(price) FROM cart");
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            totalPrice = resultSet.getBigDecimal(1);
        } catch (Exception e) {
            totalPrice = null;
        }
        return totalPrice;
    }
    public static ArrayList<Cart> getAllCart(){
        ArrayList<Cart> carts = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname,price,num FROM cart";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            carts = new ArrayList<>();
            while (rs.next()) {
                Cart cart = new Cart(rs.getString("cname"),rs.getBigDecimal("price"),rs.getInt("num"));
                carts.add(cart);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return carts;
    }
    public Cart getCart(){
        ArrayList<Cart> carts = getAllCart();
        for (Cart cart :carts){
            return cart;
        }
        return null;
    }
}
