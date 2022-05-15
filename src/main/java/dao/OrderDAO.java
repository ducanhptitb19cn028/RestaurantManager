package dao;

import model.Order;
import view.auth.Login;
import dao.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    public static void InsertOrderBill(CartDAO cartDAO, Order order){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO tblorder(staff, quantity, oprice, orderday) VALUES(?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, order.getStaff());
            ps.setInt(2,cartDAO.getSumQuantity());
            ps.setBigDecimal(3,cartDAO.getTotalPrice());
            ps.setDate(4,order.getOrderday());
            ps.executeUpdate();
            conn.close();

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
