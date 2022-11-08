import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String s1 = cin.nextLine();
        String s2 = cin.nextLine();
        String s3 = cin.nextLine().toLowerCase();

        cin.close();
        String s = ((s1.indexOf("a") % 2 == 0 && s1.indexOf("a") < 20) ? String.valueOf(s1.indexOf("a")) : "#");
        String d = (
            s3.replaceAll("\\s*", "").length() >= 3 ?
            s3.replaceAll("\\s*", "").substring(s3.replaceAll("\\s+", "").length()-3) : 
            s3.replaceAll("\\s*", "").length() == 2 ? 
            s3.replaceAll("\\s*", "").substring(s3.replaceAll("\\s+", "").length()-2) + "%" : 
            s3.replaceAll("\\s*", "").substring(s3.replaceAll("\\s+", "").length()-1) + "%%"
        );

        System.out.println(
            String.valueOf(s1.toUpperCase().charAt(0)) +
            String.valueOf(s2.toUpperCase().charAt(0)) +
            String.valueOf(s3.toUpperCase().charAt(0)) +
            Math.abs(s1.length() - s2.length()) +
            s +
            d
        );
    }
}