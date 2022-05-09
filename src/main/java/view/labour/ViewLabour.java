/*
 * Created by JFormDesigner on Sun Apr 17 00:04:32 ICT 2022
 */

package view.labour;

import dao.db.DBConnection;

import java.awt.*;
import java.awt.event.*;
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
public class ViewLabour extends JFrame {
    public ViewLabour() {
        initComponents();
        InsertDatabaseintoTable();
    }

    private void addbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        AddLabour addLabour = new AddLabour();
        addLabour.setVisible(true);
    }
    public void InsertDatabaseintoTable(){
        Object[] ob = new Object[10];
        DefaultTableModel table = (DefaultTableModel)table1.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tbllabour";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getInt("labour_id");
                ob[1]=rs.getString("name");
                ob[2]=rs.getString("date_ofBirth");
                ob[3]=rs.getString("email");
                ob[4]=rs.getString("phone");
                ob[5]=rs.getString("address");
                ob[6]=rs.getString("position");
                ob[7]=rs.getBigDecimal("salary");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deletebtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        DeleteLabour dl = new DeleteLabour();
        dl.setVisible(true);
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        UpdateLabour ul = new UpdateLabour();
        ul.setVisible(true);
    }

    private void Backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        LabourManager lm = new LabourManager();
        lm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        addbtn = new JButton();
        deletebtn = new JButton();
        updatebtn = new JButton();
        Backbtn = new JButton();

        //======== this ========
        setTitle("View labour");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Labour id", "Name", "Date of birth", "Email", "Phone", "Address", "Position", "Salary"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("Labour list");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        //---- addbtn ----
        addbtn.setText("Add");
        addbtn.addActionListener(e -> addbtn(e));

        //---- deletebtn ----
        deletebtn.setText("Delete");
        deletebtn.addActionListener(e -> deletebtn(e));

        //---- updatebtn ----
        updatebtn.setText("Update");
        updatebtn.addActionListener(e -> updatebtn(e));

        //---- Backbtn ----
        Backbtn.setText("Back");
        Backbtn.addActionListener(e -> Backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(270, 270, 270)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addComponent(deletebtn, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(addbtn, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(Backbtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(updatebtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn)
                        .addComponent(updatebtn))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deletebtn)
                        .addComponent(Backbtn))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        ViewLabour vl = new ViewLabour();
        vl.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton addbtn;
    private JButton deletebtn;
    private JButton updatebtn;
    private JButton Backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
