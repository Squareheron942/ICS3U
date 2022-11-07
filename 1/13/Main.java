import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("numerator=");
        int numerator = Integer.parseInt(input.nextLine());
        System.out.println("denominator=");
        int denominator = Integer.parseInt(input.nextLine());
        System.out.println(numerator + " / " + denominator + " is equivalent to " + numerator / denominator + " and " + numerator % denominator + " / " + denominator);
        input.close();
    }
}