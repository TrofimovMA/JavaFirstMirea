package ru.mirea.GuildNet;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Stack;

class frmServer extends JFrame
{
    static int online = 0;
    static String database = "database.txt";
    static String fieldDelimiter = ":";
    static String recordDelimiter = "::";
    static ArrayList<User> users;
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

        // Заполнение базы данных
        resetDatabase();
        addClient("login1", "password1");
        addClient("login2", "password2");
        addClient("login3", "password3");

        // Загрузка базы данных
        updateDatabase();

        setVisible(true);
    }

    public static ArrayList<User> updateDatabase()
    {
        ArrayList<User> users = new ArrayList<User>();
        String text = "";
        try(FileReader reader = new FileReader("database.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                text += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println("DB:\n" + text+"\n");

        String[] records;
        String[] fields;
        records =  text.split(recordDelimiter);
        for (String record : records)
        {
            System.out.println("PARSING : "+ record);

            fields =  record.split(fieldDelimiter);
            for(String field : fields)
            {
                System.out.println("FIELD : " + field);
            }
        }

        return users;
    }

    public static void resetDatabase()
    {
            try(FileWriter writer = new FileWriter("database.txt", false))
            {
                writer.append("");
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
    }

    public static void addClient(String login, String password)
    {
        try(FileWriter writer = new FileWriter("database.txt", true))
        {
            String text = login + fieldDelimiter + password + recordDelimiter;
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
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