package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static int START = 1;
    private final static int QUIT = 2;
    private final static String FAIL_MESSAGE = String.format("Ошибка: нужно ввести число %d или %d! \n", START, QUIT);
    private final static String START_MESSAGE = String.format("Пожалуйста, выберите %d или %d!\n", START, QUIT);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствую!");

        while (true) {
            System.out.println(START + ". Новая игра");
            System.out.println(QUIT + ". Выйти из игры");
            System.out.printf(START_MESSAGE);

            String s = scanner.nextLine();
            if (!isInteger(s)){
                System.out.println(FAIL_MESSAGE);
                continue;
            }

            int choice = Integer.parseInt(s);

            switch (choice){
                case START -> {
                    Game game = new Game();
                    game.start();
                }
                case QUIT -> {
                    System.out.println("Выход из игры");
                    return;
                }
                default -> System.out.println(FAIL_MESSAGE);
            }
        }
    }

    private static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
