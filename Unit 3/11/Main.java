public class Main {
    public static void main(String[] args) {
        double total = 0;
        for (double i = 1; i <= 1000; i++) {
            total += 1/i;
        }
        System.out.println(total);
        total = 0;
        for (int i = 1; i <= 50; i++) {
            total += Math.sqrt(i*100);
        }
        System.out.println(total);
        long total2 = 1;
        for (int i = 1; i <= 20; i++) {
            total2 *= i;
        }
        System.out.println((long)total2);
        int total3 = 0;
        for (int i = -12; i <= 20; i++) {
            total3 += i*i*i;
        }
        System.out.println((int)total3);
        total = 0;
        for (double i = 1; i <= 25; i++) {
            total += Math.pow(i, 1/i);
        }
        System.out.println(total);
        total = 0;
    }
}
