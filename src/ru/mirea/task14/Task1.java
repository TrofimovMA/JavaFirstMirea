package ru.mirea.task14;

import java.util.Scanner;
import java.util.Stack;

public class Task1
{
    Task1()
    {
        Stack<Integer> player1 = new Stack<Integer>(); // карты 1-го игрока
        Stack<Integer> player2 = new Stack<Integer>(); // карты 2-го игрока
        int gCount = 0; // количество ходов
        int gWinner = -1; // исход игры
        int card1, card2; // открытые карты игроков

        // Ввод карт игроков
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 5 карт 1-го игрока: ");
        for(int i=0; i<5; i++)
            player1.add(0, sc.nextInt());
        System.out.println("Введите 5 карт 2-го игрока: ");
        for(int i=0; i<5; i++)
            player2.add(0, sc.nextInt());

        // начало и продолжение игры
        while(gWinner < 0)
        {
            gCount++;

            // открытие карт
            card1 = player1.pop();
            card2 = player2.pop();

            if(Main.compareCards(card1, card2) > 0) // старше карта 1-го игрока
            {
                // 1-ый игрок забирает карты
                player1.add(0, card1);
                player1.add(0, card2);
            }else{ // старше карта 2-го игрока
                // 2-ой игрок забирает карты
                player2.add(0, card1);
                player2.add(0, card2);
            }

            // проверка конца игры
            if(player1.size() < 1)
                gWinner = 2;
            else if(player2.size() < 1)
                gWinner = 1;
            else if(gCount == 106)
                gWinner = 0;
        }

        // вывод исхода игры
        System.out.println("Исход игры: ");
        if(gWinner == 2)
            System.out.println("second " + gCount);
        else if(gWinner == 1)
            System.out.println("first " + gCount);
        else
            System.out.println("botva");
    }
}
