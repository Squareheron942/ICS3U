import java.util.*;
class Main {
  static Scanner c = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Welcome to my 2-player rock-paper-scissors game!\nHow many rounds would you like to play?");
    int n = c.nextInt();
    int s1 = 0, s2 = 0;
    c.nextLine();
    for (int i = 0; i < n; i++) {
      int r = rps();
      if (r == 0) {
        System.out.println("Tie");
        i--;
      } else if (r == 1) {
        s1++;
      } else {
        s2++;
      }
    }
    System.out.println("Final Scoring:\nPlayer 1: " + (s1 * 10) + " points\nPlayer 2: " + (s2 * 10) + " points\n" + ((s1 > s2) ? "Player 1 wins!" : (s1==s2) ? "Tie" : "Player 2 wins!") + "\nThanks for playing!");
    c.close();
  }
  static int rps() {
    System.out.println("Pick your move!");
    System.out.println("Player 1:");
    char p1 = c.nextLine().charAt(0);
    while (p1 != 'r' && p1 != 'p' && p1 != 's') {
      System.out.println("Invalid input.");
      System.out.println("Player 1:");
      p1 = c.nextLine().charAt(0);
    }
    System.out.println("Pick your move!");
    System.out.println("Player 2:");
    char p2 = c.nextLine().charAt(0);
    while (p2 != 'r' && p2 != 'p' && p2 != 's') {
      System.out.println("Invalid input.");
      System.out.println("Player 2:");
      p2 = c.nextLine().charAt(0);
    }
    if (p1 == p2) {return 0;}
    return (p1 == 'r' && p2 == 'p') ? 2 : (p1 == 'r' && p2 == 's') ? 1 : (p1 == 's' && p2 == 'p') ? 1 : (p1 == 's' && p2 == 'r') ? 2 : (p1 == 'p' && p2 == 'r') ? 1 : (p1 == 'p' && p2 == 's') ? 2 : 0;
  }
}