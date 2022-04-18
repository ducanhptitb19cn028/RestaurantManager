/*
 * Created by JFormDesigner on Sun Apr 17 00:04:32 ICT 2022
 */

package modules.labour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class ViewLabour extends JFrame {
    public ViewLabour() {
        initComponents();
    }

    private void addbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void deletebtn(ActionEvent e) {
        // TODO add your code here
    }

    private void updatebtn(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        addbtn = new JButton();
        deletebtn = new JButton();
        updatebtn = new JButton();

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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(276, 276, 276)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addComponent(addbtn)
                                    .addGap(69, 69, 69)
                                    .addComponent(deletebtn)
                                    .addGap(74, 74, 74)
                                    .addComponent(updatebtn)))
                            .addGap(0, 196, Short.MAX_VALUE)))
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
                        .addComponent(updatebtn)
                        .addComponent(deletebtn))
                    .addContainerGap(68, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton addbtn;
    private JButton deletebtn;
    private JButton updatebtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
