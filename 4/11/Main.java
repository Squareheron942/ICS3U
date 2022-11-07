import java.util.*;
class Main {
    public static void main(String[] args) {
    //DO NOT ALTER THIS MAIN
        //collect user input
        Scanner s = new Scanner(System.in);

        String line= s.nextLine();

        s.close();


        //Call to isLetter
        System.out.println(isLetter(line));

    }
    //write method here

    static boolean isLetter(String s) {

        if (s.length() == 1) {
            return Character.isLetter(s.charAt(0));
        }

        return false;
    }
}