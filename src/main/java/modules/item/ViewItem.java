/*
 * Created by JFormDesigner on Wed Apr 06 20:20:02 ICT 2022
 */

package modules.item;

import java.awt.*;
import java.awt.event.*;
import modules.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class ViewItem extends JFrame {
    public ViewItem() {

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
        backbtn = new JButton();

        //======== this ========
        setTitle("Item");
        setBackground(new Color(255, 255, 153));
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setBackground(new Color(255, 255, 153));

            //---- itemtb ----
            itemtb.setDropMode(DropMode.INSERT_ROWS);
            itemtb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            itemtb.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "name", "price", "quantity", "import_date"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Object.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            itemtb.setSelectionForeground(new Color(255, 255, 153));
            itemtb.setBackground(new Color(255, 255, 153));
            scrollPane1.setViewportView(itemtb);
        }

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(backbtn)
                    .addContainerGap(183, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addGap(66, 66, 66)
                    .addComponent(backbtn)
                    .addGap(104, 104, 104))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        ViewItem vi = new ViewItem();
        vi.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable itemtb;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
