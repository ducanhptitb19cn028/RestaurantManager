/*
 * Created by JFormDesigner on Wed Apr 06 11:50:00 ICT 2022
 */

package modules.item;

import controller.ItemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author unknown
 */
public class AddItem extends JFrame {
    private final ItemController itemController;
    public AddItem() {
        initComponents();
        this.itemController = new ItemController();
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        ItemManager im = new ItemManager();
        im.setVisible(true);
    }
    private void Addbtn(ActionEvent e) {
        // TODO add your code here
        String name = tfItemname.getText();
        String price = tfItemprice.getText();
        String quantity = tfItemquantity.getText();
        BigDecimal pr = BigDecimal.valueOf(Long.parseLong(price));
        Integer quant = Integer.valueOf(quantity);
        Date dtToday = new java.util.Date();
        java.sql.Date date = new java.sql.Date(dtToday.getTime());
        if(name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item name cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(price.isEmpty() || !price.chars().allMatch( Character::isDigit) ||
                Double.parseDouble(price) <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price for the item","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(quantity.isEmpty() || !quantity.chars().allMatch( Character::isDigit)
                || Integer.parseInt(quantity) <=0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity for the item","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        itemController.addItem(name,pr,quant,date);
        tfItemname.setText("");
        tfItemprice.setText("");
        tfItemquantity.setText("");
        JOptionPane.showMessageDialog(this, "Item has been added");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        tfItemname = new JTextField();
        label2 = new JLabel();
        tfItemprice = new JTextField();
        label3 = new JLabel();
        tfItemquantity = new JTextField();
        backbtn = new JButton();
        Addbtn = new JButton();

        //======== this ========
        setTitle("Add item");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Item name:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfItemname ----
        tfItemname.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label2 ----
        label2.setText("Item price:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfItemprice ----
        tfItemprice.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label3 ----
        label3.setText("Item quantity:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfItemquantity ----
        tfItemquantity.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //---- Addbtn ----
        Addbtn.setText("Add");
        Addbtn.addActionListener(e -> Addbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addGap(32, 32, 32)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfItemname, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(tfItemprice, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(tfItemquantity, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(backbtn)
                            .addGap(18, 18, 18)
                            .addComponent(Addbtn)))
                    .addContainerGap(65, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfItemname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfItemprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfItemquantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn)
                        .addComponent(backbtn))
                    .addContainerGap(38, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        AddItem ai = new AddItem();
        ai.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField tfItemname;
    private JLabel label2;
    private JTextField tfItemprice;
    private JLabel label3;
    private JTextField tfItemquantity;
    private JButton backbtn;
    private JButton Addbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}