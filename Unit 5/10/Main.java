import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> phone = new HashMap<Character, Integer>();
        {
            phone.put('A', 2);
            phone.put('B', 2);
            phone.put('C', 2);
            phone.put('D', 3);
            phone.put('E', 3);
            phone.put('F', 3);
            phone.put('G', 4);
            phone.put('H', 4);
            phone.put('I', 4);
            phone.put('J', 5);
            phone.put('K', 6);
            phone.put('L', 5);
            phone.put('M', 6);
            phone.put('N', 6);
            phone.put('O', 6);
            phone.put('P', 7);
            phone.put('Q', 7);
            phone.put('R', 7);
            phone.put('S', 7);
            phone.put('T', 8);
            phone.put('U', 8);
            phone.put('V', 8);
            phone.put('W', 9);
            phone.put('X', 9);
            phone.put('Y', 9);
            phone.put('Z', 9);
        }
        
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();

        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextLine().replaceAll("-", "").replaceAll("\\s*", "");
            for (int j = 65; j < 91; j++) {
                nums[i] = nums[i].replaceAll(String.valueOf(((char)j)), String.valueOf(phone.get(((char)j))));
            }
            nums[i] = addChar(nums[i], '-', 3);
            nums[i] = addChar(nums[i], '-', 7);
            System.out.println(nums[i].substring(0, 12));
        }
        cin.close();
    }


    public static String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }

    
}