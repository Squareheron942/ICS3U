import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a positive, 4-digit number (1111 to 9999): ");
        int intIn = Integer.parseInt(input.nextLine());
        System.out.println("The digits of " + intIn + " are " + intIn/1000 + ", " + (intIn - (intIn/1000*1000))/100 + ", " + (intIn - (intIn/100*100))/10 + ", and " + (intIn - (intIn/10*10)) + ".");
        input.close();
    }
}