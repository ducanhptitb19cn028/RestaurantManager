package controller;

import modules.db.DBConnection;
import view.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuController {
    public static void Addmenu(Menu menu){

        try {
            FileInputStream fis = new FileInputStream(String.valueOf(menu.images));
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO menu(food,image,price,unit) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,menu.food);
            ps.setBinaryStream(2,fis);
            ps.setBigDecimal(3,menu.price);
            ps.setString(4,menu.unit);
            ps.executeUpdate();
            conn.close();
        }catch (SQLException | ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
