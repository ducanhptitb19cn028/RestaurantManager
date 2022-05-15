/*
 * Created by JFormDesigner on Wed Apr 06 20:20:02 ICT 2022
 */

package view.item;

import java.awt.*;
import java.awt.event.*;
import dao.db.DBConnection;

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
            String query = "SELECT * FROM tblitem";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getString("name");
                ob[1]=rs.getBigDecimal("price");
                ob[2]=rs.getInt("quantity");
                ob[3]=rs.getDate("import_date");
                ob[4]=rs.getString("imported_by");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ItemManagement im = new ItemManagement();
        im.setVisible(true);
    }

    private void addbtn(ActionEvent e) {
        // TODO add your code here
        AddItem addItem = new AddItem();
        addItem.setVisible(true);
    }

    private void deletebtn(ActionEvent e) {
        // TODO add your code here
        DeleteItem deleteItem = new DeleteItem();
        deleteItem.setVisible(true);
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
        UpdateItem ui = new UpdateItem();
        ui.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        scrollPane1 = new JScrollPane();
        itemtb = new JTable();
        backbtn = new JButton();
        addbtn = new JButton();
        deletebtn = new JButton();
        updatebtn = new JButton();
        label1 = new JLabel();

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
                    "name", "price", "quantity", "import_date", "imported_by"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Object.class, Object.class, Object.class, Object.class
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

        //---- addbtn ----
        addbtn.setText("Add");
        addbtn.addActionListener(e -> addbtn(e));

        //---- deletebtn ----
        deletebtn.setText("Delete");
        deletebtn.addActionListener(e -> deletebtn(e));

        //---- updatebtn ----
        updatebtn.setText("Update");
        updatebtn.addActionListener(e -> updatebtn(e));

        //---- label1 ----
        label1.setText("Item list");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(addbtn)
                            .addGap(54, 54, 54)
                            .addComponent(deletebtn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                            .addComponent(updatebtn)
                            .addGap(62, 62, 62)
                            .addComponent(backbtn)
                            .addGap(25, 25, 25)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(237, 237, 237)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(240, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addGap(59, 59, 59)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn)
                        .addComponent(deletebtn)
                        .addComponent(backbtn)
                        .addComponent(updatebtn))
                    .addGap(111, 111, 111))
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
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JScrollPane scrollPane1;
    private JTable itemtb;
    private JButton backbtn;
    private JButton addbtn;
    private JButton deletebtn;
    private JButton updatebtn;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
