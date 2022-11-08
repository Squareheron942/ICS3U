import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        int input = 1;
        while (input > 0) {
            input = cin.nextInt();
            cin.nextLine();
            if (input <= 10 && input > 0) { scores.add(input); }
        }
        System.out.println(occurences(scores));
        cin.close();
    }

    static String occurences(ArrayList<Integer> s) {
        String output = "Score  #Occurrences\n";
        int[] o = new int[10];
        int t = 0;

        //count the occurences of each score
        for (int i = 0; i < s.size(); i++) {
            t += s.get(i);
            o[s.get(i)-1]++;
        }

        //output formatting
        for (int i = 0; i < 10; i++) {
            output += i != 9 ? ((i + 1) + "      " + o[i] + "\n") : ((i + 1) + "     " + o[i] + "\n");
        }

        output += "Mean: " + Math.round(t*10/((double)s.size()))/10.0;
        return output;
    }
}