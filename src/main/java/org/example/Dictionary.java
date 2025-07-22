package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words;
    private final Random random = new Random();

    public Dictionary(String filePath) throws IOException{
        words = Files.readAllLines(Path.of(filePath));
    }

    public String random(){
        if(words.isEmpty()){
            throw new IllegalArgumentException("Словарь пустой!");
        }
        return words.get(random.nextInt(words.size()));
    }
}
