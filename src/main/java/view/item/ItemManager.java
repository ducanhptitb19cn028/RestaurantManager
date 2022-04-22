/*
 * Created by JFormDesigner on Wed Apr 06 09:47:36 ICT 2022
 */

package view.item;

import view.MainMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class ItemManager extends JFrame {
    public ItemManager() {
        initComponents();
    }

    private void additembtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        AddItem ai = new AddItem();
        ai.setVisible(true);
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        UpdateItem ai = new UpdateItem();
        ai.setVisible(true);
    }

    private void deleteitembtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DeleteItem di = new DeleteItem();
        di.setVisible(true);
    }

    private void viewitemlistbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ViewItem vi = new ViewItem();
        vi.setVisible(true);
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        additembtn = new JButton();
        updatebtn = new JButton();
        deleteitembtn = new JButton();
        viewitemlistbtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        setTitle("Item manager");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Item manager");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        //---- additembtn ----
        additembtn.setText("Add item");
        additembtn.addActionListener(e -> additembtn(e));

        //---- updatebtn ----
        updatebtn.setText("Update item");
        updatebtn.addActionListener(e -> updatebtn(e));

        //---- deleteitembtn ----
        deleteitembtn.setText("Delete item");
        deleteitembtn.addActionListener(e -> deleteitembtn(e));

        //---- viewitemlistbtn ----
        viewitemlistbtn.setText("View item list");
        viewitemlistbtn.addActionListener(e -> viewitemlistbtn(e));

        //---- backbtn ----
        backbtn.setText("Back to main menu");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(label1)
                    .addContainerGap(134, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 127, Short.MAX_VALUE)
                    .addComponent(backbtn, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(126, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(additembtn, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(updatebtn, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteitembtn, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(viewitemlistbtn, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGap(41, 41, 41))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(deleteitembtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(additembtn)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(viewitemlistbtn)
                        .addComponent(updatebtn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                    .addComponent(backbtn)
                    .addGap(33, 33, 33))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        ItemManager im = new ItemManager();
        im.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton additembtn;
    private JButton updatebtn;
    private JButton deleteitembtn;
    private JButton viewitemlistbtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
