import java.util.*;
class Main {
    public static void main(String[] args) {
    //DO NOT ALTER THIS MAIN
        //collect user input
        Scanner s = new Scanner(System.in);

        int x= s.nextInt();
        int y= s.nextInt();

        s.close();

        //Call to isDivisible
        System.out.println(isDivisible(x,y));

    }
    //write method here
    static boolean isDivisible(int a, int b) {
        return (a%b==0);
    }
}