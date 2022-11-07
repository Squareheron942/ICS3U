import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter first num:");
    int num1 = cin.nextInt();
    cin.nextLine();
    System.out.println("Enter second num:");
    int num2 = cin.nextInt();
    cin.nextLine();
    System.out.println("What is " + num1 + " mod " + num2 + "?");
    int ans = cin.nextInt();
    if (ans == num1 % num2) {
        System.out.println("Congrats - correct.");
    } else {
        System.out.println("Incorrect.\nModulus returns the remainder. \n" + num2 + " divides into " + num1 + ", " + Math.round(Math.floor(num1 / num2)) + " times and there is " + num1 % num2 + " leftover.\n" + num1 + " mod " + num2 + " is " + num1 % num2 + ".");
    }
    cin.close();
  }
}