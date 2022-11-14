import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max = 0, current = 0;
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        cin.close();
        for (int i = 0; i < s.length(); i++) {
            for (int index = i; index < s.length(); index++) {
                for (int j = index; j < s.length(); j++) {
                    if (isPalindrome(s.substring(index, j + 1))) {
                        current = s.substring(index, j + 1).length();
                        if (max < current) { max = current; }
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static boolean isPalindrome(String n) {
        n = n.replaceAll("\\s+","");

        String rev = reverse(n);
        
        return n.equals(rev);
    }
    public static String reverse(String st) {
        char[] _n = new char[st.length()];
        for (int i = 0; i < st.length(); i++) {
            _n[i] = st.charAt(st.length() - i - 1);
        }
        return String.valueOf(_n);
    }
}