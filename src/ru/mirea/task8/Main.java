package ru.mirea.task8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args)
    {
        // 1. Создать окно, нарисовать в нем 20 случайных фигур, случайного
        //цвета. Классы фигур должны наследоваться от абстрактного класса
        //Shape, в котором описаны свойства фигуры: цвет, позиция.
        Task1();

        // 2. Создать окно, отобразить в нем картинку, путь к которой указан в
        //аргументах командной строки.
        //Task2(args);

        // 3. Создать окно, реализовать анимацию, с помощью картинки,
        //состоящей из нескольких кадров.
        //Task3();
    }

    public static void Task1()
    {
        JFrame frame= new JFrame("Лабораторная Работа № 5 - Задание № 1");
        frame.setResizable(false);
        frame.getContentPane().setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel() {
            Shape[] shapes = new Shape[20];

            {
                this.setBackground(Color.black);
                for(int i=0; i<20; i++)
                {
                    Point pos; Color color; Dimension size = new Dimension(); int radius;
                    size.width = 100; size.height = 50; radius = 50;
                    color = new Color((int)(Math.random() * 256),
                            (int)(Math.random() * 256),
                            (int)(Math.random() * 256));
                    switch((int)(Math.random() * 2))
                    {
                        case 0:
                            pos = new Point((int)(Math.random() * (frame.getContentPane().getWidth()-size.width)),
                                    (int)(Math.random() * (frame.getContentPane().getHeight()-size.height)));
                            shapes[i] = new Rectangle(pos, color, size);
                            break;
                        case 1:
                            pos = new Point((int)(Math.random() * (frame.getContentPane().getWidth()-radius*2)),
                                    (int)(Math.random() * (frame.getContentPane().getHeight()-radius*2)));
                            shapes[i] = new Circle(pos, color, radius);
                            break;
                    }

                }
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for(int i=0; i<20; i++)
                {
                    shapes[i].addToGraphics(g);
                }
            }
        };
        frame.add(jPanel);

        frame.setVisible(true);
    }

    public static void Task2(String[] args)
    {
        String fileName = args[0];
        JFrame frame= new JFrame("Лабораторная Работа № 5 - Задание № 2 - \"" + fileName + "\"");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel() {
            BufferedImage image;

            {
                try {
                    image = ImageIO.read(new File(fileName));
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame,"Can't open file : " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                frame.getContentPane().setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
                frame.pack();
                frame.setLocationRelativeTo(null);
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        frame.add(jPanel);

        frame.setVisible(true);
    }

    public static void Task3()
    {
        JFrame frame= new JFrame("Лабораторная Работа № 5 - Задание № 3");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel() {
            BufferedImage[] images;
            String[] fileNames;
            int curImg = -1;
            {
                fileNames = new String[]{
                        "D:/1.bmp",
                        "D:/2.bmp" };
                images = new BufferedImage[fileNames.length];

                try {
                    for(int i=0; i<fileNames.length; i++)
                        images[i] = ImageIO.read(new File(fileNames[i]));
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame,"Can't open file(s)", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                curImg = 0;
                frame.getContentPane().setPreferredSize(new Dimension(images[curImg].getWidth(), images[curImg].getHeight()));
                frame.pack();
                frame.setLocationRelativeTo(null);

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(++curImg >= fileNames.length)
                            curImg = 0;
                        //frame.setTitle("Лабораторная Работа № 5 - Задание № 2 - \"" + fileNames[curImg] + "\"");
                        repaint();
                    }
                });
                timer.start();
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(images[curImg], 0, 0, null);
                frame.setTitle("Лабораторная Работа № 5 - Задание № 3 - \"" + fileNames[curImg] + "\"");
            }
        };
        frame.add(jPanel);

        frame.setVisible(true);
    }
}