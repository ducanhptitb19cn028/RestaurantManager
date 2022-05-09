/*
 * Created by JFormDesigner on Thu Apr 14 11:57:04 ICT 2022
 */

package view.labour;

import dao.LabourDAO;
import model.Labour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author unknown
 */
public class AddLabour extends JFrame {
    private final LabourDAO labctrl;
    public AddLabour() {
        initComponents();
        this.labctrl = new LabourDAO();
    }
    private void addbtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String dob = tfBirthday.getText().trim();
        String email = tfEmail.getText().trim();
        String phone = tfPhone.getText().trim();
        String address = tfAddress.getText().trim();
        String position = tfPosition.getText().trim();
        String sal = tfSalary.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Labour's name cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Date of birth cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!dob.matches("^(0?[1-9]|[12]\\d|3[01])[/\\-](0?[1-9]|1[012])[/\\-]\\d{4}$")){
            JOptionPane.showMessageDialog(this, "Date of birth is not valid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (email.isEmpty() || !Pattern.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$", email)){
            JOptionPane.showMessageDialog(this, "Email is empty or not valid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (phone.isEmpty() || !phone.chars().allMatch( Character::isDigit)){
            JOptionPane.showMessageDialog(this, "Phone is empty or not valid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (address.isEmpty()){
            JOptionPane.showMessageDialog(this, "Address can not be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (position.isEmpty()){
            JOptionPane.showMessageDialog(this, "Position can not be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sal.isEmpty() || !sal.chars().allMatch( Character::isDigit) || Double.parseDouble(sal)<=0){
            JOptionPane.showMessageDialog(this, "Salary is empty or not valid","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Labour labour = new Labour(name,dob,email,phone,address,position,BigDecimal.valueOf(Double.parseDouble(sal.trim())));
        labctrl.addLabour(labour);
        tfName.setText("");
        tfBirthday.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfAddress.setText("");
        tfPosition.setText("");
        tfSalary.setText("");
        JOptionPane.showMessageDialog(this, "Item has been added");
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        LabourManager lm = new LabourManager();
        lm.setVisible(true);
    }

    public static void main(String[] args) {
        AddLabour addLabour = new AddLabour();
        addLabour.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Duc Anh
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        tfName = new JTextField();
        tfEmail = new JTextField();
        tfPhone = new JTextField();
        tfAddress = new JTextField();
        tfPosition = new JTextField();
        tfSalary = new JTextField();
        label7 = new JLabel();
        addbtn = new JButton();
        backbtn = new JButton();
        label8 = new JLabel();
        tfBirthday = new JTextField();

        //======== this ========
        setTitle("Add labour");
        setBackground(new Color(153, 255, 255));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Name:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("Email:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label3 ----
        label3.setText("Phone:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label4 ----
        label4.setText("Address:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label5 ----
        label5.setText("Position:");
        label5.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label6 ----
        label6.setText("Salary:");
        label6.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfName ----
        tfName.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfEmail ----
        tfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfPhone ----
        tfPhone.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfAddress ----
        tfAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfPosition ----
        tfPosition.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfSalary ----
        tfSalary.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/images/labour.png")));
        label7.setText("Recruited!!!");
        label7.setFont(new Font("Segoe UI", Font.BOLD, 18));

        //---- addbtn ----
        addbtn.setText("Add");
        addbtn.addActionListener(e -> addbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //---- label8 ----
        label8.setText("Date of birth:");
        label8.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfBirthday ----
        tfBirthday.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addComponent(addbtn)
                            .addGap(52, 52, 52)
                            .addComponent(backbtn))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label6)
                                        .addComponent(label8)
                                        .addComponent(label1))
                                    .addGap(44, 44, 44)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(tfEmail, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfBirthday, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfPhone, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfAddress, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfPosition, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfSalary, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(label7)
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBirthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(tfAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(tfPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn)
                        .addComponent(backbtn))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Duc Anh
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JTextField tfPosition;
    private JTextField tfSalary;
    private JLabel label7;
    private JButton addbtn;
    private JButton backbtn;
    private JLabel label8;
    private JTextField tfBirthday;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
