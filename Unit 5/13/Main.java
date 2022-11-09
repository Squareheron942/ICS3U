import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int rows = cin.nextInt();
        cin.nextLine();
        int[][] nums = new int[rows][];
        int[] u = new int[rows];

        for (int i = 0; i < rows; i++) {
            String[] s = cin.nextLine().split("\\s+");
            int[] ns = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            nums[i] = new int[ns[0]];
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = ns[j+1];
            }
            Arrays.sort(nums[i]);
            u[i] = nums[i][nums[i].length-1];
        }

        cin.close();
        Arrays.sort(u);

        System.out.println(u[u.length-1]);
    }
}