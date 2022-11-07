import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter four course grades:");
        double gr1 = Double.parseDouble(input.nextLine());
        double gr2 = Double.parseDouble(input.nextLine());
        double gr3 = Double.parseDouble(input.nextLine());
        double gr4 = Double.parseDouble(input.nextLine());
        System.out.println("The average is: "+ (gr1+gr2+gr3+gr4)/4);
        input.close();
    }
}