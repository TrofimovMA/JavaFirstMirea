package ru.mirea.GuildNet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Stack;

class frmClient extends JFrame
{
    JTextField txtLogin = new JTextField("login");
    JTextField txtPassword = new JTextField("password");
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JButton btnLogin = new JButton("LOG IN");

    frmClient()
    {
        super("GuildNet: Client");

        setSize(300,450);
        setMinimumSize(new Dimension(300, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // Функционал
        btnLogin.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                       // Вход пользователя

                        if(frmServer.clientLogin(txtLogin.getText(), txtPassword.getText()))
                        {
                            //System.out.println("LOGINNED !!!");
                        }else{
                            //System.out.println("FAILED !!!");
                        }
                    }
                });

        // UI
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5f;
        gbc.weighty = 0.5f;
        gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 1;
        add(lblLogin, gbc);
        gbc.gridy = 0; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtLogin, gbc);
        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 1;
        add(lblPassword, gbc);
        gbc.gridy = 1; gbc.gridx = 1; gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtPassword, gbc);
        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(btnLogin, gbc);

        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frmServer.clientDisconnect();
            }
        });
    }
}