import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Temp in F:");
        int F = Integer.parseInt(input.nextLine());
        System.out.println("Temp in C:\n" + Math.round((F - 32) * 50/9.0)/10.0);
        input.close();
    }
}