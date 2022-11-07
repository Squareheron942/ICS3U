import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int bearing = cin.nextInt();
        if (bearing >= 360 || bearing < 0) {
            System.out.println("Invalid");
            cin.close();
            return;
        }
        int dir = (int) Math.floor(bearing / 90.0);
        int deg = bearing - 90 * dir;
        String total = (dir == 0 ? deg == 0 ? "N" : deg == 45 ? "NE" : deg < 45 ? "N" + deg + "E" : "E" + (90 - deg) + "N" : dir == 1 ? deg == 0 ? "E" : deg == 45 ? "SE" : deg < 45 ? "E" + deg + "S" : "S" + (90 - deg) + "E" : dir == 2 ? deg == 0 ? "S" : deg == 45 ? "SW" : deg < 45 ? "W" + deg + "S" : "S" + (90 - deg) + "W" : dir == 3 ? deg == 0 ? "W" : deg == 45 ? "NW" : deg < 45 ? "W" + deg + "N" : "N" + (90 - deg) + "W" : "N");
        System.out.println("Bearing " + bearing + " is " + total);
        cin.close();
    }
}