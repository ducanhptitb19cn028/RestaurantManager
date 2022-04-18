/*
 * Created by JFormDesigner on Sun Apr 17 00:02:44 ICT 2022
 */

package modules.labour;

import controller.LabourController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class DeleteLabour extends JFrame {
    private LabourController labourController;
    public DeleteLabour() {
        initComponents();
        this.labourController= new LabourController();
    }

    private void deletebtn(ActionEvent e) {
        // TODO add your code here
        String name= tfName.getText().trim();
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Labour name cannot be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        labourController.deleteLabours(name);
        tfName.setText("");
        JOptionPane.showMessageDialog(this, "Delete labour successfully!!!");
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        LabourManager lm = new LabourManager();
        lm.setVisible(true);
    }

    public static void main(String[] args) {
        DeleteLabour dl = new DeleteLabour();
        dl.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        deletebtn = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        tfName = new JTextField();

        //======== this ========
        setTitle("Delete labour");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Name", "Date of birth", "Address"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- deletebtn ----
        deletebtn.setText("Delete");
        deletebtn.addActionListener(e -> deletebtn(e));

        //---- button2 ----
        button2.setText("Back");
        button2.addActionListener(e -> button2(e));

        //---- label2 ----
        label2.setText("Enter name that need delete");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(deletebtn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(95, 95, 95))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label2)
                    .addGap(18, 18, 18)
                    .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(deletebtn)
                        .addComponent(button2))
                    .addGap(30, 30, 30))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton deletebtn;
    private JButton button2;
    private JLabel label2;
    private JTextField tfName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
