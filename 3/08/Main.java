import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter Password:");
        String n = cin.nextLine();
        while (!n.equals("coded")) {
            System.out.println("Enter Password:");
            n = cin.nextLine();
        }

        cin.close();
        System.out.println("Access Granted!");
    }
}