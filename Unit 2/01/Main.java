import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Simple Math Quiz\n\nQuestion 1: \n5+2 = ");
    int score = 0;
    int ans = cin.nextInt();
    cin.nextLine();
    if (ans == 7) {
        System.out.println("Correct.");
        score++;
    } else {
        System.out.println("Incorrect. 5+2 = 7");
    }
    System.out.println("\nQuestion 2: \n3*6 = ");
    ans = cin.nextInt();
    cin.nextLine();
    if (ans == 18) {
        System.out.println("Correct.");
        score++;
    } else {
        System.out.println("Incorrect. 3*6 = 18 ");
    }
    System.out.println("\nQuestion 3: \n88-3 = ");
    ans = cin.nextInt();
    cin.nextLine();
    if (ans == 85) {
        System.out.println("Correct.");
        score++;
    } else {
        System.out.println("Incorrect. 88-3 = 85");
    }
    System.out.println("\nScore: " + score + "/3");
    cin.close();
  }
}