/*
 * Created by JFormDesigner on Sun May 01 18:21:16 ICT 2022
 */

package view.order;

import dao.CartDAO;
import dao.db.DBConnection;

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
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        tablebill = new JTable();
        showbtn = new JButton();
        printbtn = new JButton();
        clearcartbtn = new JButton();
        backbtn = new JButton();
        scrollPane2 = new JScrollPane();
        txtbill = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Thanks for using our service");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));

        //======== scrollPane1 ========
        {

            //---- tablebill ----
            tablebill.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Order ID", "Quantity", "Total Price", "Order day", "Created by"
                }
            ));
            scrollPane1.setViewportView(tablebill);
        }

        //---- showbtn ----
        showbtn.setText("Show the bill");
        showbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showbtnMouseClicked(e);
            }
        });

        //---- printbtn ----
        printbtn.setText("Print the bill");
        printbtn.addActionListener(e -> printbtn(e));

        //---- clearcartbtn ----
        clearcartbtn.setText("Clear the cart");
        clearcartbtn.addActionListener(e -> clearcartbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(txtbill);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(label1)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(showbtn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                            .addGap(132, 132, 132)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(backbtn, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addComponent(printbtn, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                            .addComponent(clearcartbtn))
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(showbtn)
                        .addComponent(printbtn)
                        .addComponent(clearcartbtn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(backbtn)
                    .addContainerGap(10, Short.MAX_VALUE))
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
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable tablebill;
    private JButton showbtn;
    private JButton printbtn;
    private JButton clearcartbtn;
    private JButton backbtn;
    private JScrollPane scrollPane2;
    private JTextArea txtbill;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
