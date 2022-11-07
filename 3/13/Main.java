import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String n = cin.nextLine().toLowerCase();
        n = n.replaceAll("\\s+","");
        cin.close();

        String rev = reverse(n);
        
        System.out.println(n.equals(rev));
    }


    
    public static String reverse(String st) {
        char[] _n = new char[st.length()];
        for (int i = 0; i < st.length(); i++) {
            _n[i] = st.charAt(st.length() - i - 1);
        }
        return String.valueOf(_n);
    }
}