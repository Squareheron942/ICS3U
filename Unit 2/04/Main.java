import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter age:");
    int age = cin.nextInt();
    if (age < 12) {
        System.out.println("You are a child");
    } else if (age <= 19) {
        System.out.println("You are a teen");
    } else if (age <= 65) {
        System.out.println("You are an adult");
    } else {
        System.out.println("You are a senior citizen");
    }
    cin.close();
  }
}