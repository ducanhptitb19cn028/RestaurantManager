/*
 * Created by JFormDesigner on Sun Apr 17 00:06:23 ICT 2022
 */

package view.menu;

import dao.MenuDAO;
import model.Menuuu;
import view.db.DBConnection;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * @author unknown
 */
public class ModifyMenu extends JFrame {
    public File file = null;
    public static String path = null;

    public MenuDAO menuDAO;
    public ModifyMenu() {
        initComponents();
        this.menuDAO= new MenuDAO();
        InsertDatabaseintoTable();
    }

    public void InsertDatabaseintoTable(){
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindtoTable();
        String[] columns = {"No", "Name", "Image", "Price", "Kind"};
        Object[][] rows = new Object[list.size()][6];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getMname();
            if(list.get(i).getImages() != null){
                ImageIcon img = new ImageIcon(new ImageIcon(list.get(i).getImages()).getImage().getScaledInstance(64,64, SCALE_SMOOTH));
                rows[i][2]= img;
            }
            else{
                rows[i][2] = null;
            }
            rows[i][3] = list.get(i).getPrice();
            rows[i][4] = list.get(i).getKind();
        }
        TheModel model = new TheModel(rows, columns);
        tablemenu.setModel(model);
        tablemenu.setRowHeight(64);
        tablemenu.getColumnModel().getColumn(2).setPreferredWidth(64);
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
    private void modifybtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String newName = tfNewName.getText().trim();
        String newPrice= tfNewPrice.getText().trim();
        String newKind = tfNewKind.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!menuDAO.MenuExists(name)){
            JOptionPane.showMessageDialog(this, "This item does not exist in menu!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newName.isEmpty()){
            JOptionPane.showMessageDialog(this, "New name field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newPrice.isEmpty() || !newPrice.chars().allMatch( Character::isDigit) || Double.parseDouble(newPrice) <=0){
            JOptionPane.showMessageDialog(this, "Please enter a valid value!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newKind.isEmpty()){
            JOptionPane.showMessageDialog(this, "Kind field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File f = new File(path);
        try {
            InputStream is = new FileInputStream(f);
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE menu SET mname = ?, image = ?, price = ?, kind = ? WHERE mname = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,newName);
            ps.setBlob(2,is);
            ps.setBigDecimal(3,BigDecimal.valueOf(Double.parseDouble(newPrice)));
            ps.setString(4,newKind);
            ps.setString(5,name);
            int i = ps.executeUpdate();
            if (i>0){
                JOptionPane.showMessageDialog(this,"Menu has been modified!!!");
            }
            conn.close();
        }catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MenuView mv = new MenuView();
        mv.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tablemenu = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        tfName = new JTextField();
        tfNewName = new JTextField();
        tfNewPrice = new JTextField();
        tfNewKind = new JTextField();
        choosebtn = new JButton();
        imglbl = new JLabel();
        modifybtn = new JButton();
        backbtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tablemenu ----
            tablemenu.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "No", "Name", "Image", "Price", "Kind"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Object.class, Object.class, Byte.class, Object.class, Object.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            scrollPane1.setViewportView(tablemenu);
        }

        //---- label1 ----
        label1.setText("Name:");

        //---- label2 ----
        label2.setText("New name:");

        //---- label3 ----
        label3.setText("New price:");

        //---- label4 ----
        label4.setText("New Kind:");

        //---- choosebtn ----
        choosebtn.setText("Ch\u1ecdn \u1ea3nh");
        choosebtn.addActionListener(e -> choosebtn(e));

        //---- modifybtn ----
        modifybtn.setText("Modify");
        modifybtn.addActionListener(e -> modifybtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(label4))
                                    .addGap(10, 10, 10)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(tfNewPrice)
                                        .addComponent(tfNewKind, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(label2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(tfNewName, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                                        .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(modifybtn, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                                    .addComponent(backbtn)
                                    .addGap(109, 109, 109)))
                            .addGap(37, 37, 37))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(choosebtn)
                            .addGap(59, 59, 59)
                            .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 448, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfNewName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfNewPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(tfNewKind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(choosebtn)
                        .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(modifybtn)
                        .addComponent(backbtn))
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        ModifyMenu mf = new ModifyMenu();
        mf.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tablemenu;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField tfName;
    private JTextField tfNewName;
    private JTextField tfNewPrice;
    private JTextField tfNewKind;
    private JButton choosebtn;
    private JLabel imglbl;
    private JButton modifybtn;
    private JButton backbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
