/*
 * Created by JFormDesigner on Tue Apr 05 17:58:10 ICT 2022
 */

package view.auth;


import java.awt.event.*;
import model.User;
import view.db.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * @author unknown
 */
public class SignupForm extends JFrame {
    public SignupForm() {
        initComponents();
    }

    private void signupbtn(ActionEvent e) {
        // TODO add your code here
        register();
    }

    private void Cancelbtn(ActionEvent e) {
        // TODO add your code here
        dispose();
    }
    public User user;



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        iconlb = new JLabel();
        label1 = new JLabel();
        namelb = new JLabel();
        emaillb = new JLabel();
        tfName = new JTextField();
        tfEmail = new JTextField();
        phonelb = new JLabel();
        tfPhone = new JTextField();
        usernamelb = new JLabel();
        tfUsername = new JTextField();
        label2 = new JLabel();
        tfPassword = new JPasswordField();
        label3 = new JLabel();
        tfConfirm = new JPasswordField();
        signupbtn = new JButton();
        Cancelbtn = new JButton();
        label4 = new JLabel();
        tfPosition = new JTextField();

        //======== this ========
        setForeground(new Color(0, 146, 143));
        setTitle("Sign up");
        var contentPane = getContentPane();

        //---- iconlb ----
        iconlb.setIcon(new ImageIcon(getClass().getResource("/images/signup.png")));

        //---- label1 ----
        label1.setText("Welcome to the restaurant");
        label1.setFont(new Font("Javanese Text", Font.BOLD, 22));

        //---- namelb ----
        namelb.setText("Name:");
        namelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- emaillb ----
        emaillb.setText("Email:");
        emaillb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfName ----
        tfName.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfEmail ----
        tfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- phonelb ----
        phonelb.setText("Phone:");
        phonelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfPhone ----
        tfPhone.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- usernamelb ----
        usernamelb.setText("Username:");
        usernamelb.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfUsername ----
        tfUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label2 ----
        label2.setText("Password:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfPassword ----
        tfPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label3 ----
        label3.setText("Confirm password:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfConfirm ----
        tfConfirm.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- signupbtn ----
        signupbtn.setText("Sign up");
        signupbtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        signupbtn.addActionListener(e -> signupbtn(e));

        //---- Cancelbtn ----
        Cancelbtn.setText("Cancel");
        Cancelbtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        Cancelbtn.addActionListener(e -> Cancelbtn(e));

        //---- label4 ----
        label4.setText("Position:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfPosition ----
        tfPosition.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(80, 80, 80)
                                    .addComponent(tfPassword))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(22, 22, 22)
                                    .addComponent(tfConfirm))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(iconlb)
                                        .addComponent(namelb)
                                        .addComponent(emaillb)
                                        .addComponent(phonelb)
                                        .addComponent(label4)
                                        .addComponent(usernamelb))
                                    .addGap(77, 77, 77)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfUsername)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfName)
                                        .addComponent(tfEmail)
                                        .addComponent(tfPhone)
                                        .addComponent(tfPosition)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(signupbtn)
                            .addGap(63, 63, 63)
                            .addComponent(Cancelbtn)))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(iconlb)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(label1)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(namelb)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emaillb))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phonelb)
                        .addComponent(tfPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(tfPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernamelb)
                        .addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label2)
                        .addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfConfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(signupbtn)
                        .addComponent(Cancelbtn))
                    .addGap(14, 14, 14))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void register(){
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String position = tfPosition.getText();
        String username = tfUsername.getText();
        String password = String.valueOf(tfPassword.getPassword());
        String confirm = String.valueOf(tfConfirm.getPassword());
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty() || position.isEmpty() ||password.isEmpty() || confirm.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!password.equals(confirm)){
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (emailExists(email,username)){
            JOptionPane.showMessageDialog(this,
                    "Account has been registered",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = insert(name, email, phone,position ,username, password);
        if (user != null){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private User insert(String name, String email, String phone,String position ,String username, String password) {
        User user = null;

        try{
            String query = "INSERT INTO users (name,email,phone,position,username,password) VALUES"+"(?,?,?,?,?,?)";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, position);
            ps.setString(5, username);
            ps.setString(6, password);
            int addedRows = ps.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.position = position;
                user.username = username;
                user.password = password;
            }
            conn.close();
        }
        catch (Exception var15) {
            var15.printStackTrace();
        }
        return user;
    }
    public static boolean emailExists(String email,String username) {

        ResultSet rs = null;
        String query = "SELECT email,username FROM users "
                + "WHERE email = ?"+"OR username = ?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2,username);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
        finally {
            closeResultSet(rs);
        }
    }
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        SignupForm sf= new SignupForm();
        sf.setVisible(true);
        sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel iconlb;
    private JLabel label1;
    private JLabel namelb;
    private JLabel emaillb;
    private JTextField tfName;
    private JTextField tfEmail;
    private JLabel phonelb;
    private JTextField tfPhone;
    private JLabel usernamelb;
    private JTextField tfUsername;
    private JLabel label2;
    private JPasswordField tfPassword;
    private JLabel label3;
    private JPasswordField tfConfirm;
    private JButton signupbtn;
    private JButton Cancelbtn;
    private JLabel label4;
    private JTextField tfPosition;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
