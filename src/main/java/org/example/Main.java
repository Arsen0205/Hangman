package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствую!");

        while (true) {
            System.out.println("1. Новая игра");
            System.out.println("2. Выйти из игры");
            System.out.print("Выберите действие: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Game game = new Game();
                        game.start();
                        break;
                    case 2:
                        System.out.println("Выход из игры");
                        return;
                    default:
                        System.out.println("Пожалуйста, выберите 1 или 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: нужно ввести число 1 или 2.");
                scanner.nextLine();
            }

            System.out.println();
        }
    }
}
