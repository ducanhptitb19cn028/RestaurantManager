package dao;

import model.Menu;
import dao.db.DBConnection;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class MenuDAO extends Component {
    public ArrayList<Menu> BindtoTable() {
        ArrayList<Menu> list = new ArrayList<>();
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
            Menu mn;
            while (rs.next()) {
                mn = new Menu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menu> BindToSearch(String search) {
        ArrayList<Menu> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tblmenu WHERE mname like '%"+search+"%'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu mn = new Menu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menu> BindtoDrinksearch(){
        ArrayList<Menu> list = new ArrayList<>();
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
            Menu mn;
            while (rs.next()) {
                mn = new Menu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menu> BindtoFoodsearch(){
        ArrayList<Menu> list = new ArrayList<>();
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
            Menu mn;
            while (rs.next()) {
                mn = new Menu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
                list.add(mn);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Menu> BindtoDessertsearch(){
        ArrayList<Menu> list = new ArrayList<>();
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
            Menu mn;
            while (rs.next()) {
                mn = new Menu(rs.getInt("no"),rs.getString("mname"),rs.getBytes("image"),rs.getBigDecimal("price"),rs.getString("kind"));
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
