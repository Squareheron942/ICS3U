


import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
    // ANSI colour codes
    static String WHITE = "\u001B[97m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static String BLUE = "\u001B[34m";
    static String MAGENTA = "\u001B[35m";
    static String CYAN = "\u001B[36m";
    static String LIME = "\u001B[92m";
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
        int points = 0;
        // read in text from valid words text file
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

        // ask if the user has played before
        playedBeforePrompt();

        String[] winMessages = {
            "Genius",
            "Magnificent",
            "Impressive",
            "Splendid",
            "Great",
            "Phew"
        };
        int[] winPoints = {
            97,
            83,
            71,
            59,
            37,
            3,
            -31
        };

        // loop game
        do {
            System.out.println("        -----------------------\n        |       wordle        |\n        -----------------------\n\n");

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
                points += winPoints[lineNum];
                System.out.println("Your points: " + points);
                won = false;
            } else {
                System.out.println("You Lost!");
                points += winPoints[6];
                System.out.println("Your points: " + points);
            }
        } while (!canceled()); // only loop if the user wants to

        System.out.println(
            "\nThanks for playing! Your achieved rank was: " + (
            points < 0 ? "...I have no words (ur so garbage)..." :  
            points < 600 ? "Wordle " + GREY_BG + "Tra" + YELLOW_BG + "s" + GREY_BG + "h" + RESET : 
            points < 800 ? MAGENTA + "Wordle Mid" + RESET : 
            points < 1000 ? CYAN + "Wordle Guy" + RESET : 
            GREEN + "W" + YELLOW + "o" + RED + "r" + BLUE + "d" + GREEN + "l" + YELLOW + "e" + RESET + " " + RED + "c" + BLUE + "o" + GREEN + "o" + YELLOW + "l" + RESET + " " + RED + "g" + BLUE + "u" + GREEN + "y") + 
            " with " + points + " pts.\n\nShare this with all your friends to totally wordle them!"
        );
    }

    static boolean canceled() {
        System.out.println("\nDo you wish to play again? (y/n)");
        return cin.nextLine().toLowerCase().charAt(0) != 'y';
    }

    // pick random word out of all of the valid answers (different, smaller list) that is contained in the Words class
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

    // give rules for the game
    static void tutorial() {
        System.out.println(
            "How to play:\n" + 
            "\n" +
            "Guess the word in 6 tries.\n" + 
            "Type to enter a guess.\n" + 
            "Each guess must be a valid 5-letter word.\n" + 
            "The color of the character will indicate how close you are:\n" + 
            " - A " + GREEN_BG + "green" + RESET + " letter means it is in the word and in the right spot\n" + 
            " - A " + YELLOW_BG + "yellow" + RESET + " letter means it is in the word but in the wrong spot\n" + 
            " - A " + GREY_BG + "grey" + RESET + " letter means it is not in the word.\n" + 
            "\n" + 
            "\n" + 
            "Wordle Ranking System:\n" + 
            "    - In this version, you get points every game you play\n" + 
            "    - Get more points to achieve the ultimate rank of " + GREEN + "W" + YELLOW + "o" + RED + "r" + BLUE + "d" + GREEN + "l" + YELLOW + "e" + RESET + " " + RED + "c" + BLUE + "o" + GREEN + "o" + YELLOW + "l" + RESET + " " + RED + "g" + BLUE + "u" + GREEN + "y" + RESET + "\n" +
            "\n" + 
            "Ranks:\n" + 
            GREEN + "W" + YELLOW + "o" + RED + "r" + BLUE + "d" + GREEN + "l" + YELLOW + "e" + RESET + "  " + RED + "c" + BLUE + "o" + GREEN + "o" + YELLOW + "l" + RESET + "  " + RED + "g" + BLUE + "u" + GREEN + "y" + RESET + " : 1000 pts\n" + 
            CYAN + "Wordle Guy" + RESET + " : 800 pts\n" + 
            MAGENTA + "Wordle Mid" + RESET + " : 600 pts\n" + 
            "Wordle " + GREY_BG + "Tra" + YELLOW_BG + "s" + GREY_BG + "h" + RESET + " : 0 pts\n" + 
            RED + "???????" + RESET + " : ?????? pts\n" +
            "\n" + 
            "Points:\n" + 
            "1 guess: " + GREEN + "+97 pts" + RESET + "\n" + 
            "2 guesses: " + LIME + "+83 pts" + RESET + "\n" + 
            "3 guesses: " + LIME + "+71 pts" + RESET + "\n" + 
            "4 guesses: " + YELLOW + "+59 pts" + RESET + "\n" + 
            "5 guesses: +37 pts\n" + 
            "6 guesses: +3 pts\n" + 
            "fail: " + RED + "-31 pts" + RESET + "\n" 
        );
    }

    // removes the previous inputted line to make the formatting nicer
    static void del_line() {
        System.out.print(String.format("\033[%dA",1)); // Move up cursor
        System.out.print("\033[2K"); // Erase line content
    }

    // everything that happens every time a player inputs a word
    static void doLine() {
        String line = cin.nextLine().toUpperCase(); // get input
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

        // remove the inputted word from view
        del_line();

        // compare entered word to correct word, if the same then win
        if (ans.toUpperCase().equals(line)) won = true;

        draw_line(line); // display the result of the input
    }

    // draws a new line on the table of answers, with colour
    static void draw_line(String line) {
        if (lineNum == 0) System.out.println("         |---|---|---|---|---|");
        System.out.print("         ");
        // iterate through each character of the word, and determine whether
        for (int i = 0; i < 5; i++) {
            if (ans.toUpperCase().charAt(i) == line.charAt(i)) {
                System.out.print("| " + GREEN_BG + line.charAt(i) + RESET + " ");
            } else if (ans.toUpperCase().indexOf(line.charAt(i)) >= 0) { 
                // there is a mistake here but it is also present in wordle so I would consider it fine, 
                // basically what should happen is that there are only yellow characters if there is another letter in the word
                // for example with "feels" if someone guessed 'e' at the second spot, 3rd spot and 5th spot, the first two 'e' would be green 
                // and the last one grey, because they guessed 3 'e' but there are only 2. What actually happens is that the third one will
                // be yellow
                System.out.print("| " + YELLOW_BG + line.charAt(i) + RESET + " ");
            } else {
                System.out.print("| " + GREY_BG + line.charAt(i) + RESET + " ");
            }
        }
        System.out.print("|");
        System.out.println();
        System.out.println("         |---|---|---|---|---|");
    }

    // returns whether all of the characters in a word are letters
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
// - A /*green*/ letter means it is in the word and in the right spot
// - A /*yellow*/ letter means it is in the word but in the wrong spot
// - A grey letter means it is not in the word


// 





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
