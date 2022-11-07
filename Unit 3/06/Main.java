import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a letter:");
        char l = cin.nextLine().charAt(0);
        while (!Character.isLetter(l)) {
            System.out.println("Not a letter. Enter a letter:");
            l = cin.nextLine().charAt(0);
        }
        System.out.println("Done.");
        cin.close();
    }
}