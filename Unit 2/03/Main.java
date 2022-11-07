import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int[] numbers = new int[3];
    System.out.println("Enter first number:");
    numbers[0] = cin.nextInt();
    cin.nextLine();
    System.out.println("Enter second number:");
    numbers[1] = cin.nextInt();
    cin.nextLine();
    System.out.println("Enter third number:");
    numbers[2] = cin.nextInt();
    cin.nextLine();
    Arrays.sort(numbers);
    System.out.println("The largest number is: " + numbers[2]);
    cin.close();
  }
}