import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String school = "Colonel By";
        Scanner input = new Scanner(System.in);
        System.out.println("Where were you born?  Enter a string value:");
        String city = input.nextLine();
        System.out.println("What is your middle initial? Enter a character:");
        char initial = input.nextLine().charAt(0);
        System.out.println("What year were you born?  Enter the 4 digit integer value:");
        int byear = Integer.parseInt(input.nextLine());
        System.out.println("Pick a number between 16 and 17.  Enter the decimal number:");
        double number = Double.parseDouble(input.nextLine());
        System.out.println("Thank you for your input.");
        System.out.println(city + " is beautiful.");
        System.out.println(initial + ", can I call you, \""+initial+"\" - I think you must be "+byear+" + "+number+" years old and attend \""+school+"\".");
        input.close();
    }
}