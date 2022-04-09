/*
 * Created by JFormDesigner on Tue Apr 05 22:23:05 ICT 2022
 */

package modules.auth;

import modules.MainMenu;
import view.User;
import modules.db.DBConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }
    private User user;
    private void loginbtn(ActionEvent e) {
        // TODO add your code here
        String username = tfUsername.getText();
        String password = String.valueOf(tfPassword.getPassword());
        user = getAuthenticatedUser(username, password);

        if (user != null) {
            this.dispose();
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(Login.this,
                    "Email or Password incorrect!!!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void signupbtn(ActionEvent e) {
        // TODO add your code here
        SignupForm sf = new SignupForm();
        sf.setVisible(true);
    }


  

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        restaurant = new JLabel();
        label1 = new JLabel();
        tfUsername = new JTextField();
        label2 = new JLabel();
        tfPassword = new JPasswordField();
        loginbtn = new JButton();
        signupbtn = new JButton();
        restauranticon = new JLabel();

        //======== this ========
        setTitle("Login");
        var contentPane = getContentPane();

        //---- restaurant ----
        restaurant.setText("\u0110\u1ee9c Anh's Restaurant");
        restaurant.setFont(new Font("Segoe UI", Font.BOLD, 22));

        //---- label1 ----
        label1.setText("Username:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfUsername ----
        tfUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label2 ----
        label2.setText("Password:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- loginbtn ----
        loginbtn.setText("Log in");
        loginbtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        loginbtn.addActionListener(e -> loginbtn(e));

        //---- signupbtn ----
        signupbtn.setText("Sign up");
        signupbtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        signupbtn.addActionListener(e -> signupbtn(e));

        //---- restauranticon ----
        restauranticon.setIcon(new ImageIcon(getClass().getResource("/images/restaurant.png")));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(loginbtn)
                            .addGap(35, 35, 35)
                            .addComponent(signupbtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(restauranticon)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label1)
                                    .addComponent(label2)))
                            .addGap(39, 39, 39)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(tfPassword, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))))
                    .addContainerGap(60, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restaurant, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(restaurant)
                            .addGap(35, 35, 35))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(restauranticon)
                            .addGap(26, 26, 26)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginbtn)
                        .addComponent(signupbtn))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private User getAuthenticatedUser(String username,String password) {
        User user = null;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm= conn.createStatement();
            String query = "SELECT*FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.name=rs.getString("name");
                user.email=rs.getString("email");
                user.phone=rs.getString("phone");
                user.username=rs.getString("username");
                user.password=rs.getString("password");
            }
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        Login lg = new Login();
        lg.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel restaurant;
    private JLabel label1;
    private JTextField tfUsername;
    private JLabel label2;
    private JPasswordField tfPassword;
    private JButton loginbtn;
    private JButton signupbtn;
    private JLabel restauranticon;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
