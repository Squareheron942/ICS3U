import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char c = cin.nextLine().charAt(0);
        int x = cin.nextInt();
        int y = cin.nextInt();
        printRect(c, x, y);
        cin.close();
    }
    public static void printRect(char c, int x, int y) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
