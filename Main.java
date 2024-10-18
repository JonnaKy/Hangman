package Kt4;

import java.io.IOException;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      WordList list = null;

      try{
         list = new WordList("words.txt");
      }catch (IOException e){
         System.out.println("File not found");
         scanner.close();
         return;
      }

      Hangman game = new Hangman(list, 10);
      
      String word = game.word();

      StringBuffer hiddenWord = new StringBuffer();
      int wordSize = word.length();
      
      for(int i = 0; i < wordSize; i++){
         hiddenWord.append("*");
      }

      
      do{
      System.out.println("The hidden word...\n");
      System.out.println(hiddenWord);

      System.out.println("\nGuesses left: " + game.guessesLeft());
      System.out.println("Guessed letters: " + game.guesses());

      System.out.println("\nGuess a letter: ");
      Character letters = scanner.next().charAt(0);
      letters = Character.toLowerCase(letters);
      
      if (game.guess(letters)) {
         for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == letters){
               hiddenWord.setCharAt(i, letters);
            }
         }
      }

      }while(!game.theEnd()); 

      scanner.close();
      
      String finalWord = hiddenWord.toString().toLowerCase();
       if (word.equals(finalWord)) {
         System.out.println("Congratulations! you won!!");
         System.out.println("The hidden word was: \"" + word + "\"");
      }else if (game.guessesLeft() == 0 && (!word.equals(finalWord))) {
         System.out.println("Sorry, you lost!");
         System.out.println("The hidden word was: \"" + word + "\"");
      } 
   }
}