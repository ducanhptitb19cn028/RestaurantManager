/*
 * Created by JFormDesigner on Sun Apr 17 00:03:07 ICT 2022
 */

package view.labour;

import java.awt.event.*;

import dao.LabourDAO;
import model.Labour;
import view.db.DBConnection;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class UpdateLabour extends JFrame {
    public LabourDAO labourDAO;
    public UpdateLabour() {
        initComponents();
        InsertDatabaseintoTable();
    }
    public void InsertDatabaseintoTable(){
        Object[] ob = new Object[10];
        DefaultTableModel table = (DefaultTableModel)tblLabour.getModel();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM labour";
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

    private void updbtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String newname = tfNewName.getText().trim();
        String newbirth = tfNewBirthday.getText().trim();
        String newemail = tfNewEmail.getText().trim();
        String newphone = tfNewPhonenum.getText().trim();
        String newaddress = tfNewAddress.getText().trim();
        String newposition = tfNewPosition.getText().trim();
        String newsalary = tfNewSalary.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Labour name cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Labour name cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newbirth.isEmpty() || !newbirth.matches("^(0?[1-9]|[12]\\d|3[01])[/\\-](0?[1-9]|1[012])[/\\-]\\d{4}$")){
            JOptionPane.showMessageDialog(this, "Date of birth can not be empty or invalid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newemail.isEmpty() || !Pattern.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$", newemail)){
            JOptionPane.showMessageDialog(this, "Email can not be empty or invalid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newphone.isEmpty() || !newphone.chars().allMatch( Character::isDigit)){
            JOptionPane.showMessageDialog(this, "Phone can not be empty or invalid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newaddress.isEmpty()){
            JOptionPane.showMessageDialog(this, "Address can not be empty or invalid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newposition.isEmpty()){
            JOptionPane.showMessageDialog(this, "Position can not be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newsalary.isEmpty() || !newsalary.chars().allMatch( Character::isDigit) || Double.parseDouble(newsalary) <=0 ){
            JOptionPane.showMessageDialog(this, "Salary is empty or not valid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Labour labour = new Labour(newname,newbirth,newemail,newphone,newaddress,newposition, BigDecimal.valueOf(Double.parseDouble(newsalary)));
        labourDAO.updateLabours(labour,name);
        tfName.setText("");
        tfNewName.setText("");
        tfNewBirthday.setText("");
        tfNewEmail.setText("");
        tfNewPhonenum.setText("");
        tfNewAddress.setText("");
        tfNewPosition.setText("");
        tfNewSalary.setText("");
        JOptionPane.showMessageDialog(this, "Labour has been updated!!");
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        LabourManager lm = new LabourManager();
        lm.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tblLabour = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        tfName = new JTextField();
        tfNewName = new JTextField();
        tfNewBirthday = new JTextField();
        tfNewEmail = new JTextField();
        tfNewPhonenum = new JTextField();
        tfNewAddress = new JTextField();
        tfNewPosition = new JTextField();
        tfNewSalary = new JTextField();
        updbtn = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Update labour");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tblLabour ----
            tblLabour.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Labour ID", "Name", "Birthday", "Email", "Phone", "Address", "Position", "Salary"
                }
            ));
            scrollPane1.setViewportView(tblLabour);
        }

        //---- label1 ----
        label1.setText("Enter a person who need updating:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("New name:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label3 ----
        label3.setText("New Birthday:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label4 ----
        label4.setText("New email:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label5 ----
        label5.setText("New phone number:");
        label5.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label6 ----
        label6.setText("New address:");
        label6.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label7 ----
        label7.setText("New position:");
        label7.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label8 ----
        label8.setText("New salary:");
        label8.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- updbtn ----
        updbtn.setText("Update");
        updbtn.addActionListener(e -> updbtn(e));

        //---- button2 ----
        button2.setText("Back");
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label8)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewSalary, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewName, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewBirthday, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewEmail, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewPhonenum, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label6)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewAddress, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label7)
                            .addGap(18, 18, 18)
                            .addComponent(tfNewPosition, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(updbtn)
                    .addGap(161, 161, 161)
                    .addComponent(button2)
                    .addContainerGap(152, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfNewName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfNewBirthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(tfNewEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(tfNewPhonenum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(tfNewAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(tfNewPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(tfNewSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(updbtn)
                        .addComponent(button2))
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        UpdateLabour ul = new UpdateLabour();
        ul.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tblLabour;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField tfName;
    private JTextField tfNewName;
    private JTextField tfNewBirthday;
    private JTextField tfNewEmail;
    private JTextField tfNewPhonenum;
    private JTextField tfNewAddress;
    private JTextField tfNewPosition;
    private JTextField tfNewSalary;
    private JButton updbtn;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
