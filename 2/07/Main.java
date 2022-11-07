import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter quadratic equation a, b and c");
    int a = cin.nextInt();
    cin.nextLine();
    int b = cin.nextInt();
    cin.nextLine();
    int c = cin.nextInt();
    if (b*b > 4 * a * c) {
        double ans1 = Math.round((-1 * b + Math.sqrt(b*b - 4*a*c))/(2.0*a) * 10)/10.0;
        double ans2 = Math.round((-1 * b - Math.sqrt(b*b - 4*a*c))/(2.0*a) * 10)/10.0;
        System.out.println("This has two solutions x=" + ans2 + " and x=" + ans1);
    } else if (b*b == 4 * a * c) {
        double ans1 = Math.round((-1 * b - Math.sqrt(b*b - 4*a*c))/(2.0*a) * 10)/10.0;
        System.out.println("This has one solution x=" + ans1);
    } else {
        System.out.println("This has no solution");
    }
    cin.close();
  }
}