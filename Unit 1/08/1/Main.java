import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Welcome to my Area Program!");
        System.out.println("Enter the length:");
        int Length = userinput.nextInt();
        System.out.println("Enter the width:");
        int Width = userinput.nextInt();
        System.out.println("Area = " + Length * Width);
        userinput.close();
    }
}