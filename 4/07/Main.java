
import java.util.*;
class Main {
    public static void main(String[] args) {
    //DO NOT ALTER THIS MAIN
        //collect user input
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int low = s.nextInt();
        int high = s.nextInt();
        int step = s.nextInt();
        s.close();

        //Call to 1a
        System.out.println(randomNumber());

        //Call to 1b
        System.out.println(randomNumbera(n));

        //Call to 1c
        System.out.println(randomNumberb(low,high));

        //Call to 1d
        System.out.println(randomNumberc(low,high,step));
    }
    //write methods here

    public static int randomNumber() {
        return ((int)Math.floor(Math.random() * 6 + 1));
    }
    public static int randomNumbera(int high) {
        return ((int)Math.floor(Math.random() * 6 + 1));
    }
    public static int randomNumberb(int min, int max) {
        return ((int)Math.floor(Math.random() * (max - min) + min));
    }
    public static int randomNumberc(int min, int max, int step) {
        return ((int)(Math.floor((Math.random() * (max - min)/((double)step)))) * step + min);
    }
}