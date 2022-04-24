/*
 * Created by JFormDesigner on Sun Apr 17 00:12:29 ICT 2022
 */

package view.menu;

import java.awt.*;
import java.awt.event.*;
import dao.MenuDAO;
import model.Menuuu;
import view.MainMenu;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.ArrayList;

import static java.awt.Image.SCALE_SMOOTH;

/**
 * @author unknown
 */
public class MenuView extends JFrame {
    public MenuView() {
        initComponents();
        InsertDatabaseintoTable();
    }
    public void InsertDatabaseintoTable(){
        MenuDAO md = new MenuDAO();
        ArrayList<Menuuu> list = md.BindtoTable();
        String[] columns = {"No", "Name", "Image", "Price", "Kind"};
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
            rows[i][4] = list.get(i).getKind();
        }
        TheModel model = new TheModel(rows, columns);
        tablemenu.setModel(model);
        tablemenu.setRowHeight(64);
        tablemenu.getColumnModel().getColumn(2).setPreferredWidth(64);
    }

    private void addbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        AddMenu af = new AddMenu();
        af.setVisible(true);
    }

    private void modifybtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        ModifyMenu af = new ModifyMenu();
        af.setVisible(true);
    }


    private void searchbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        SearchMenu af = new SearchMenu();
        af.setVisible(true);
    }

    private void backbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tablemenu = new JTable();
        addbtn = new JButton();
        modifybtn = new JButton();
        searchbtn = new JButton();
        backbtn = new JButton();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tablemenu ----
            tablemenu.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
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

        //---- addbtn ----
        addbtn.setText("Add");
        addbtn.addActionListener(e -> addbtn(e));

        //---- modifybtn ----
        modifybtn.setText("Modify");
        modifybtn.addActionListener(e -> modifybtn(e));

        //---- searchbtn ----
        searchbtn.setText("Search");
        searchbtn.addActionListener(e -> searchbtn(e));

        //---- backbtn ----
        backbtn.setText("Back");
        backbtn.addActionListener(e -> backbtn(e));

        //---- label1 ----
        label1.setText("Menu");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(360, 360, 360)
                            .addComponent(label1)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap(622, Short.MAX_VALUE)
                                    .addComponent(modifybtn, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(searchbtn)
                                        .addComponent(addbtn))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                                    .addComponent(backbtn)))
                            .addGap(67, 67, 67)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(label1)
                    .addGap(28, 28, 28)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn)
                        .addComponent(modifybtn))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbtn)
                        .addComponent(backbtn))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        MenuView ms = new MenuView();
        ms.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tablemenu;
    private JButton addbtn;
    private JButton modifybtn;
    private JButton searchbtn;
    private JButton backbtn;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
