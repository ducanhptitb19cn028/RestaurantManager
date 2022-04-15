/*
 * Created by JFormDesigner on Sat Apr 09 08:51:40 ICT 2022
 */

package modules;

import modules.item.ItemManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
    }

    private void labourmngbtn(ActionEvent e) {
        // TODO add your code here
        AdminLogin al = new AdminLogin();
        al.setVisible(true);
    }

    private void Itemmanbtn(ActionEvent e) {
        // TODO add your code here
        ItemManager im = new ItemManager();
        im.setVisible(true);
    }

    private void menumanbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void billmanbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labourmngbtn = new JButton();
        Itemmanbtn = new JButton();
        menumanbtn = new JButton();
        billmanbtn = new JButton();
        label1 = new JLabel();

        //======== this ========
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

        //---- billmanbtn ----
        billmanbtn.setText("Bill manager");
        billmanbtn.addActionListener(e -> billmanbtn(e));

        //---- label1 ----
        label1.setText("Main menu");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(menumanbtn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(labourmngbtn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(Itemmanbtn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(billmanbtn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addContainerGap(42, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(163, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(129, 129, 129))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label1)
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labourmngbtn)
                        .addComponent(Itemmanbtn))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(menumanbtn)
                        .addComponent(billmanbtn))
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton labourmngbtn;
    private JButton Itemmanbtn;
    private JButton menumanbtn;
    private JButton billmanbtn;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
