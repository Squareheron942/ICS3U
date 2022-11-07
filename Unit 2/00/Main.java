import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter first number:");
    int num1 = cin.nextInt();
    cin.nextLine();
    System.out.println("Enter second number:");
    int num2 = cin.nextInt();
    cin.nextLine();
    if (num1 > num2) {
        System.out.println("Result: " + num1 + " is larger than " + num2);
    } else if (num1 < num2) {
        System.out.println("Result: " + num2 + " is larger than " + num1);
    } else {
        System.out.println("Result: The numbers are equal");
    }
    cin.close();
  }
}