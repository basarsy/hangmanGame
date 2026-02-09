import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        // Java Hangman Game

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String filePath = "src\\words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                words.add(line.trim());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("Couldn't locate the words on file path.");
        }
        catch (IOException e){
            System.out.println("Couldn't read the file.");
        }
        catch (Exception e){
            System.out.println("Something went wrong.");
        }

        String word = words.get(random.nextInt(words.size()));

        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuessAmount = 0;
        for (int i = 0; i < word.length(); i++){
            wordState.add('_');
        }

        System.out.println("*********************************");
        System.out.println("Welcome to the Java Hangman Game!");
        System.out.println("*********************************");

        while (wrongGuessAmount < 6){

            System.out.println(getHangmanArt(wrongGuessAmount));

            System.out.print("Word: ");
            for (char c : wordState){
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            if (word.indexOf(guess) >= 0){
                System.out.println("Correct guess!\n");
                for (int i = 0; i < word.length(); i++){
                    if (word.charAt(i) == guess){
                        wordState.set(i, guess);
                    }
                }
                if (!wordState.contains('_')){
                    System.out.println(getHangmanArt(wrongGuessAmount));
                    System.out.println("You win!");
                    System.out.println("The word was: " + word);
                    break;
                }
            }
            else {
                wrongGuessAmount++;
                System.out.println("Wrong guess!\n");
            }
        }

        if (wrongGuessAmount >= 6){
            System.out.print(getHangmanArt(wrongGuessAmount));
            System.out.println("You lose!");
            System.out.println("The word was: " + word);
        }
        scanner.close();
    }
    static String getHangmanArt(int wrongGuessAmount){
        return switch (wrongGuessAmount){
            case 0 ->   """
                        
                        
                        
                        """;
            case 1 ->   """
                         o
                         
                         
                        """;
            case 2 ->   """
                         o
                         |
                         
                        """;
            case 3 ->   """
                         o
                        /|
                        
                        """;
            case 4 ->   """
                         o
                        /|\\
                        
                        """;
            case 5 ->   """
                         o
                        /|\\
                        /                
                        """;
            case 6 ->   """
                         o
                        /|\\
                        / \\
                        """;
            default -> "";
        };
    }
}
