import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Fraction p = new Fraction(s.nextInt(), s.nextInt());
        Fraction q = new Fraction(s.nextInt(), s.nextInt());
        Fraction.product(p, q).print(); // 1 
        Fraction.abs(q).print();        // 2

        System.out.println(Fraction.isPositive(p)); // 3
        System.out.println(Fraction.isPositive(q)); // 3

        s.close();
    }

}

/**
 * Fraction
 */
class Fraction {
    int num, den;

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
        if (den < 0) {
            this.num *= -1;
            this.den *= -1;
        }
    }

    static Fraction abs(Fraction frac) {
        int den = Math.abs(frac.den);
        int num = Math.abs(frac.num);

        return new Fraction(num, den);
    }

    static boolean isPositive(Fraction frac) {
        if (frac.den < 0) {
            frac.num *= -1;
            frac.den *= -1;
        }

        if (frac.num < 0) return false;

        return true;
    }

    static Fraction product(Fraction a, Fraction b) {
        if (a.den < 0) {
            a.num *= -1;
            a.den *= -1;
        }

        if (b.den < 0) {
            b.num *= -1;
            b.den *= -1;
        }

        a = reduce(a);
        b = reduce(b);

        return new Fraction(a.num * b.num, a.den * b.den);
    }

    static Fraction reduce(Fraction frac) {
        if (frac.den < 0) {
            frac.num *= -1;
            frac.den *= -1;
        }

        int g = gcd(frac.num, frac.den);
        int num = frac.num, den = frac.den;
        num /= g;
        den /= g;
        return new Fraction(num, den);
    }

    void print() {
        int num = reduce(this).num;
        int den = reduce(this).den;
        System.out.println(num + "/" + den);
    }

    static int gcd(int a, int b) {return (b == 0) ? a : gcd(b, a%b);}
}