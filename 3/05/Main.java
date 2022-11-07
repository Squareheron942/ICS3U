import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Continue (y or n):");
        String n = cin.nextLine();
        while (!(n.equals("y") || n.equals("n"))) {
            System.out.println("Continue (y or n):");
            n = cin.nextLine();
        }
        cin.close();
        System.out.println("done");
    }
}