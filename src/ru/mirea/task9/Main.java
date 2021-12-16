package ru.mirea.task9;

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
        // 1.Напишите интерактивную программу с использованием GUI, которая имитирует
        //таблицу результатов матчей между командами Милан и Мадрид
        Task1();
    }

    public static void Task1()
    {
        new frmMain();
    }
}

class frmMain extends JFrame
{
    // Cчета команд
    int scoreMadrid, scoreMilan;

    // Компоненты GUI
    JLabel lblWinner, lblResult, lblLastScorer;
    JButton btnMilan, btnMadrid;

    frmMain()
    {
        // Главная форма
        super("Таблица результатов матчей между командами Милан и Мадрид");
        setResizable(true);
        getContentPane().setPreferredSize(new Dimension(540, 400));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Содержание формы
        Font font = new Font("Times new roman", Font.BOLD, 40);
        JPanel pnlAddScore = new JPanel();
        this.setLayout(new GridLayout(4,1));
        // Надпись Winner
        lblWinner = new JLabel("Winner : DRAW") {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
                setFont(font);
            }
        };
        this.add(lblWinner);
        // Надпись Result
        lblResult = new JLabel("Result : 0 X 0") {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
                setFont(font);
            }
        };
        this.add(lblResult);
        // Надпись Last Scorer
        lblLastScorer = new JLabel("Last Scorer : N/A") {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
                setFont(font);
            }
        };
        this.add(lblLastScorer);
        // Панель Add Score, содержащая кнопки AC Milan и Real Madrid
        pnlAddScore = new JPanel();
        pnlAddScore.setBackground(Color.pink);
        pnlAddScore.setLayout(new GridLayout(1, 2));
        // Кнопка AC Milan
        btnMilan = new JButton("AC Milan") {
            {
                setFont(font);

                // Обработка нажатия
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        scoreMilan++;
                        updateScores(1);
                    }
                });
            }
        };
        // Кнопка Real Madrid
        btnMadrid = new JButton("Real Madrid"){
            {
                setFont(font);

                // Обработка нажатия
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae)
                    {
                        scoreMadrid++;
                        updateScores(2);
                    }
                });
            }
        };
        pnlAddScore.add(btnMilan);
        pnlAddScore.add(btnMadrid);
        this.add(pnlAddScore);

        this.setVisible(true);
    }

    // Метод обновления счетов команд
    public void updateScores(int lastScorer)
    {
        lblResult.setText("Result : " + Integer.toString(scoreMilan) + " X " + Integer.toString(scoreMadrid));

        if(lastScorer == 1)
            lblLastScorer.setText("Last Scorer : AC Milan");
        else
            lblLastScorer.setText("Last Scorer : Real Madrid");

        if(scoreMilan>scoreMadrid)
            lblWinner.setText("Winner : AC Milan");
        else if(scoreMilan<scoreMadrid)
            lblWinner.setText("Winner : Real Madrid");
        else
            lblWinner.setText("Winner : DRAW");
    }
}