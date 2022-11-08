import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println(replace(c.nextLine().charAt(0), c.nextLine().charAt(0), c.nextLine()));
        c.close();
    }
    public static String replace(char a, char b, String s) {
        boolean change = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                if (change) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, b);
                    s = String.valueOf(sb);
                    change = false;
                } else {
                    change = true;
                }
            } 
        }
        return s;
    }
}