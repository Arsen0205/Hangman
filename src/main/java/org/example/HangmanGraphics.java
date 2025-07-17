package org.example;

public class HangmanGraphics {
    public static void draw(int errors) {
        String[] states = {
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

        System.out.println(states[errors]);
    }
}
