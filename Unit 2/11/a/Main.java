import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int bearing = cin.nextInt();
        if (bearing >= 360) {
            System.out.println("Invalid");
            cin.close();
            return;
        }
        int dir = (int) Math.round(bearing / 90.0);
        System.out.println("Bearing " + bearing + " is closest to " + (dir == 0 ? "North" : dir == 1 ? "East" : dir == 2 ? "South" : dir == 3 ? "West" : "North"));
        cin.close();
    }
}