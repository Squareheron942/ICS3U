import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q1
        Fraction f = new Fraction();
        f.num = 2;
        f.den = 7;
        // Q2
        // P is not initialized
        // Q3
        // p = 3/1
        // q.num = 4, q.den is not initialised
        // r.den = 3
        // Q4
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        Scanner cin = new Scanner(System.in);
        String _f1 = cin.nextLine();
        String _f2 = cin.nextLine();
        f1.num = Integer.parseInt(_f1.split("\\s+")[0]);
        f1.den = Integer.parseInt(_f1.split("\\s+")[1]);
        f2.num = Integer.parseInt(_f2.split("\\s+")[0]);
        f2.den = Integer.parseInt(_f2.split("\\s+")[1]);
        cin.close();

        f1.num *= 2;
        System.out.println(f1.num + "/" + f1.den);
        int temp = f2.num;
        f2.num = f2.den;
        f2.den = temp;
        System.out.println(f2.num + "/" + f2.den);

        f1.num *= f2.num;
        f1.den *= f2.den;
        System.out.println(f1.num + "/" + f1.den);
        f2.num = f2.den * f1.num + f2.num * f1.den;
        f2.den *= f1.den;
        System.out.println(f2.num + "/" + f2.den);
        f1.num = Math.abs(f1.num);
        f1.den = Math.abs(f1.den);
        System.out.println(f1.num + "/" + f1.den);
    }
}


class Fraction {
    int num, den;
}