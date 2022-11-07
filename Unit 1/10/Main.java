import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Square Root\nInput a positive number:");
        int sqrtIn = Integer.parseInt(input.nextLine());
        System.out.println("The square root of " + sqrtIn + " is " + Math.sqrt(sqrtIn));
        System.out.println("\n****\n\nExponents\nInput an integer:");
        int base = Integer.parseInt(input.nextLine());
        System.out.println("Input a second integer:");
        int exp = Integer.parseInt(input.nextLine());
        System.out.println(base + " to the power of " + exp + " is: " + Math.pow(base, exp) + "\n\n****\n\nRounding, Ceiling and Floor\nInput a decimal value:");
        double decimal = Double.parseDouble(input.nextLine());
        System.out.println(decimal + " rounds to " + Math.round(decimal) + "\n" + decimal + " ceiling is " + Math.ceil(decimal) + "  \n" + decimal + " floor is " + Math.floor(decimal) + "\n\n****\n\nRandom\nEnter the lower limit:");
        int lower = Integer.parseInt(input.nextLine());
        System.out.println("Enter the upper limit:");
        int upper = Integer.parseInt(input.nextLine());
        System.out.println("A random number between " + lower + " and " + upper + " is " + Math.floor((upper - lower) * Math.random() + lower));
        input.close();
    }
}