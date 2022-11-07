import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String[] s = cin.nextLine().split("\\s+");
        cin.close();

        int[] sample = new int[10];

        for (int i = 0; i < s.length; i++) {
            sample[i] = Integer.parseInt(s[i]);
        }


    }
}