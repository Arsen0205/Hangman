package org.example;

public class HangmanGraphics {
   private static final String[] STATES = {
                """
              +---+
                  |
                  |
                  |
                 ===""",
                """
              +---+
              O   |
                  |
                  |
                 ===""",
                """
              +---+
              O   |
              |   |
                  |
                 ===""",
                """
              +---+
              O   |
             /|   |
                  |
                 ===""",
                """
              +---+
              O   |
             /|\\  |
                  |
                 ===""",
                """
              +---+
              O   |
             /|\\  |
             /    |
                 ===""",
                """
              +---+
              O   |
             /|\\  |
             / \\  |
                 ==="""
        };

    public static void draw(int errors){
        System.out.println(STATES[errors]);
    }
}
