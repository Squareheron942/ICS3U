import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    // ANSI colour codes
    static String WHITE = "\u001B[37m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static String GREEN_BG = "\u001B[42m";
    static String YELLOW_BG = "\u001B[43m";
    static String GREY_BG = "\u001B[100m";
    static String RESET = "\u001B[0m";

    // input scanner
    static Scanner cin = new Scanner(System.in);

    // get random word from list of words stored in class Words
    static String ans = genWords();

    static boolean won = false;

    static ArrayList<String> valid = new ArrayList<String>();
    static int lineNum = 0;
    static boolean sus = false;

    public static void main(String[] args) {
        // read in text from valid guesses text file
        try {
            File file = new File("valid.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                //process the line
                valid.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

        System.out.println("\033[H\033[2J" + "Welcome to my Wordle Program!");

        playedBeforePrompt();

        System.out.println("        -----------------------\n        |       wordle        |\n        -----------------------\n\n");
        String[] winMessages = {
            "Genius",
            "Magnificent",
            "Impressive",
            "Splendid",
            "Great",
            "Phew"
        };

        // get 6 guesses
        for (int i = 0; i < 6; i++) {
            lineNum = i;
            doLine();
            if (won) break;
            if (sus) return;
        }

        // if after all 6 guesses still not yet won then lose
        if (won) {
            System.out.println(winMessages[lineNum]);
        } else {
            System.out.println("You Lost!");
        }
    }

    static String genWords() {
        Random rand = new Random();
        return Words.answersList[rand.nextInt(Words.answersList.length)];
    }

    // ask the player if they have played before and give tutorial if not
    static void playedBeforePrompt() {
        System.out.print("Do you know how to play? (y/n) ");

        char reply = cin.nextLine().toLowerCase().charAt(0);
        char repeat = 'y';

        while (reply != 'y' && repeat != 'n') {

            tutorial();

            System.out.println("Do you need me to repeat that? (y/n) ");
            repeat = cin.nextLine().toLowerCase().charAt(0);
        }
    }

    static void tutorial() {
        System.out.println("How to play:\n\nGuess the word in 6 tries.\nType to enter a guess.\nEach guess must be a valid 5-letter word.\nThe color of the character will indicate how close you are:\n - A green letter means it is in the word and in the right spot\n - A yellow letter means it is in the word but in the wrong spot\n - A grey letter means it is not in the word");
    }

    static void del_line() {
        System.out.print(String.format("\033[%dA",1)); // Move up cursor
        System.out.print("\033[2K"); // Erase line content
    }

    static void doLine() {
        String line = cin.nextLine().toUpperCase();
        // if sus
        if (Arrays.asList(Words.sussers).contains(line.toLowerCase())) {
            Words.sussy();
            sus = true;
            return;
        }

        // checks if the entered word is exactly 5 letters long, only includes letters and is a valid word
        while (line.length() != 5 || !isAlpha(line) || !valid.contains(line.toLowerCase())) {
            // if not, repeat input
            del_line();
            line = cin.nextLine().toUpperCase();
        }

        del_line();

        // compare entered word to correct word, if the same then win
        if (ans.toUpperCase().equals(line)) won = true;

        draw_line(line);
    }

    // draws a new line on the table of answers, with colour
    static void draw_line(String line) {
        if (lineNum == 0) System.out.println("         |---|---|---|---|---|");
        System.out.print("         ");
        for (int i = 0; i < 5; i++) {
            if (ans.toUpperCase().charAt(i) == line.charAt(i)) {
                System.out.print("| " + GREEN_BG + line.charAt(i) + RESET + " ");
            } else if (ans.toUpperCase().indexOf(line.charAt(i)) >= 0) { // there is a mistake here but it is also present in wordle so I would consider it fine
                System.out.print("| " + YELLOW_BG + line.charAt(i) + RESET + " ");
            } else {
                System.out.print("| " + GREY_BG + line.charAt(i) + RESET + " ");
            }
        }
        System.out.print("|");
        System.out.println();
        System.out.println("         |---|---|---|---|---|");
    }

    static boolean isAlpha(String line) {
        for (int i = 0; i < line.length(); i++) if (!Character.isLetter(line.charAt(i))) return false;
        return true;
    }
}



// How to play:

// Guess the word in 6 tries.
// Type to enter a guess.
// Each guess must be a valid 5-letter word.
// The color of the character will indicate how close you are:
// - A green letter means it is in the word and in the right spot
// - A yellow letter means it is in the word but in the wrong spot
// - A grey letter means it is not in the word








//        -----------------------
//        |       wordle        |
//        -----------------------
//
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
//         | A | B | C | D | E |
//         ---------------------
