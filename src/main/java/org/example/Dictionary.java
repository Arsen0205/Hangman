package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private final String[] words = {
            "аэропорт", "телевизор", "компьютер", "мышка"
    };

    public String random(){
        int index = ThreadLocalRandom.current().nextInt(words.length);
        return words[index];
    }
}
