/*
 * Created by JFormDesigner on Sun Apr 24 16:11:32 ICT 2022
 */

package view.order;

import dao.CartDAO;
import dao.CartItemDAO;
import dao.OrderDAO;
import model.Cart;
import model.CartItem;
import model.Order;
import view.MainMenu;
import dao.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author unknown
 */
public class OrderManagement extends JFrame {
    private final CartItemDAO cartItemDAO;
    private final CartDAO cartDAO;
    public OrderManagement() {
        this.cartItemDAO = new CartItemDAO();
        this.cartDAO = new CartDAO();
        initComponents();
        InsertDatabaseintoTable();

    }
    public void InsertDatabaseintoTable(){
        Object[] ob = new Object[10];
        DefaultTableModel table = (DefaultTableModel)tablecartitem.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname,price,cquantity FROM tblcartitem";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getString("cname");
                ob[1]=rs.getBigDecimal("price");
                ob[2]=rs.getInt("cquantity");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        table.fireTableDataChanged();
    }
    public void AddtoCartTable(){
        Object[] ob = new Object[5];
        DefaultTableModel table = (DefaultTableModel)tablecart.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT cname,price,num FROM tblcart";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getString("cname");
                ob[1]=rs.getBigDecimal("price");
                ob[2]=rs.getInt("num");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        table.fireTableDataChanged();
    }

    public static void main(String[] args) {
        OrderManagement om = new OrderManagement();
        om.setVisible(true);
    }

    private void addtocartbtn(ActionEvent e) {
        // TODO add your code here

        try{
            String newName = tfItem.getText().trim();
            String num = tfNumber.getText().trim();
            if (newName.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter item name to add to cart","Try again",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (num.isEmpty() || !num.chars().allMatch( Character::isDigit)){
                JOptionPane.showMessageDialog(this, "Please enter valid quantity to add to cart","Try again",JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cart cart = new Cart(newName,cartDAO.getTotalPrice(),Integer.parseInt(num));
            CartItem cartItem = cartItemDAO.GetCartItemByname(cart);
            if (!cartItemDAO.ExistsCartItem(cart)){
                JOptionPane.showMessageDialog(this, "This item does not exist in menu","Try again",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (cart.getNum() > cartItemDAO.GetCartItemByname(cart).getQuantity()){
                JOptionPane.showMessageDialog(this, "Sorry , This item is out of stock","Try again",JOptionPane.ERROR_MESSAGE);
                tfItem.setText("");
                tfNumber.setText("");
                return;
            }

            cartDAO.addToCart(cartItem,cart);
            cartItemDAO.UpdateQuantity(cartItem,cart);
            JOptionPane.showMessageDialog(this, "Add to cart successfully!!");
            AddtoCartTable();
            tfItem.setText("");
            tfNumber.setText("");
            sumMoneyField.setText("Total price: " + cartDAO.getTotalPrice());
        }catch (NumberFormatException ex){

        }

    }

    private void cancelbtn(ActionEvent e) {
        // TODO add your code here
        cartItemDAO.ReturnQuantity();
        cartDAO.clearCart();
        AddtoCartTable();
        sumMoneyField.setText("");

    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }

    private void orderbtn(ActionEvent e) {
        // TODO add your code here
        Date dtToday = new Date();
        java.sql.Date date = new java.sql.Date(dtToday.getTime());
        Order or = new Order(cartDAO.getSumQuantity(), cartDAO.getTotalPrice(), date);
        OrderDAO.InsertOrderBill(cartDAO,or);
        JOptionPane.showMessageDialog(this, "Order successfully!!");
        this.dispose();
        BillManager bm = new BillManager();
        bm.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tablecartitem = new JTable();
        scrollPane2 = new JScrollPane();
        tablecart = new JTable();
        separator1 = new JSeparator();
        cancelbtn = new JButton();
        label1 = new JLabel();
        tfItem = new JTextField();
        label2 = new JLabel();
        tfNumber = new JTextField();
        addtocartbtn = new JButton();
        orderbtn = new JButton();
        backbtn = new JButton();
        sumMoneyField = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tablecartitem ----
            tablecartitem.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Name", "Price", "Quantity"
                }
            ));
            scrollPane1.setViewportView(tablecartitem);
        }

        //======== scrollPane2 ========
        {

            //---- tablecart ----
            tablecart.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Name", "Price", "Num"
                }
            ));
            scrollPane2.setViewportView(tablecart);
        }

        //---- cancelbtn ----
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(e -> cancelbtn(e));

        //---- label1 ----
        label1.setText("Enter item that you have chosen:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("Enter number:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- addtocartbtn ----
        addtocartbtn.setText("Add to cart");
        addtocartbtn.addActionListener(e -> addtocartbtn(e));

        //---- orderbtn ----
        orderbtn.setText("Order");
        orderbtn.addActionListener(e -> orderbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //---- sumMoneyField ----
        sumMoneyField.setText("Total price:");
        sumMoneyField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(621, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(label2)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(backbtn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addtocartbtn))
                                .addComponent(tfItem, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                .addComponent(tfNumber, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 69, Short.MAX_VALUE)
                                    .addComponent(orderbtn))
                                .addComponent(sumMoneyField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                            .addGap(28, 28, 28)
                            .addComponent(cancelbtn)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelbtn)
                        .addComponent(sumMoneyField))
                    .addGap(8, 8, 8)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(tfItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(tfNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(orderbtn, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(backbtn)
                        .addComponent(addtocartbtn))
                    .addGap(29, 29, 29))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tablecartitem;
    private JScrollPane scrollPane2;
    private JTable tablecart;
    private JSeparator separator1;
    private JButton cancelbtn;
    private JLabel label1;
    private JTextField tfItem;
    private JLabel label2;
    private JTextField tfNumber;
    private JButton addtocartbtn;
    private JButton orderbtn;
    private JButton backbtn;
    private JLabel sumMoneyField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
