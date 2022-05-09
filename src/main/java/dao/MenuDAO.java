package dao;

import model.Menuuu;
import dao.db.DBConnection;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class MenuDAO extends Component {
    public ArrayList<Menuuu> BindtoTable() {
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
            rs = st.executeQuery("SELECT * FROM tblmenu");
            Menuuu mn;
            while (rs.next()) {
                mn = new Menuuu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menuuu> BindToSearch(String search) {
        ArrayList<Menuuu> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tblmenu WHERE mname like '%"+search+"%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menuuu mn = new Menuuu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menuuu> BindtoDrinksearch(){
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
            rs = st.executeQuery("SELECT * FROM tblmenu WHERE kind = 'Drink'");
            Menuuu mn;
            while (rs.next()) {
                mn = new Menuuu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menuuu> BindtoFoodsearch(){
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
            rs = st.executeQuery("SELECT * FROM tblmenu WHERE kind = 'Food'");
            Menuuu mn;
            while (rs.next()) {
                mn = new Menuuu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menuuu> BindtoDessertsearch(){
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
            rs = st.executeQuery("SELECT * FROM tblmenu WHERE kind = 'Dessert'");
            Menuuu mn;
            while (rs.next()) {
                mn = new Menuuu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static boolean MenuExists(String name){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT mname FROM tblmenu WHERE mname = ?";
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
