import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String[] s = cin.nextLine().split("\\s+");
        cin.close();

        int[] sample = new int[10];

        for (int i = 0; i < s.length; i++) {
            sample[i] = Integer.parseInt(s[i]);
        }

        int a = sample[0];
        int b = sample[sample.length-1];

        sample[0] = b;
        sample[sample.length-1] = a;

        for (int i = 0; i < sample.length; i++) {
            sample[i] = Math.abs(sample[i]);
        }

        int sampleSum = 0;

        for (int i = 0; i < sample.length; i++) {
            sampleSum += sample[i];
        }

        System.out.println(sampleSum);

        for (int i = 0; i < sample.length; i+=2) {
            System.out.print(sample[i] + " ");
        }

    }
}