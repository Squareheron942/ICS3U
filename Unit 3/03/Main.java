import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a positive number (or negative number to quit):");
        double n = cin.nextDouble();
        while (n >= 0) {
            System.out.println("Square root is: " + Math.round(1000 * Math.sqrt(n))/1000.0);
            System.out.println("Enter a positive number (or negative number to quit):");
            n = cin.nextDouble();
        }
        cin.close();
    }
}