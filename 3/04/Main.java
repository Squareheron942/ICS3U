import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String n = cin.nextLine();
        String[] nums = n.split(" ");
        int sum = 0;
        String num, oldnum = "";
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];

            if (num.equals(oldnum)) {
                sum++;
            }

            oldnum = num;
        }
        cin.close();
        System.out.println("There are " + sum + " cases of consecutive values");
    }
}
