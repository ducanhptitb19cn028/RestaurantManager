/*
 * Created by JFormDesigner on Fri Apr 08 10:52:24 ICT 2022
 */

package view.item;

import java.awt.event.*;

import dao.ItemDAO;
import view.db.DBConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class DeleteItem extends JFrame {
    public ItemDAO itemDAO;
    public DeleteItem() {
        this.itemDAO = new ItemDAO();
        initComponents();
        InsertDatabaseintoTable();
    }
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

    private void deletebtn(ActionEvent e) {
        // TODO add your code here
        String name = tfItem.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item name cannot be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!itemDAO.existsItem(name)){
            JOptionPane.showMessageDialog(this, "Item name does not exist","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        itemDAO.deleteItem(name);
        JOptionPane.showMessageDialog(this, "Item has been deleted!!");
        tfItem.setText("");
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ItemManager im = new ItemManager();
        im.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        itemtb = new JTable();
        deletebtn = new JButton();
        label1 = new JLabel();
        tfItem = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("Delete item");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- itemtb ----
            itemtb.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            itemtb.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "name", "price", "quantity", "import date"
                }
            ));
            scrollPane1.setViewportView(itemtb);
        }

        //---- deletebtn ----
        deletebtn.setText("Delete");
        deletebtn.addActionListener(e -> deletebtn(e));

        //---- label1 ----
        label1.setText("Type item that you want to delete:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- button1 ----
        button1.setText("Back");
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(deletebtn)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addGap(0, 72, Short.MAX_VALUE))
                                .addComponent(tfItem, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deletebtn)
                        .addComponent(button1))
                    .addGap(39, 39, 39))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        DeleteItem di = new DeleteItem();
        di.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable itemtb;
    private JButton deletebtn;
    private JLabel label1;
    private JTextField tfItem;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
