package ru.mirea.GuildNet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.*;
import java.util.Stack;

class frmClient extends JFrame
{
    static int ID = -1;

    JPanel pnlLogin = new JPanel();
    JPanel pnlMyPage = new JPanel();
    // Login Window
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JTextField txtLogin = new JTextField("login");
    JTextField txtPassword = new JTextField("password");
    JButton btnLogin = new JButton("LOG IN");
    // MyPage Window
    JLabel lblTitle = new JLabel("My Page");
    JLabel lblFamilyStatus = new JLabel("Family Status:");
    JComboBox lstFamilyStatus = new JComboBox(App.FamilyStatus.values());
    JLabel lblFavNum= new JLabel("Favourite Number:");
    JTextField txtFavNum = new JTextField("0");
    JLabel lblNewPassword= new JLabel("Password:");
    JTextField txtNewPassword = new JTextField("password");

    frmClient()
    {
        super("GuildNet: Client");

        // ВРЕМЕННО !!!
        ID = 1;
        txtNewPassword.setText(frmServer.users.get(ID).password);

        setSize(300,450);
        setMinimumSize(new Dimension(300, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // Функционал
        // Login Window
        btnLogin.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                       // Вход пользователя
                        ID = frmServer.clientLogin(txtLogin.getText(), txtPassword.getText());
                        if(ID > 0)
                        {
                            // Успешный вход
                            txtPassword.setText(frmServer.users.get(ID).password);
                        }else{
                            JOptionPane.showMessageDialog(null, "Wrong credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        // MyPage Window
        lstFamilyStatus.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() != ItemEvent.SELECTED)
                            return;

                        frmServer.clientCmdChangeFS(ID, App.FamilyStatus.valueOf(lstFamilyStatus.getSelectedItem().toString()));
                    }
                }
        );
        txtFavNum.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { check(); }
            public void removeUpdate(DocumentEvent e) { check(); }
            public void insertUpdate(DocumentEvent e) { check(); }

            public void check() {
                try
                {
                    int favNum = Integer.parseInt(txtFavNum.getText());
                    txtFavNum.setBackground(Color.GREEN);
                    frmServer.clientCmdChangeFavNum(ID, favNum);
                }
                catch (java.lang.NumberFormatException e)
                {
                    txtFavNum.setBackground(Color.RED);
                }
            }
        });
        txtNewPassword.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { check(); }
            public void removeUpdate(DocumentEvent e) { check(); }
            public void insertUpdate(DocumentEvent e) { check(); }

            public void check() {
                try
                {
                    String newPassword  = lengthCheck(txtNewPassword.getText());
                    txtNewPassword.setBackground(Color.GREEN);
                    frmServer.clientCmdChangePassword(ID, newPassword);
                }
                catch (Exception e)
                {
                    txtNewPassword.setBackground(Color.RED);
                }
            }

            public String lengthCheck(String password) throws Exception
            {
                if(password.length() < 4)
                    throw new Exception("Password is too short !");
                return password;
            }
        });


        // UI
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridLayout(1, 1));
        pnlLogin.setBackground(Color.PINK);
        pnlLogin.setLayout(new GridBagLayout());
        add(pnlLogin);
        pnlMyPage.setBackground(Color.GREEN);
        pnlMyPage.setLayout(new GridBagLayout());
        remove(pnlLogin);
        add(pnlMyPage);
        // UI Login Window
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5f;
        gbc.weighty = 0.5f;
        gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 1;
        pnlLogin.add(lblLogin, gbc);
        gbc.gridy = 0; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlLogin.add(txtLogin, gbc);
        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 1;
        pnlLogin.add(lblPassword, gbc);
        gbc.gridy = 1; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlLogin.add(txtPassword, gbc);
        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlLogin.add(btnLogin, gbc);
        // UI MyPage Window
        lblTitle.setFont(new Font("Times new roman", Font.BOLD,20));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setVerticalAlignment(SwingConstants.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5f;
        gbc.weighty = 0.5f;
        gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlMyPage.add(lblTitle, gbc);
        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 1;
        pnlMyPage.add(lblFamilyStatus, gbc);
        gbc.gridy = 1; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlMyPage.add(lstFamilyStatus, gbc);
        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 1;
        pnlMyPage.add(lblFavNum, gbc);
        txtFavNum.setBackground(Color.GREEN);
        gbc.gridy = 2; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlMyPage.add(txtFavNum, gbc);
        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 1;
        pnlMyPage.add(lblNewPassword, gbc);
        txtNewPassword.setBackground(Color.GREEN);
        gbc.gridy = 3; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlMyPage.add(txtNewPassword, gbc);


        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frmServer.clientDisconnect();
            }
        });
    }
}