import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int[] nums = new int[3];
    System.out.println("Enter 3 integer values:");
    nums[0] = cin.nextInt();
    cin.nextLine();
    nums[1] = cin.nextInt();
    cin.nextLine();
    nums[2] = cin.nextInt();
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums).split("\\[")[1].split("]")[0]);
    cin.close();
  }
}