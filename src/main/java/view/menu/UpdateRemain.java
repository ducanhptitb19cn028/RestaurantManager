/*
 * Created by JFormDesigner on Thu Apr 28 09:49:23 ICT 2022
 */

package view.menu;

import dao.CartItemDAO;
import model.CartItem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class UpdateRemain extends JFrame {
    public CartItemDAO cartItemDAO;
    public UpdateRemain() {
        initComponents();
        this.cartItemDAO = new CartItemDAO();
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MenuView mv = new MenuView();
        mv.setVisible(true);
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String newQuantity = tfQuantity.getText().trim();
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Name field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newQuantity.isEmpty() || !newQuantity.chars().allMatch( Character::isDigit) || Integer.parseInt(newQuantity) <= 0){
            JOptionPane.showMessageDialog(this, "Please enter a valid value!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        cartItemDAO.UpdateCartItem(name, Integer.parseInt(newQuantity));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        tfName = new JTextField();
        label2 = new JLabel();
        tfQuantity = new JTextField();
        updatebtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        setTitle("Update quantity");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Enter an item that need updating:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("New quantity:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- updatebtn ----
        updatebtn.setText("Update");
        updatebtn.addActionListener(e -> updatebtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(tfQuantity, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(updatebtn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                    .addComponent(backbtn)
                    .addGap(89, 89, 89))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(updatebtn)
                        .addComponent(backbtn))
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        UpdateRemain ur = new UpdateRemain();
        ur.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField tfName;
    private JLabel label2;
    private JTextField tfQuantity;
    private JButton updatebtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
