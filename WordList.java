package Kt4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Fetches the word to be guessed from given file

public class WordList {
    
    private List<String> words = new ArrayList<String>();

    public WordList(String fileName) throws IOException{
        try (BufferedReader fileWords = new BufferedReader( new FileReader(fileName))){
            String line = null;
            while ((line = fileWords.readLine()) != null) {
                words.add(line.toLowerCase());
            }
        }
    }

    public List<String> giveWords(){
        return words;
    }


}
