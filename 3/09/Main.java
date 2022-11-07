import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter integer 1:");
        int n1 = cin.nextInt();
        System.out.println("Enter integer 2:");
        int n2 = cin.nextInt();
        System.out.println("Print asterisks: ");
        for (int i = 0; i < Math.abs(n1 - n2); i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.println("Countdown seconds:");
        if (n1 > n2) {
            for (int i = n1; i >= n2; i--) {
                System.out.println(i+" seconds");
            }
        } else {
            for (int i = n2; i >= n1; i--) {
                System.out.println(i+" seconds");
            }
        }
        cin.nextLine();

        System.out.println("Enter a letter: ");
        char a = cin.nextLine().charAt(0);
        System.out.println("Enter a letter:");
        char b = cin.nextLine().charAt(0);

        for (int i = (int)a; i <= (int)b; i++) {
            System.out.println("Give me a " + (char)i);
        }
        System.out.println("Output multiples - start at integer 1 and multiply by integer 2 stop when greater than 1000");
        for (int i = n1; i < 1000; i *= n2) {
            System.out.println(i);
        }
        cin.close();
    }
}