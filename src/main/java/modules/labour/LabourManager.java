/*
 * Created by JFormDesigner on Wed Apr 13 16:17:45 ICT 2022
 */

package modules.labour;

import modules.MainMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class LabourManager extends JFrame {
    public LabourManager() {
        initComponents();
    }

    private void addlabbtn(ActionEvent e) {
        // TODO add your code here
        AddLabour addLabour = new AddLabour();
        addLabour.setVisible(true);
    }

    private void updatelabbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void deeletelabbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void viewbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        addlabbtn = new JButton();
        updatelabbtn = new JButton();
        deeletelabbtn = new JButton();
        viewbtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        setTitle("Labour manager");
        setBackground(new Color(102, 255, 153));
        setForeground(new Color(153, 255, 153));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Labour managerment");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        //---- addlabbtn ----
        addlabbtn.setText("Add labour");
        addlabbtn.addActionListener(e -> addlabbtn(e));

        //---- updatelabbtn ----
        updatelabbtn.setText("Update labour");
        updatelabbtn.addActionListener(e -> updatelabbtn(e));

        //---- deeletelabbtn ----
        deeletelabbtn.setText("Delete labour");
        deeletelabbtn.addActionListener(e -> deeletelabbtn(e));

        //---- viewbtn ----
        viewbtn.setText("View labour list");
        viewbtn.addActionListener(e -> viewbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(91, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(83, 83, 83))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(deeletelabbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addlabbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(61, 61, 61)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(updatelabbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(159, 159, 159)
                            .addComponent(backbtn)))
                    .addContainerGap(54, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(label1)
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(updatelabbtn)
                        .addComponent(addlabbtn))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deeletelabbtn)
                        .addComponent(viewbtn))
                    .addGap(29, 29, 29)
                    .addComponent(backbtn)
                    .addContainerGap(66, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton addlabbtn;
    private JButton updatelabbtn;
    private JButton deeletelabbtn;
    private JButton viewbtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        LabourManager lm = new LabourManager();
        lm.setVisible(true);
    }
}
