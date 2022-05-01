package dao;

import model.Cart;
import model.Order;
import model.User;
import view.db.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    public static void InsertOrderBill(User user, CartDAO cartDAO, Order order){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO tblorder(staff, quantity, oprice, orderday) VALUES(?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setInt(2,cartDAO.getSumQuantity());
            ps.setBigDecimal(3,cartDAO.getTotalPrice());
            ps.setDate(4,order.getOrderday()
            );
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
