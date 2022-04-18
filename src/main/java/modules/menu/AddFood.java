/*
 * Created by JFormDesigner on Sun Apr 17 00:06:09 ICT 2022
 */

package modules.menu;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class AddFood extends JFrame {
    public AddFood() {
        initComponents();
    }
    public String duongdananh="D:\\RestaurantManager\\src\\main\\resources\\images\\pizza.png";
    private void choosefilebtn(ActionEvent e) {
        // TODO add your code here
        try {
            JFileChooser f =new JFileChooser(duongdananh);
            f.setDialogTitle("Open file");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            duongdananh= ftenanh.getAbsolutePath();

            lblanh.setIcon(ResizeImage(duongdananh));
            System.out.println(duongdananh);



        }
        catch(Exception ex) {
            System.out.println("chưa chọn ảnh");
            System.out.println(duongdananh);
        }
    }
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void Addbtn(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tfFood = new JTextField();
        tfPrice = new JTextField();
        tfUnit = new JTextField();
        choosefilebtn = new JButton();
        label4 = new JLabel();
        Addbtn = new JButton();
        backbtn = new JButton();
        lblanh = new JLabel();

        //======== this ========
        setTitle("Add food");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "No", "Food", "Image", "Price", "Unit"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("Food:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("Price:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label3 ----
        label3.setText("Unit:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfFood ----
        tfFood.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfPrice ----
        tfPrice.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfUnit ----
        tfUnit.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- choosefilebtn ----
        choosefilebtn.setText("Choose file");
        choosefilebtn.addActionListener(e -> choosefilebtn(e));

        //---- label4 ----
        label4.setText("Image");

        //---- Addbtn ----
        Addbtn.setText("Add");
        Addbtn.addActionListener(e -> Addbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfFood))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label3)
                                        .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(tfPrice)
                                        .addComponent(tfUnit)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(choosefilebtn)
                                            .addGap(53, 53, 53)
                                            .addComponent(lblanh)
                                            .addGap(0, 284, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(Addbtn)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                                            .addComponent(backbtn)
                                            .addGap(59, 59, 59)))))
                            .addGap(6, 6, 6))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(tfFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(choosefilebtn)
                        .addComponent(label4)
                        .addComponent(lblanh))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn)
                        .addComponent(backbtn))
                    .addGap(43, 43, 43))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        AddFood af = new AddFood();
        af.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField tfFood;
    private JTextField tfPrice;
    private JTextField tfUnit;
    private JButton choosefilebtn;
    private JLabel label4;
    private JButton Addbtn;
    private JButton backbtn;
    private JLabel lblanh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
