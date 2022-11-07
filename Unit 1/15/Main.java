import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cents:");
        int cents = Integer.parseInt(input.nextLine());
        System.out.println("Quarters " + cents / 25 + ", dimes " + cents % 25 / 10 + ", nickels " + cents % 25 % 10 / 5 + ", pennies " + cents % 25 % 10 % 5);
        input.close();
    }
}