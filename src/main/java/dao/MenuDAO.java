package dao;

import model.Menuuu;
import view.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuDAO {
    public ArrayList<Menuuu> BindTable() {
        ArrayList<Menuuu> list = new ArrayList<>();
        Connection conn;
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM menu");
            Menuuu mn;
            while (rs.next()) {
                mn = new Menuuu(rs.getInt("no"),rs.getString("food"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("unit"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
