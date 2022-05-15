/*
 * Created by JFormDesigner on Wed Apr 13 17:32:05 ICT 2022
 */

package view.auth;


import dao.UserDAO;
import model.User;
import view.MainMenu;
import view.labour.LabourManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author unknown
 */
public class AdminLogin extends JFrame {
    public AdminLogin() {
        initComponents();
    }
    public User user;
    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }
    public static String getUsernametext(){
        return tfUsername.getText();
    }
    private void adminbtn(ActionEvent e) {
        // TODO add your code here
        String username = tfUsername.getText();
        String password = String.valueOf(tfPassword.getPassword());
        User user = new User(username,password);
        UserDAO userDAO = new UserDAO();
        if (username.isEmpty() || password.isEmpty() || !userDAO.getAuthenticatedAdmin(user) ){
            JOptionPane.showMessageDialog(this,
                    "You may be not admin!!!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.dispose();
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tfUsername = new JTextField();
        tfPassword = new JPasswordField();
        adminbtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        setTitle("Admin login");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Only owner can access this function");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("Username:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfUsername ----
        tfUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- adminbtn ----
        adminbtn.setText("Login");
        adminbtn.addActionListener(e -> adminbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label1))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                .addComponent(tfPassword, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                    .addGap(35, 35, 35))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(adminbtn)
                    .addGap(62, 62, 62)
                    .addComponent(backbtn)
                    .addContainerGap(111, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(adminbtn)
                        .addComponent(backbtn))
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        AdminLogin allMatch = new AdminLogin();
        allMatch.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private static JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton adminbtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
