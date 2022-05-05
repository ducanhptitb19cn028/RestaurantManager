/*
 * Created by JFormDesigner on Sun May 01 18:21:16 ICT 2022
 */

package view.order;

import dao.CartDAO;
import view.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class BillManager extends JFrame {
    public BillManager() {
        initComponents();
        InsertDatabaseintoTable();
    }
    public void InsertDatabaseintoTable(){
        Object[] ob = new Object[10];
        DefaultTableModel table = (DefaultTableModel)tablebill.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM tblorder";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                ob[0]=rs.getInt("orderid");
                ob[1]=rs.getInt("quantity");
                ob[2]=rs.getBigDecimal("oprice");
                ob[3]=rs.getDate("orderday");
                ob[4]=rs.getString("staff");
                table.addRow(ob);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printbtn(ActionEvent e) {
        // TODO add your code here
        try {
            boolean print = txtbill.print();
            if (print) {
                JOptionPane.showMessageDialog(null, "Done printing");
            } else {
                JOptionPane.showMessageDialog(null, "Printing cancel", "Printer", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
        }
    }

    private void clearcartbtn(ActionEvent e) {
        // TODO add your code here
        CartDAO.clearCart();
        JOptionPane.showMessageDialog(this,"Cart has been cleared!!!");
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        OrderManagement om = new OrderManagement();
        om.setVisible(true);
    }

    private void showbtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        PrintWriter pw ;
        try {
            pw= new PrintWriter(String.valueOf(BillManager.class.getResource("./bill/billprinter.csv")));
            StringBuilder sb=new StringBuilder("Your pleasure is our utmost pride!!\n");
            String header = "Name  \tPrice  \tNumber\n";
            sb.append(header);
            Connection conn = DBConnection.getConnection();
            String query="SELECT * FROM cart";
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                sb.append(rs.getString("cname"));
                sb.append("\t");
                sb.append(rs.getBigDecimal("price"));
                sb.append("\t");
                sb.append(rs.getInt("num"));
                sb.append("\n");
            }
            sb.append("Total price:\t").append(CartDAO.getTotalPrice());
            pw.write(sb.toString());
            txtbill.setText(sb.toString());
            pw.close();
            JOptionPane.showMessageDialog(BillManager.this, "Cart has been added to csv file");

        } catch (Exception ex) {
            // TODO: handle exception

        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        var contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        BillManager bm = new BillManager();
        bm.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
