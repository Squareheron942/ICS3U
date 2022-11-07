import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        values.put('N', 0);
        values.put('E', 90);
        values.put('S', 180);
        values.put('W', 270);
        Scanner cin = new Scanner(System.in);
        char bearing = Character.toUpperCase(cin.nextLine().charAt(0));
        int deg = cin.nextInt();
        cin.nextLine();
        char bearing2 = Character.toUpperCase(cin.nextLine().charAt(0));
        int diffdeg = 0;
        int out = 0;
        if (bearing == 'N') {
            diffdeg = bearing2 == 'N' || bearing2 == 'S' ? -1 : bearing2 == 'W' ? 360 - deg : deg;
        } else if (bearing == 'E') {
            diffdeg = bearing2 == 'E' || bearing2 == 'W' ? -1 : bearing2 == 'N' ? -deg : deg;
        } else if (bearing == 'S') {
            diffdeg = bearing2 == 'S' || bearing2 == 'N' ? -1 : bearing2 == 'E' ? -deg : deg;
        } else if (bearing == 'W') {
            diffdeg = bearing2 == 'W' || bearing2 == 'E' ? -1 : bearing2 == 'S' ? -deg : deg;
        }
        if (deg > 45 || values.get(bearing) == null || diffdeg == -1) {
            System.out.println("Invalid");
            cin.close();
            return;
        }
        if (diffdeg == 0) {
            out = (int) values.get(bearing);
        } else {
            out = (int) values.get(bearing) + diffdeg;
        }
        System.out.println("Compass " + bearing + deg + bearing2 + " is a bearing of " + out);
        cin.close();
    }
}