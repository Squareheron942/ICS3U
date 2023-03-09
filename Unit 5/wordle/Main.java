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
    static String WHITE = "\u001B[37m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static String GREEN_BG = "\u001B[42m";
    static String YELLOW_BG = "\u001B[43m";
    static String GREY_BG = "\u001B[100m";
    static String RESET = "\u001B[0m";
    static Scanner cin = new Scanner(System.in);
    static Random rand = new Random();
    static String ans = Words.answersList[rand.nextInt(Words.answersList.length)];
    static boolean won = false;
    static ArrayList<String> valid = new ArrayList<String>();

    public static void main(String[] args) {

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
            
            return;
        }

        System.out.println("Welcome to my Wordle Program!");

        int lineNum = 0;
        String[] winMessages = {
            "Genius",
            "Magnificent",
            "Impressive",
            "Splendid",
            "Great",
            "Phew"
        };

        for (int i = 0; i < 6; i++) {
            lineNum = i;
            doLine();
            System.out.println();
            if (won) break;
        }

        if (!won) {
            System.out.println("You Lost!");
        } else {
            System.out.println(winMessages[lineNum]);
        }
    }

    static void del_line() {
        System.out.print(String.format("\033[%dA",1)); // Move up
        System.out.print("\033[2K"); // Erase line content
    }

    static void doLine() {
        String line = cin.nextLine().toLowerCase();
        while (line.length() != 5 || !isAlpha(line) || !valid.contains(line)) {
            del_line();
            line = cin.next().toLowerCase();
        }
        del_line();
        if (ans.equals(line)) won = true;
        for (int i = 0; i < 5; i++) {
            if (ans.charAt(i) == line.charAt(i)) {
                System.out.print(GREEN_BG + line.charAt(i) + RESET);
            } else if (ans.indexOf(line.charAt(i)) >= 0) {
                System.out.print(YELLOW_BG + line.charAt(i) + RESET);
            } else {
                System.out.print(GREY_BG + line.charAt(i) + RESET);
            }
        }
    }

    static boolean isAlpha(String line) {
        for (int i = 0; i < line.length(); i++) if (!Character.isLetter(line.charAt(i))) return false;
        return true;
    }
}

// ----------------