package ru.mirea.GuildNet;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Stack;

class frmServer extends JFrame
{
    static int online = 0;
    JLabel lblInfo = new JLabel("INFO");
    JButton btnAddClient = new JButton("Add Client");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");

    frmServer()
    {
        // Окно
        super("GuildNet: Server");
        setSize(300,450);
        setMinimumSize(new Dimension(300, 450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Функционал
        btnAddClient.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        clientConnect(); // Добавление очередного клиента
                    }
                });

        // UI
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5f;
        gbc.weighty = 0.5f;
        gbc.gridx = 0; gbc.gridy = 0;
        add(lblInfo, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(btnAddClient, gbc);
        gbc.gridx = 0; gbc.gridy = 2;
        add(btn1, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        add(btn2, gbc);
        gbc.gridx = 0; gbc.gridy = 4;
        add(btn3, gbc);

        // Загрузка базы данных
        updateDatabase();

        setVisible(true);
    }

    public static void updateDatabase()
    {
        String currentWorkingDir = System.getProperty("user.dir");
        System.out.println(currentWorkingDir);
    }

    public static void clientConnect()
    {
        new frmClient(++online);
    }

    public static void clientDisconnect()
    {
        --online;
    }
}