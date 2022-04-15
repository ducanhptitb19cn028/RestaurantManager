/*
 * Created by JFormDesigner on Fri Apr 08 10:52:24 ICT 2022
 */

package modules.item;

import modules.db.DBConnection;

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
    public DeleteItem() {
        initComponents();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        itemtb = new JTable();

        //======== this ========
        setTitle("Delete item");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- itemtb ----
            itemtb.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            itemtb.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, "", null, null},
                },
                new String[] {
                    "name", "price", "quantity", "import date"
                }
            ));
            scrollPane1.setViewportView(itemtb);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable itemtb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
