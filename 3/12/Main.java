import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.close();

        for (int i = 1; i <= n; i++) {
            System.out.println(n + " x " + i + " = " + n*i);
        }
    }
}