import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a sentinel value:");
        int s = cin.nextInt();
        int a = Integer.MAX_VALUE;
        while (a != s) {
            System.out.println("Enter an integer:");
            a = cin.nextInt();
        }
        cin.close();
        System.out.println("Stop");
    }
}