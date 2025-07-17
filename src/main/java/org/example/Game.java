package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private static final int MAX_ERRORS = 6;
    private int errors;
    private final WordRandom wordRandom = new WordRandom();
    private Set<Character> guessedLetters = new HashSet<>();
    private String word;


    public void start(){
        System.out.println("== Начало игры ==");

        guessedLetters.clear();
        Scanner scanner = new Scanner(System.in);

        word = wordRandom.random();
        System.out.println(getMaskedWord());

        while (true){
            System.out.println();
            HangmanGraphics.draw(errors);
            System.out.println("Слово: " + getMaskedWord());
            System.out.print("Введите букву: ");
            String letter = scanner.nextLine().toLowerCase();

            if (guessedLetters.contains(letter.charAt(0))){
                System.out.println("Вы уже вводили эту букву");
                continue;
            }

            guessedLetters.add(letter.charAt(0));

            if (word.contains(String.valueOf(letter.charAt(0)))){
                System.out.println("Вы угадали букву: " + letter.charAt(0));
            }else {
                System.out.println("Вы не угадали букву!");
                errors++;
            }

            if (isWordGuessed()){
                System.out.println("Вы угадали слово: " + word);
                break;
            }

            if (errors >= MAX_ERRORS){
                System.out.println("Вы не угадали слово: " + word);
                break;
            }
        }

        System.out.println();
        System.out.println("Игра окончена!");
    }

    private boolean isWordGuessed(){
        for(char c : word.toCharArray()){
            if (!guessedLetters.contains(c)){
                return false;
            }
        }
        return true;
    }

    private String getMaskedWord(){
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()){
            sb.append(guessedLetters.contains(c) ? c : "_").append(" ");
        }
        return sb.toString().trim();
    }

}
