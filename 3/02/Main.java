import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = cin.nextInt();
        while (n <= 0) {
            System.out.println("Invalid input.");
            System.out.println("Enter N:");
            n = cin.nextInt();
        }
        int i = 1, s = 0;
        while (i <= n) {
            s += i;
            i++;
        }
        cin.close();
        System.out.println("The sum of the first " + n + " integers is " + s);
    }
}