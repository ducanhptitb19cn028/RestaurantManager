/*
 * Created by JFormDesigner on Wed May 04 23:58:51 ICT 2022
 */

package view.auth;

import dao.UserDAO;
import model.User;
import view.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * @author unknown
 */
public class ChangePassword extends JFrame {
    private UserDAO userDAO;
    public ChangePassword() {
        initComponents();
        this.userDAO = new UserDAO();
    }

    private void cancelbtn(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
    }

    private void changebtn(ActionEvent e) {
        // TODO add your code here
        String oldPassword = String.valueOf(tfOldPassword.getPassword());
        String newPassword = String.valueOf(tfNewPassword.getPassword());
        String confirm = String.valueOf(tfConfirm.getPassword());
        User user = new User(Login.getUsernametext(), oldPassword);
        if (oldPassword.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Old password can not be empty","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)(?=.*?[#?!@$%^&*-]).{8,}$",newPassword) ){
            JOptionPane.showMessageDialog(this, "Password must have minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d)(?=.*?[#?!@$%^&*-]).{8,}$",confirm) ){
            JOptionPane.showMessageDialog(this, "Password must have minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character","Try again",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPassword.equals(confirm)){
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "Try again", JOptionPane.ERROR_MESSAGE);
            return;
        }
        userDAO.Update(user,newPassword);
        JOptionPane.showMessageDialog(this, "Password has been changed successfully!!");
        tfOldPassword.setText("");
        tfConfirm.setText("");
        tfNewPassword.setText("");
    }

    public static void main(String[] args) {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        tfOldPassword = new JPasswordField();
        tfNewPassword = new JPasswordField();
        tfConfirm = new JPasswordField();
        changebtn = new JButton();
        cancelbtn = new JButton();

        //======== this ========
        setTitle("Change password");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Change password");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label1.setIcon(new ImageIcon(getClass().getResource("/images/changepassword.png")));

        //---- label3 ----
        label3.setText("Old password:");

        //---- label4 ----
        label4.setText("New password:");

        //---- label5 ----
        label5.setText("Confirm password:");

        //---- changebtn ----
        changebtn.setText("Change");
        changebtn.addActionListener(e -> changebtn(e));

        //---- cancelbtn ----
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(e -> cancelbtn(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addComponent(tfConfirm, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label4))
                            .addGap(39, 39, 39)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(tfNewPassword, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addComponent(tfOldPassword, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(changebtn)
                    .addGap(59, 59, 59)
                    .addComponent(cancelbtn)
                    .addContainerGap(84, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addGap(66, 66, 66))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(tfOldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(tfNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(tfConfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(changebtn)
                        .addComponent(cancelbtn))
                    .addGap(32, 32, 32))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JPasswordField tfOldPassword;
    private JPasswordField tfNewPassword;
    private JPasswordField tfConfirm;
    private JButton changebtn;
    private JButton cancelbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
