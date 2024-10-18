package Kt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Handles the letter guessed and keeps track of the game

public class Hangman {
    
    private int guesses = 0;
    private String word = null;
    private List<Character> guessedLetters = new ArrayList<Character>();

    public Hangman(WordList wordListObject, int tries){
        if (tries > 0) {
            guesses = tries; 
        }
        List<String> wordListString = new ArrayList<>();
        wordListString = wordListObject.giveWords();
        
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(wordListString.size());
        
        word = wordListString.get(index);
    }

    public boolean guess(Character c){//adds the guessed letter to the list of guessed letters
        int counter = 0;
        boolean checker = false;
        c = Character.toLowerCase(c);
        for (Character letter : guessedLetters){
            if (c == letter) {
                counter += 1;
            }
        }
        if (counter == 0) {
            guessedLetters.add(c);
        }
        if (word.indexOf(c) >= 0) {//if the letter is in the word, returns true.
            checker = true;
        }else if (guesses > 0 || (guesses > 0 && counter > 0)) { //lessens the amount of guesses left
            guesses --;
            checker = false;
        }
        return checker;
    }

    public List<Character> guesses(){
        return guessedLetters;
    }

    public int guessesLeft(){
        return guesses;
    }
    
    public String word(){
        return word;
    }

    private boolean checkWords(){
        int letterAmount = 0;
        for (int i = 0; i < word.length(); i++){
            char oneLetter = word.charAt(i);
            for (Character letter : guessedLetters){
                if (oneLetter == letter) {
                    letterAmount += 1;
                }
            }
        }
        if (letterAmount == word.length()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean theEnd(){
        if (guesses == 0 || checkWords()) {
            return true;
        }else{
            return false;
        }
    }
}
