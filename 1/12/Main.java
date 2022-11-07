import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number:");
        float decimalIn = Float.parseFloat(input.nextLine());
        System.out.println("Number of decimal places: ");
        int numPLaces = Integer.parseInt(input.nextLine());
        System.out.println(Math.round(decimalIn * Math.pow(10, numPLaces)) / Math.pow(10, numPLaces));
        input.close();
    }
}