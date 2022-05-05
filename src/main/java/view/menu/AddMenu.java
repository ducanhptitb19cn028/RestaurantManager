/*
 * Created by JFormDesigner on Sun Apr 17 00:06:09 ICT 2022
 */

package view.menu;

import dao.CartItemDAO;
import dao.MenuDAO;
import model.CartItem;
import model.Menuuu;
import view.auth.Login;
import view.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * @author unknown
 */
public class AddMenu extends JFrame {
    public File file = null;
    public Menuuu menu;
    public static String path = null;
    public CartItemDAO cartItemDAO;
    public MenuDAO menuDAO;

    public AddMenu() {
        initComponents();
        this.menuDAO = new MenuDAO();

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
    private void Addbtn(ActionEvent e) {
        // TODO add your code here
        String name = tfName.getText().trim();
        String price = tfPrice.getText().trim();
        String kind = tfKind.getText().trim();
        String quantity = tfCQuantity.getText().trim();
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Name field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (price.isEmpty() || !price.chars().allMatch( Character::isDigit)){
            JOptionPane.showMessageDialog(this, "Please enter a valid value!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (kind.isEmpty()){
            JOptionPane.showMessageDialog(this, "Unit field can not be empty!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantity.isEmpty() || !quantity.chars().allMatch( Character::isDigit)){
            JOptionPane.showMessageDialog(this, "Please enter a valid value!!","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File f = new File(path);
        try {
            InputStream is = new FileInputStream(f);
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO menu(mname,image,price,kind,added_by) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setBlob(2,is);
            ps.setBigDecimal(3, BigDecimal.valueOf(Double.parseDouble(price)));
            ps.setString(4,kind);
            ps.setString(5, Login.getUsernametext());
            int i = ps.executeUpdate();
            if (i>0){
                JOptionPane.showMessageDialog(this,"Menu has been added!!!");
                tfName.setText("");
                tfPrice.setText("");
                tfKind.setText("");
            }
            conn.close();
        }catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        CartItem ci = new CartItem(name,BigDecimal.valueOf(Double.parseDouble(price)),Integer.parseInt(quantity));
        cartItemDAO.addCartItem(ci);
        tfCQuantity.setText("");
        InsertDatabaseintoTable();
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
        tfName = new JTextField();
        tfPrice = new JTextField();
        tfKind = new JTextField();
        Addbtn = new JButton();
        backbtn = new JButton();
        choosebtn = new JButton();
        imglbl = new JLabel();
        label4 = new JLabel();
        tfCQuantity = new JTextField();

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
                    "No", "Name", "Image", "Price", "Kind"
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
        label1.setText("Name:");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label2 ----
        label2.setText("Price:");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- label3 ----
        label3.setText("Kind:");
        label3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- tfName ----
        tfName.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfPrice ----
        tfPrice.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- tfKind ----
        tfKind.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        //---- Addbtn ----
        Addbtn.setText("Add");
        Addbtn.addActionListener(e -> Addbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //---- choosebtn ----
        choosebtn.setText("Ch\u1ecdn \u1ea3nh");
        choosebtn.addActionListener(e -> choosebtn(e));

        //---- label4 ----
        label4.setText("Quantity:");
        label4.setFont(new Font("Segoe UI", Font.BOLD, 14));

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
                            .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 424, Short.MAX_VALUE))
                        .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(label4))
                            .addGap(45, 45, 45)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(Addbtn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                                    .addComponent(backbtn)
                                    .addGap(57, 57, 57))
                                .addComponent(tfPrice, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(tfName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(tfKind, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(tfCQuantity, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label1)
                        .addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(tfPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfKind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(choosebtn)
                        .addComponent(imglbl, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Addbtn)
                        .addComponent(backbtn))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        AddMenu af = new AddMenu();
        af.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tablemenu;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField tfName;
    private JTextField tfPrice;
    private JTextField tfKind;
    private JButton Addbtn;
    private JButton backbtn;
    private JButton choosebtn;
    private JLabel imglbl;
    private JLabel label4;
    private JTextField tfCQuantity;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
