import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int n = cin.nextInt();
        while (n <= 0) {
            System.out.println("Enter a positive integer:");
            n = cin.nextInt();
        }

        int total = 0;

        for (int i = 0; i < ("" + n).length(); i++) {
            total += 1 * Character.getNumericValue(Integer.toString(n).charAt(i));
        }
        cin.close();
        System.out.println("Sum of " + n + "'s digits is " + total);
    }
}