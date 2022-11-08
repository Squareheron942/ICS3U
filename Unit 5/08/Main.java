import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println(count(cin.nextLine().charAt(0), cin.nextLine()));
        cin.close();
    }
    public static int count(char c, String s) {
        c = String.valueOf(c).toLowerCase().charAt(0);
        return s.length() - s.toLowerCase().replaceAll(String.valueOf(c), "").length();
    }

}