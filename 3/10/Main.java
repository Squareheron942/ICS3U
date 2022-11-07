public class Main {
    public static void main(String[] args) {
        System.out.println("Part a");
        for (int i = 6; i >= 0; i--) {
            System.out.println(i + " --> " + (2 * i + 5));
        }
        System.out.println();
        System.out.println("Part b");
        for (int i = 0; i <= 30; i += 3) {
            System.out.println(i + " --> " + (2 * i + 5));
        }
        System.out.println();
        System.out.println("Part c");
        for (int i = -15; i <= 15; i += 5) {
            System.out.println(i + " --> " + (2 * i + 5));
        }
        System.out.println();
        System.out.println("Part d");
        for (int i = 1; i <= 1024; i *= 2) {
            System.out.println(i + " --> " + (2 * i + 5));
        }
        System.out.println();
    }
}