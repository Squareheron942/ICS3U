import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] directions = {"N", "E", "S", "W"};
        int angle = 0;
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        values.put('N', 0);
        values.put('E', 90);
        values.put('S', 180);
        values.put('W', 270);
        // char[] nums = ['N', 'E', 'S', 'W'];
        Scanner cin = new Scanner(System.in);

        String input = cin.nextLine();
        cin.close();


        if (input.length() < 1 || input.length() > 4 || !Arrays.asList(directions).contains(Character.toString(input.charAt(0))) || (input.length() == 2 && Character.isDigit(input.charAt(1)))) {
            System.out.println("Invalid");
            cin.close();
            return;
        }

        switch (input.length()) {
            case 1:
                angle = values.get(input.charAt(0));
                break;
            case 2:
                angle = (input.charAt(0) == 'N') ? (input.charAt(1) == 'E') ? 45 : 315 : (input.charAt(0) == 'E') ? (input.charAt(1) == 'N') ? 45 : 135 : (input.charAt(0) == 'S') ? (input.charAt(1) == 'E') ? 135 : 225 : (input.charAt(0) == 'W') ? (input.charAt(1) == 'S') ? 225 : 315 : -1;
                break;
            case 3:
                int num = Integer.parseInt(input.substring(1, 2));
                angle = (num > 45) ? -1 : (
                    input.charAt(0) == 'N'
                ) ? (
                    input.charAt(2) == 'E'
                ) ? (
                    (int) num
                ) : (
                    360 - num
                ) : (
                    input.charAt(0) == 'E'
                ) ? (
                    input.charAt(2) == 'S'
                ) ? (
                    90 + num
                ) : (
                    90 - num
                ) : (
                    input.charAt(0) == 'S'
                ) ? (
                    input.charAt(2) == 'W'
                ) ? (
                    180 + num
                ) : (
                    180 - num
                ) : (
                    input.charAt(0) == 'W'
                ) ? (
                    input.charAt(2) == 'N'
                ) ? (
                    270 + num
                ) : (
                    270 - num
                ) : -1;
                break;
            case 4:
                int num2 = Integer.parseInt(input.substring(1, 3));
                angle = (num2 > 45) ? -1 : (
                    input.charAt(0) == 'N'
                ) ? (
                    input.charAt(3) == 'E'
                ) ? (
                    num2
                ) : (
                    360 - num2
                ) : (
                    input.charAt(0) == 'E'
                ) ? (
                    input.charAt(3) == 'S'
                ) ? (
                    90 + num2
                ) : (
                    90 - num2
                ) : (
                    input.charAt(0) == 'S'
                ) ? (
                    input.charAt(3) == 'W'
                ) ? (
                    180 + num2
                ) : (
                    180 - num2
                ) : (
                    input.charAt(0) == 'W'
                ) ? (
                    input.charAt(3) == 'N'
                ) ? (
                    270 + num2
                ) : (
                    270 - num2
                ) : -1;
                break;
        }

        System.out.println((angle > 0) ? "Compass " + input + " is a bearing of " + angle : "Invalid");
        cin.close();
    }
}