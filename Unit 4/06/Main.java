import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char c = cin.nextLine().charAt(0);
        int x = cin.nextInt();
        int y = cin.nextInt();
        printRectHollow(c, x, y);
        cin.close();
    }
    public static void printRectHollow(char c, int x, int y) {
        if (x > 0)
        {if (y > 0) {for (int j = 0; j < x; j++) {
            System.out.print(c);
        }}
        System.out.println();

        if (y > 2) {for (int i = 0; i < (y - 2); i++) {
            for (int j = 0; j < x; j++) {
                if (j == 0 || ((j + 1) == x)) {
                    System.out.print(c);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }}

        if (y > 1) {for (int j = 0; j < x; j++) {
            System.out.print(c);
        }}}
    }
}
