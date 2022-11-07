import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your mass:");
        double myMass = Double.parseDouble(input.nextLine());
        System.out.println("Your mass is "+myMass+" kg.");
        input.close();
    }
}
    