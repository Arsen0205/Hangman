package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Game {
    private static final int MAX_ERRORS = 6;
    private int errors;
    private final WordRandom wordRandom;
    private final Set<Character> enteredLetters = new TreeSet<>();
    private final Set<Character> guessedLetters = new TreeSet<>();
    private final static char MASK_SYMBOL = '_';
    private String word;

    public Game(String dictionaryFilePath) throws IOException{
        wordRandom = new WordRandom(dictionaryFilePath);
    }


    public void start(){
        System.out.println("== Начало игры ==");

        enteredLetters.clear();
        Scanner scanner = new Scanner(System.in);

        word = wordRandom.random().toLowerCase();

        while (true){
            printTurnInfo();

            System.out.print("Введите букву: ");
            String symbol = scanner.nextLine().toLowerCase();

            if (isInvalidInput (symbol)){
                continue;
            }

            enteredLetters.add(symbol.charAt(0));

            check(symbol);

            if (isWordGuessed()){
                System.out.println("Вы угадали слово: " + word);
                break;
            }else if (errors >= MAX_ERRORS){
                HangmanGraphics.draw(errors);
                System.out.println("Вы не угадали слово: " + word);
                break;
            }
        }

        System.out.println();
        System.out.println("Игра окончена!");
    }

    private void check(String symbol){
        if (word.contains(symbol)){
            System.out.println("====================");
            System.out.println("Вы угадали букву: " + symbol);
            guessedLetters.add(symbol.charAt(0));
        }else {
            System.out.println("====================");
            System.out.println("Вы не угадали букву!");
            errors++;
        }
    }

    private boolean isWordGuessed(){
        for(char c : word.toLowerCase().toCharArray()){
            if (!guessedLetters.contains(c)){
                return false;
            }
        }
        return true;
    }

    private String getMaskedWord(){
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()){
            char symbol = guessedLetters.contains(c) ? c : MASK_SYMBOL;
            sb.append(symbol).append(" ");
        }
        return sb.toString().trim();
    }

    private boolean isInvalidInput (String symbol){
        if (symbol.isEmpty()){
            System.out.println("====================");
            System.out.println("Вы нажали Enter (пустой ввод)!");
            return true;
        } else if (symbol.length() != 1) {
            System.out.println("====================");
            System.out.println("Введите одну букву!");
            return true;
        } else if (!symbol.matches("^[а-яё]$")) {
            System.out.println("====================");
            System.out.println("Пожалуйста, введите русскую букву!");
            return true;
        } else if (enteredLetters.contains(symbol.charAt(0))) {
            System.out.println("====================");
            System.out.println("Вы уже вводили эту букву");
            return true;
        }
        return false;
    }

    private void printTurnInfo(){
        System.out.println("====================");

        System.out.println("Введенные буквы: "  + enteredLetters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println("Угаданные буквы: " + guessedLetters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        HangmanGraphics.draw(errors);
        System.out.println("Слово: " + getMaskedWord());
    }
}
