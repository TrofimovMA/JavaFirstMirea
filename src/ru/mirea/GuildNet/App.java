package ru.mirea.GuildNet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Stack;

public class App
{
    static frmServer server;

    public static void main(String[] args)
    {
        // Запуск сервера
        server = new frmServer();
    }

    public enum FamilyStatus {
        NONE,
        NotMarried,
        Engaged,
        Married
    }

    
}
