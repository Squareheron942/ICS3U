import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String in = cin.nextLine();
        int y = Integer.parseInt(in.split(" ")[0]);
        int x = Integer.parseInt(in.split(" ")[1]);
        int[][] n = new int[y][x];

        for (int i = 0; i < y; i++) {
            n[i] = Arrays.stream(cin.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        cin.close();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(n[y-1-j][x-1-i]);
            }
            System.out.println();
        }
    }
}