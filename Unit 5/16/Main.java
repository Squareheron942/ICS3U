import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        String[] l1 = cin.nextLine().split(" ");
        String[] l2 = cin.nextLine().split(" ");
        cin.close();

        if (n > 30 || n < 1) {
            System.out.println("bad");
            return;
        }

        HashMap<String, String> p = new HashMap<>();

        for (int i = 0; i < n; i++) {
            p.put(l1[i], l2[i]);
        }
        
        if (!l1[0].equals("Ada") && !l1[0].equals("Rich")) {
            // System.out.println(Arrays.toString(l1) + "\n" + Arrays.toString(l2));
        }

        // System.out.println(Arrays.toString(l1) + "\n" + Arrays.toString(l2) + "\n" + p);

        int checker = 0;
        for (int i = 0; i < n; i++) {
            if (p.get(l1[i]).equals(l1[i])) {checker++;}
            if (p.get(l1[i]).equals(getKeyByValue(p, l1[i]))) {
            } else {
                checker++;
            }
        }
        System.out.println(checker == 0 ? "good" : "bad");
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}