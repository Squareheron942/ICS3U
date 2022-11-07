import java.util.*;

public class Main {
    public static void main(String[] args) {
        //define variables
        Scanner userInput = new Scanner(System.in);
        int guess;

        // System.out.println("This can result in an infinite loop - Fix it!");

        System.out.println("\nEnter your guess between 1 and 10:");
        guess = userInput.nextInt();

        while (guess < 1 || guess > 10) {
            System.out.println("Invalid guess");
            guess = userInput.nextInt();
        }

        userInput.close();
        System.out.println("Valid guess entered");
    }
}