package ru.mirea.task11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1. Реализуйте Игру-Угадайку
        new GuessingGame();

        // 2. Реализация приложения Java c областями
        //new Regions();

        // 3. Реализовать программу, которая с помощью меню,
        //может изменять шрифт и цвет текста, написанного в JTextArea
        //new FontColorChanger();
    }
}

class GuessingGame extends JFrame
{
    int num; int tries;
    JTextField txtNumber = new JTextField(2);
    JButton btnGuess = new JButton("Угадать");
    Font fnt = new Font("Times new roman",Font.BOLD,20);

    GuessingGame()
    {
        super("Игра-Угадайка");

        tries = 0;
        num = (int)(Math.random()*21);

        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        txtNumber.setText("0");
        txtNumber.setFont(fnt);
        txtNumber.setHorizontalAlignment(SwingConstants.CENTER);
        btnGuess.setFont(fnt);
        add(txtNumber);
        add(btnGuess);

        btnGuess.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            int inpNum;
            try {
                inpNum = Integer.parseInt(txtNumber.getText().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ошибка в введеном числе", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tries++;
            if(num > inpNum)
                JOptionPane.showMessageDialog(null, "Число больше", "Попытка № "+Integer.toString(tries), JOptionPane.INFORMATION_MESSAGE);
            else if(num < inpNum)
                JOptionPane.showMessageDialog(null, "Число меньше", "Попытка № "+Integer.toString(tries), JOptionPane.INFORMATION_MESSAGE);
            else {
                JOptionPane.showMessageDialog(null, "Число угадано !!!", "Победа !!!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if(tries >= 3)
            {
                JOptionPane.showMessageDialog(null, "Кончились попытки.\nЗагаданное число - " + Integer.toString(num), "Проигрыш", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        });

        setVisible(true);
    }
}

class Regions extends JFrame
{
    HashMap<Integer, String> regionsMap = new HashMap<>();

    Font fnt = new Font("Times new roman",Font.BOLD,20);

    Region regions[] = new Region[5];

    Regions()
    {
        super("Области");

        regionsMap.put(0, BorderLayout.NORTH);
        regionsMap.put(1, BorderLayout.EAST);
        regionsMap.put(2, BorderLayout.SOUTH);
        regionsMap.put(3, BorderLayout.WEST);
        regionsMap.put(4, BorderLayout.CENTER);

        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        for(int i=0; i<regions.length; i++) {
            regions[i] = new Region(regionsMap.get(i));
            add(regions[i], regionsMap.get(i));
        }

        setVisible(true);
    }

    class Region extends JLabel{
        int key;

        Region(String name)
        {
            super(name);

            key = (Integer)getKeyFromValue(regionsMap, name);

            setFont(fnt);
            setHorizontalAlignment(SwingConstants.CENTER);
            setBackground(new Color((int)(Math.random()*156+100), (int)(Math.random()*156+100), (int)(Math.random()*156+100)));
            setOpaque(true);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать в " + regionsMap.get(key) , "Вход в область", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}

class FontColorChanger extends JFrame
{
    HashMap<String, String> fontsMap = new HashMap<>();
    HashMap<String, Color> colorsMap = new HashMap<>();

    JTextArea txtText = new JTextArea("Some Text");
    int fontSize = 24;
    Font startFont = new Font("Times new roman",Font.BOLD, fontSize);

    FontColorChanger()
    {
        super("Изменение шрифта и цвета");

        setSize(600,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        txtText.setFont(startFont);
        txtText.setBackground(Color.blue);
        txtText.setForeground(Color.white);
        add(txtText);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new fontMenu());
        menuBar.add(new colorMenu());

        setJMenuBar(menuBar);
        setVisible(true);
    }

    class fontMenu extends JMenu
    {
        fontMenu()
        {
            super("Шрифт");

            JRadioButtonMenuItem font1MenuItem = new JRadioButtonMenuItem("Times New Roman", true);
            JRadioButtonMenuItem font2MenuItem = new JRadioButtonMenuItem("MS Sans Serif");
            JRadioButtonMenuItem font3MenuItem = new JRadioButtonMenuItem("Courier New");
            ButtonGroup bg = new ButtonGroup();
            bg.add(font1MenuItem);
            bg.add(font2MenuItem);
            bg.add(font3MenuItem);
            add(font1MenuItem);
            add(font2MenuItem);
            add(font3MenuItem);

            font1MenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
                }
            });
            font2MenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setFont(new Font("MS Sans Serif", Font.BOLD, fontSize));
                }
            });
            font3MenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setFont(new Font("Courier New", Font.BOLD, fontSize));
                }
            });
        }
    }

    class colorMenu extends JMenu
    {
        colorMenu()
        {
            super("Цвет");

            JRadioButtonMenuItem blueMenuItem = new JRadioButtonMenuItem("Синий", true);
            JRadioButtonMenuItem redMenuItem = new JRadioButtonMenuItem("Красный");
            JRadioButtonMenuItem blackMenuItem = new JRadioButtonMenuItem("Черный");
            ButtonGroup bg = new ButtonGroup();
            bg.add(blueMenuItem);
            bg.add(redMenuItem);
            bg.add(blackMenuItem);
            add(blueMenuItem);
            add(redMenuItem);
            add(blackMenuItem);

            blueMenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setBackground(Color.blue);
                }
            });
            redMenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setBackground(Color.red);
                }
            });
            blackMenuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    txtText.setBackground(Color.black);
                }
            });
        }
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}