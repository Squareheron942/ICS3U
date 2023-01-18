import java.util.*;
public class Main {
    public static void main(String[] args) {
    //DO NOT ALTER THIS MAIN
        //collect user input
        Scanner s = new Scanner(System.in);

        int x= s.nextInt();
        int y= s.nextInt();

        s.close();
        
        //Call to gcd
        System.out.println(gcd(x, y));

    }
    //write method here
    public static int gcd(int a, int b) {return b == 0 ? a : gcd(b, a % b);}
}