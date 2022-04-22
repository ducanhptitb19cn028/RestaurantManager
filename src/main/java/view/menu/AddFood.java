/*
 * Created by JFormDesigner on Sun Apr 17 00:06:09 ICT 2022
 */

package view.menu;

import dao.MenuDAO;
import model.Menuuu;
import view.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.Image.SCALE_SMOOTH;
import static javax.swing.UIManager.get;

/**
 * @author unknown
 */
public class AddFood extends JFrame {
    public File file = null;
    public static String path = null;

    public MenuDAO menuDAO;
    ArrayList<Menuuu> list = new ArrayList<>();
    public AddFood() {
        initComponents();
        this.menuDAO = new MenuDAO();
        InsertDatabaseintoTable();
    }
    public void InsertDatabaseintoTable(){
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindTable();
        String[] columns = {"No", "Food", "Image", "Price", "Unit"};
        Object[][] rows = new Object[list.size()][6];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getFood();
            if(list.get(i).getImages() != null){
                ImageIcon img = new ImageIcon(new ImageIcon(list.get(i).getImages()).getImage().getScaledInstance(64,64, SCALE_SMOOTH));
                rows[i][2]= img;
            }
            else{
                rows[i][2] = null;
            }
            rows[i][3] = list.get(i).getPrice();
            rows[i][4] = list.get(i).getUnit();
        }
        TheModel model = new TheModel(rows, columns);
        tablemenu.setModel(model);
        tablemenu.setRowHeight(64);
        tablemenu.getColumnModel().getColumn(2).setPreferredWidth(64);
    }
    private void Addbtn(ActionEvent e) {
        // TODO add your code here
        String food = tfFood.getText();
        String price = tfPrice.getText();
        String unit = tfUnit.getText();

        if (food.isEmpty()){
            JOptionPane.showMessageDialog(this, "Food field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price.isEmpty() || !price.chars().allMatch( Character::isDigit)){
            JOptionPane.showMessageDialog(this, "Please enter a valid value!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (unit.isEmpty()){
            JOptionPane.showMessageDialog(this, "Unit field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File f = new File(path);
        try {
            InputStream is = new FileInputStream(f);
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO menu(food,image,price,unit) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,food);
            ps.setBlob(2,is);
            ps.setBigDecimal(3, BigDecimal.valueOf(Double.parseDouble(price)));
            ps.setString(4,unit);
            int i = ps.executeUpdate();
            if (i>0){
                JOptionPane.showMessageDialog(this,"Menu has been added!!!");
            }
            conn.close();
        }catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void choosebtn(ActionEvent e) {
        // TODO add your code here
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Add image");
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new FileTypeFilter(".jpg","JPG"));
        chooser.setFileFilter(new FileTypeFilter(".png","PNG"));
        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            path = file.getAbsolutePath();
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(64,64, SCALE_SMOOTH);
            imglbl.setIcon(new ImageIcon(img));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tablemenu = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tfFood = new JTextField();
        tfPrice = new JTextField();
        tfUnit = new JTextField();
        Addbtn = new JButton();
        backbtn = new JButton();
        choosebtn = new JButton();
        imglbl = new JLabel();

        //======== this ========
        setTitle("Add food");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tablemenu ----
            tablemenu.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "No", "Food", "Image", "Price", "Unit"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, Object.class, Byte.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(tablemenu);
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

        //---- Addbtn ----
        Addbtn.setText("Add");
        Addbtn.addActionListener(e -> Addbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");

        //---- choosebtn ----
        choosebtn.setText("Ch\u1ecdn \u1ea3nh");
        choosebtn.addActionListener(e -> choosebtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(choosebtn)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Addbtn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                                    .addComponent(backbtn)
                                    .addGap(65, 65, 65))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(430, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1))
                                    .addGap(45, 45, 45)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfPrice, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                                        .addComponent(tfFood, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                                        .addComponent(tfUnit, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))))
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
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
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(choosebtn)
                        .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn)
                        .addComponent(backbtn))
                    .addGap(19, 19, 19))
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
    private JTable tablemenu;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField tfFood;
    private JTextField tfPrice;
    private JTextField tfUnit;
    private JButton Addbtn;
    private JButton backbtn;
    private JButton choosebtn;
    private JLabel imglbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
