public class Main {
    public static void main(String[] args) {
        Fraction def = new Fraction();
        def.print();
        System.out.println("Default value check: " + def.equals(new Fraction(0, 1)));

        Fraction f1 = new Fraction(53, 54);
        f1.print();

        Fraction f2 = new Fraction(f1);
        f2.print();

        System.out.println("Assigned value check: " + f1.equals(f2));
    }
}

/**
 * Fraction
 */
class Fraction {
    int num, den;

    Fraction (int n, int d){
        this.num = n;
        this.den = d;
    }

    Fraction(Fraction other) {
        this.num = other.num;
        this.den = other.den;
    }

    Fraction() {
        num = 0;
        den = 1;
    }

    boolean equals (Fraction other) {
        if (this.num == other.num && this.den == other.den) {
            return true;
        } else {
            return false;
        }
    }

    void print() {
        System.out.println(this.num + "/" + this.den);
    }
}
