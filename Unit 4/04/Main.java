import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        printRollDice(n);

        s.close();
    }

    //Write your method(s) here

    public static void printRollDice(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Roll " + (i+1) + " is a " + ((int)Math.floor(Math.random() * 6 + 1)));
        }
    }
}