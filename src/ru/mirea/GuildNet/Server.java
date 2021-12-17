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
    static ArrayList<User> users;

    static String database = "resources/database.txt";
    static String fieldDelimiter = ":";
    static String recordDelimiter = "::";
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
        updateDatabase();

        // Результат загрузки
        reportDatabase();

        setVisible(true);

        //new frmClient();
    }

    public static ArrayList<User> updateDatabase()
    {
        users = new ArrayList<User>();
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
        String login;
        String password;
        App.FamilyStatus fs;
        int favNum;
        records = text.split(recordDelimiter);
        for (String record : records)
        {
            if(record == "")
                continue;

            fields =  record.split(fieldDelimiter);
            login = fields[0];
            password = fields[1];
            fs = App.FamilyStatus.valueOf(fields[2]);
            favNum = Integer. parseInt(fields[3]);

            users.add(new User(login, password, fs, favNum));
        }

        return users;
    }

    public static void reportDatabase()
    {
        String dbInfo = "";
        for(User user : users)
        {
            dbInfo += "\n"+user.toString();
        }
        logMsg("DATABASE REPORT"+dbInfo);
    }

    public static void resetDatabase()
    {
            try(FileWriter writer = new FileWriter(database, false))
            {
                writer.append("");
                writer.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    public static void rewriteDatabase()
    {
        String text = "";
        for(User u : users)
        {
            text += u.login + fieldDelimiter +
                    u.password + fieldDelimiter +
                    u.fs + fieldDelimiter +
                    u.favNum +
                    recordDelimiter;
        }
        try(FileWriter writer = new FileWriter(database, false))
        {
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void addClient(String login, String password)
    {
        App.FamilyStatus fs = App.FamilyStatus.NONE;
        int favNum = 0;
        try(FileWriter writer = new FileWriter(database, true))
        {
            String text = login + fieldDelimiter +
                    password + fieldDelimiter +
                    fs + fieldDelimiter +
                    favNum +
                    recordDelimiter;
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static int clientLogin(String login, String password)
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
            return -1;
        }

        if(password.equals(users.get(id-1).password) == false) // пароль не верен
        {
            logMsg("Login Error : Incorrect Password on Login ["+login+"]");
            return -1;
        }

        logMsg("CLIENT LOGIN : [ID:"+id+"] [Login:"+login+"]");

        return id;
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

    public static void clientCmdChangeFS(int id, App.FamilyStatus fs)
    {
        logMsg("CLIENT CHANGED FS : [ID:"+id+"] [Login:"+users.get(id).login+"] [FS:"+fs+"]");
        users.get(id-1).fs = fs;
        rewriteDatabase();
        updateDatabase();
    }

    public static void clientCmdChangeFavNum(int id, int favNum)
    {
        logMsg("CLIENT CHANGED FavNum : [ID:"+id+"] [Login:"+users.get(id).login+"] [FavNum:"+favNum+"]");
        users.get(id-1).favNum = favNum;
        rewriteDatabase();
        updateDatabase();
    }

    public static void clientCmdChangePassword(int id, String password)
    {
        logMsg("CLIENT CHANGED Password : [ID:"+id+"] [Login:"+users.get(id).login+"] [Password:"+password+"]");
        users.get(id-1).password = password;
        rewriteDatabase();
        updateDatabase();
    }
}