package ru.mirea.GuildNet;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Stack;

class frmServer extends JFrame
{
    static int online = 0;
    static String database = "resources/database.txt";
    static String fieldDelimiter = ":";
    static String recordDelimiter = "::";
    static ArrayList<User> users;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    JLabel lblInfo = new JLabel("INFO");
    JButton btnAddClient = new JButton("Add Client");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");

    frmServer()
    {
        // Окно
        super("GuildNet: Server");
        logMsg("SERVER START");
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
        users = updateDatabase();

        // Результат загрузки
        String dbInfo = "";
        for(User user : users)
        {
            dbInfo += "\n"+user.toString();
        }
        logMsg("DATABASE LOADED"+dbInfo);

        setVisible(true);

        new frmClient();
    }

    public static ArrayList<User> updateDatabase()
    {
        ArrayList<User> users = new ArrayList<User>();
        String text = "";
        try(FileReader reader = new FileReader(database)) {
            int c;
            while ((c = reader.read()) != -1) {
                text += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        String[] records;
        String[] fields;
        records = text.split(recordDelimiter);
        for (String record : records)
        {
            if(record == "")
                continue;

            fields =  record.split(fieldDelimiter);

            users.add(new User(fields[0], fields[1]));
        }

        return users;
    }

    public static void resetDatabase()
    {
            try(FileWriter writer = new FileWriter(database, false))
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
        try(FileWriter writer = new FileWriter(database, true))
        {
            String text = login + fieldDelimiter + password + recordDelimiter;
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static boolean clientLogin(String login, String password)
    {
        int id=-1, c=0;
        for(User u : users)
        {
            ++c;
            if(login.equals(u.login) == true)
            {
                id = c;
                break;
            }
        }

        if(id == -1) // пользователь не найден
        {
            logMsg("Login Error : User with Login ["+login+"] not found");
            return false;
        }

        if(password.equals(users.get(id-1).password) == false) // пароль не верен
        {
            logMsg("Login Error : Incorrect Password on Login ["+login+"]");
            return false;
        }

        logMsg("CLIENT LOGIN : ["+login+"]");

        return true;
    }

    public static void clientConnect()
    {
        ++online;
        new frmClient();
    }

    public static void clientDisconnect()
    {
        --online;
    }

    public static void logMsg(String msg)
    {
        System.out.println(dateFormat.format(new Date()) + " :: " + msg);
    }
}