import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q1

        // a) r == 4/5
        // b) r == -9/-7
        // c) r == 5/6
        // d) r == -9/-12
        // e) r == 13/20

        // Q2

        Scanner s = new Scanner(System.in);
        Fraction a = new Fraction( );
        Fraction b = new Fraction( );
        Fraction c = new Fraction( );
        Fraction d = new Fraction( );

        //set fractions with user input
        a.num = s.nextInt();
        a.den = s.nextInt();
        b.num = s.nextInt();
        b.den = s.nextInt();
        c.num = s.nextInt();
        c.den = s.nextInt();

        s.close();

       //call instance methods
        a.plusEquals(b);
        d = a.plus(c);
        d.reduce();

       //print fractions with instance method
        a.print();
        b.print();
        c.print();
        d.print();
        // a = 1/2
        // b = 4/5
        // c = 22/50
    }
}

class Fraction {
    int num, den;

    void plusEquals(Fraction other) {
        this.num = this.den * other.num + this.num * other.den;
        this.den *= other.den;
    }

    Fraction plus(Fraction other) {
        Fraction temp = new Fraction();
        temp.num = this.den * other.num + this.num * other.den;
        temp.den = this.den * other.den;
        return temp;
    }

    void reduce() {
        int g = this.gcd(this.num, this.den);
        this.num /= g;
        this.den /= g;
    }

    void print() {
        System.out.println(this.num + "/" + this.den);
    }

    int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a%b);
    }
}
