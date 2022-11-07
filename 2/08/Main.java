import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter amount less than $1");
        int m = cin.nextInt();
        long quarters = Math.round(Math.floor(m/25.0));
        m %= 25;
        long dimes = Math.round(Math.floor(m/10.0));
        m %= 10;
        long nickels = Math.round(Math.floor(m/5.0));
        m %= 5;
        int pennies = m;
        String q = (quarters == 0)? "" : (quarters == 1)? "1 quarter\n" : String.valueOf(quarters) + " quarters\n";
        String d = (dimes == 0)? "" : (dimes == 1)? "1 dime\n" : String.valueOf(dimes) + " dimes\n";
        String n = (nickels == 0)? "" : (nickels == 1)? "1 nickel\n" : String.valueOf(nickels) + " nickels";
        String p = (pennies == 0)? "" : (pennies == 1)? "1 penny" : String.valueOf(pennies) + " pennies";
        System.out.println("Your change is:\n" + q + d + n + p);
        cin.close();
    }
}