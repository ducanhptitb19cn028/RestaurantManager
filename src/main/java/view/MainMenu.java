/*
 * Created by JFormDesigner on Sat Apr 09 08:51:40 ICT 2022
 */

package view;

import java.awt.event.*;
import view.auth.AdminLogin;
import view.auth.ChangePassword;
import view.auth.Login;
import view.item.ItemManagement;
import view.menu.MenuManagement;
import view.order.OrderManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
        welcometxt.setText("Welcome "+Login.getUsernametext());
    }

    private void labourmngbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        AdminLogin al = new AdminLogin();
        al.setVisible(true);
    }

    private void Itemmanbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ItemManagement im = new ItemManagement();
        im.setVisible(true);
    }

    private void menumanbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MenuManagement mv = new MenuManagement();
        mv.setVisible(true);
    }

    private void ordermanbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        OrderManagement om = new OrderManagement();
        om.setVisible(true);
    }

    private void logoutbtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        Login lg = new Login();
        lg.setVisible(true);
    }

    private void changepassbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ChangePassword changepassbtn = new ChangePassword();
        changepassbtn.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        labourmngbtn = new JButton();
        Itemmanbtn = new JButton();
        menumanbtn = new JButton();
        ordermanbtn = new JButton();
        label1 = new JLabel();
        logoutbtn = new JButton();
        changepassbtn = new JButton();
        welcometxt = new JLabel();

        //======== this ========
        setTitle("Main menu");
        var contentPane = getContentPane();

        //---- labourmngbtn ----
        labourmngbtn.setText("Labour management");
        labourmngbtn.addActionListener(e -> labourmngbtn(e));

        //---- Itemmanbtn ----
        Itemmanbtn.setText(" Item management");
        Itemmanbtn.addActionListener(e -> Itemmanbtn(e));

        //---- menumanbtn ----
        menumanbtn.setText("Menu management");
        menumanbtn.addActionListener(e -> menumanbtn(e));

        //---- ordermanbtn ----
        ordermanbtn.setText("Order management");
        ordermanbtn.addActionListener(e -> ordermanbtn(e));

        //---- label1 ----
        label1.setText("Main menu");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        //---- logoutbtn ----
        logoutbtn.setText("Log out");
        logoutbtn.setIcon(new ImageIcon(getClass().getResource("/images/logout.png")));
        logoutbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutbtnMouseClicked(e);
            }
        });

        //---- changepassbtn ----
        changepassbtn.setText("Change password");
        changepassbtn.setIcon(new ImageIcon(getClass().getResource("/images/changepassword.png")));
        changepassbtn.addActionListener(e -> changepassbtn(e));

        //---- welcometxt ----
        welcometxt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        welcometxt.setText("Welcome ");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(welcometxt)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(56, 56, 56)
                            .addComponent(logoutbtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(310, Short.MAX_VALUE)
                            .addComponent(changepassbtn)))
                    .addContainerGap(29, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(labourmngbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menumanbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(Itemmanbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ordermanbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(logoutbtn, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(welcometxt)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(changepassbtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(Itemmanbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(labourmngbtn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(ordermanbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(menumanbtn, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(31, 31, 31))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JButton labourmngbtn;
    private JButton Itemmanbtn;
    private JButton menumanbtn;
    private JButton ordermanbtn;
    private JLabel label1;
    private JButton logoutbtn;
    private JButton changepassbtn;
    private JLabel welcometxt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
