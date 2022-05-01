package dao;

import model.Cart;
import model.CartItem;
import view.db.DBConnection;

import java.math.BigDecimal;
import java.sql.*;

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

    public void clearCart() {
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
    public BigDecimal getTotalPrice() {
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
}
