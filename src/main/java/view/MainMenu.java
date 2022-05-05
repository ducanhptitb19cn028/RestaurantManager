/*
 * Created by JFormDesigner on Sat Apr 09 08:51:40 ICT 2022
 */

package view;

import view.auth.AdminLogin;
import view.auth.ChangePassword;
import view.auth.Login;
import view.item.ItemManager;
import view.menu.MenuView;
import view.order.OrderManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
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
        ItemManager im = new ItemManager();
        im.setVisible(true);
    }

    private void menumanbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MenuView mv = new MenuView();
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
        labourmngbtn = new JButton();
        Itemmanbtn = new JButton();
        menumanbtn = new JButton();
        ordermanbtn = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("Main menu");
        var contentPane = getContentPane();

        //---- labourmngbtn ----
        labourmngbtn.setText("Labour manager");
        labourmngbtn.addActionListener(e -> labourmngbtn(e));

        //---- Itemmanbtn ----
        Itemmanbtn.setText(" Item manager");
        Itemmanbtn.addActionListener(e -> Itemmanbtn(e));

        //---- menumanbtn ----
        menumanbtn.setText("Menu manager");
        menumanbtn.addActionListener(e -> menumanbtn(e));

        //---- ordermanbtn ----
        ordermanbtn.setText("Order manager");
        ordermanbtn.addActionListener(e -> ordermanbtn(e));

        //---- label1 ----
        label1.setText("Main menu");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(menumanbtn, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addComponent(labourmngbtn, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(Itemmanbtn, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ordermanbtn, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(label1)))
                    .addContainerGap(42, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Itemmanbtn)
                        .addComponent(labourmngbtn))
                    .addGap(67, 67, 67)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(menumanbtn)
                        .addComponent(ordermanbtn))
                    .addContainerGap(48, Short.MAX_VALUE))
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
    private JButton labourmngbtn;
    private JButton Itemmanbtn;
    private JButton menumanbtn;
    private JButton ordermanbtn;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
