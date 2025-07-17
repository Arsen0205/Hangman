package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствую!");
        System.out.println("1. Новая игра");
        System.out.println("2. Выйти из игры");
        System.out.print("Выберите действие:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 1: //Логика игры
                break;
            case 2:
                System.out.println("Выход из игры");
                break;
        }
    }
}