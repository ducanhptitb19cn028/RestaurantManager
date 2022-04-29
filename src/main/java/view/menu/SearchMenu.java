/*
 * Created by JFormDesigner on Sat Apr 23 22:59:01 ICT 2022
 */

package view.menu;

import dao.MenuDAO;
import model.Menuuu;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * @author unknown
 */
public class SearchMenu extends JFrame {
    public SearchMenu() {
        initComponents();
    }
    private void searchbtn(ActionEvent e) {
        // TODO add your code here
        String search= tfSearch.getText().trim();
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindToSearch(search);
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

    private void drinkbtn(ActionEvent e) {
        // TODO add your code here
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindtoDrinksearch();
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

    private void foodbtn(ActionEvent e) {
        // TODO add your code here
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindtoFoodsearch();
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

    private void desertbtn(ActionEvent e) {
        // TODO add your code here
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindtoDessertsearch();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        tfSearch = new JTextField();
        scrollPane1 = new JScrollPane();
        tablemenu = new JTable();
        searchbtn = new JButton();
        drinkbtn = new JButton();
        foodbtn = new JButton();
        desertbtn = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("Search menu");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Search :");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));

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

        //---- searchbtn ----
        searchbtn.setIcon(new ImageIcon(getClass().getResource("/images/search.png")));
        searchbtn.addActionListener(e -> searchbtn(e));

        //---- drinkbtn ----
        drinkbtn.setText("List of drink");
        drinkbtn.addActionListener(e -> drinkbtn(e));

        //---- foodbtn ----
        foodbtn.setText("List of food");
        foodbtn.addActionListener(e -> foodbtn(e));

        //---- desertbtn ----
        desertbtn.setText("List of dessert");
        desertbtn.addActionListener(e -> desertbtn(e));

        //---- button4 ----
        button4.setText("Back");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfSearch, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchbtn, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(drinkbtn)
                            .addGap(108, 108, 108)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(foodbtn)
                                    .addGap(101, 101, 101)
                                    .addComponent(desertbtn))
                                .addComponent(button4))
                            .addGap(0, 66, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(tfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(searchbtn)))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(drinkbtn)
                        .addComponent(desertbtn)
                        .addComponent(foodbtn))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                    .addComponent(button4)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        SearchMenu searchMenu = new SearchMenu();
        searchMenu.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField tfSearch;
    private JScrollPane scrollPane1;
    private JTable tablemenu;
    private JButton searchbtn;
    private JButton drinkbtn;
    private JButton foodbtn;
    private JButton desertbtn;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
