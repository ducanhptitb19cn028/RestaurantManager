/*
 * Created by JFormDesigner on Thu Apr 07 08:34:22 ICT 2022
 */

package view.item;

import dao.ItemDAO;
import view.db.DBConnection;
import model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author unknown
 */
public class UpdateItem extends JFrame {
    private final ItemDAO itemDAO;
    public UpdateItem() {
        this.itemDAO = new ItemDAO();
        initComponents();
        InsertDatabaseintoTable();
    }
    public Item item;

    public void InsertDatabaseintoTable(){
        Object[] ob = new Object[10];
        DefaultTableModel table = (DefaultTableModel)itemtb.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM items";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getString("name");
                ob[1]=rs.getBigDecimal("price");
                ob[2]=rs.getInt("quantity");
                ob[3]=rs.getDate("import_date");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String newName = tfNewname.getText().trim();
        String newPrice = tfNewprice.getText().trim();
        String newQuantity = tfNewQuantity.getText().trim();
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Item name cannot be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!itemDAO.existsItem(name)){
            JOptionPane.showMessageDialog(this, "Item name does not exist!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newName.isEmpty()){
            JOptionPane.showMessageDialog(this, "New item name cannot be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPrice.chars().allMatch(Character::isDigit)
                || Double.parseDouble(newPrice) <= 0){
            JOptionPane.showMessageDialog(this, "Please enter a valid price for the item!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newQuantity.chars().allMatch(Character::isDigit) || Integer.parseInt(newQuantity)<=0){
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity for the item!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date dtToday = new Date();
        java.sql.Date date = new java.sql.Date(dtToday.getTime());
        Item item = new Item(newName,BigDecimal.valueOf(Double.parseDouble(newPrice)),Integer.parseInt(newQuantity),date);
        itemDAO.updateItem(name,item);
        tfName.setText("");
        tfNewname.setText("");
        tfNewprice.setText("");
        tfNewQuantity.setText("");
        JOptionPane.showMessageDialog(this, "Item has been updated!!");
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ItemManager im = new ItemManager();
        im.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        itemtb = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        tfName = new JTextField();
        tfNewname = new JTextField();
        tfNewprice = new JTextField();
        tfNewQuantity = new JTextField();
        updatebtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        setTitle("Update items in stock");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- itemtb ----
            itemtb.setDropMode(DropMode.INSERT_ROWS);
            itemtb.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "name", "price", "quantity", "import_date"
                }
            ));
            scrollPane1.setViewportView(itemtb);
        }

        //---- label1 ----
        label1.setText("Enter item that need updating");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 12));

        //---- label2 ----
        label2.setText("New name:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 12));

        //---- label3 ----
        label3.setText("New price:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 12));

        //---- label4 ----
        label4.setText("New quantity:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 12));

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
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(tfNewprice, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(tfNewname, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(tfNewQuantity, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(updatebtn)
                    .addGap(94, 94, 94)
                    .addComponent(backbtn)
                    .addContainerGap(89, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfNewname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfNewprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(tfNewQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(updatebtn)
                        .addComponent(backbtn))
                    .addGap(54, 54, 54))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        UpdateItem ui = new UpdateItem();
        ui.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable itemtb;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField tfName;
    private JTextField tfNewname;
    private JTextField tfNewprice;
    private JTextField tfNewQuantity;
    private JButton updatebtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
