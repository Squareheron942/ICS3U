import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashMap<Character, Integer> v = new HashMap<Character, Integer>();
        v.put('A', 0);
        v.put('B', 0);

        int n = cin.nextInt();
        cin.nextLine();

        String in = cin.nextLine();

        cin.close();

        for (int i = 0; i < n; i++) {
            v.put(in.charAt(i), v.get(in.charAt(i))+1);
        }

        if (v.get('A') > v.get('B')) {
            System.out.println('A');
        } else if (v.get('B') > v.get('A')) {
            System.out.println('B');
        } else {
            System.out.println("Tie");
        }

    }
}