import java.util.*;

public class Main {
    static double a, b, c;
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter three sides of a triangle:");
        a = cin.nextDouble();
        b = cin.nextDouble();
        c = cin.nextDouble();
        cin.nextLine();
        if (a + b <= c || b + c <= a || c + a <= b) {
            System.out.println("This is not a triangle.");
            return;
        }

        System.out.println("Here are the calculations:");
        double A = Math.round(Math.acos((b*b + c*c - a*a)/(2*b*c))*(180/Math.PI)*10)/10.0;
        double B = Math.round(Math.acos((c*c + a*a - b*b)/(2*a*c))*(180/Math.PI)*10)/10.0;
        double C = Math.round(Math.acos((a*a + b*b - c*c)/(2*a*b))*(180/Math.PI)*10)/10.0;
        long perim = Math.round(a + b + c);
        double p = perim/2.0;
        double area = Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c))*10)/10.0;
        double insc = Math.round(Math.sqrt((p-a)*(p-b)*(p-c)/p)*10)/10.0;
        double circ = Math.round((a*b*c)/(4*Math.sqrt(p*(p-a)*(p-b)*(p-c)))*10)/10.0;
        System.out.println("Perimeter = " + perim + "\nSemi-perimeter = " + p + "\nArea = " + area + "\nRadius of the Circumscribed Circle = " + circ + "\nRadius of the Inscribed Circle = " + insc + "\nAngle X = " + A + "\nAngle Y = " + B + "\nAngle Z = " + C);
        cin.close();
    }
}
