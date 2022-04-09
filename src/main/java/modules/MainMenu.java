/*
 * Created by JFormDesigner on Sat Apr 09 08:51:40 ICT 2022
 */

package modules;

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
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labourmngbtn = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- labourmngbtn ----
        labourmngbtn.setText("Labour manager");
        labourmngbtn.addActionListener(e -> labourmngbtn(e));

        //---- button2 ----
        button2.setText(" Item manager");

        //---- button3 ----
        button3.setText("Menu manager");

        //---- button4 ----
        button4.setText("Bill manager");

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
                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(labourmngbtn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addComponent(button4, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
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
                        .addComponent(button2))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3)
                        .addComponent(button4))
                    .addContainerGap(84, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton labourmngbtn;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
