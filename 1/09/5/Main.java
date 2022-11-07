import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius:");
        float radius = Float.parseFloat(input.nextLine());
        System.out.println("A = " + (Math.round((Math.PI * Math.pow(radius, 2) * 10)))/10.0 + " units ^2");
        System.out.println("C = " + (Math.round((Math.PI * radius * 20)))/10.0 + " units");
        input.close();
    }
}