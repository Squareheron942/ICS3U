import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //read in integer values
        int [] nums = new int[4];
        int [] dens = new int[4];
        for (int i=0; i<4; i++){
            nums[i] = s.nextInt();
            dens[i] = s.nextInt();
        }
        //set fractions with user input
        Fraction a = new Fraction(nums[0],dens[0] );
        Fraction b = new Fraction(nums[1],dens[1] );
        Fraction c = new Fraction( );
        Fraction d = new Fraction( );

        //call getters/setters 
        System.out.println(a.getNumerator());
        System.out.println(a.getDenominator());
        System.out.println(b.getNumerator());
        System.out.println(b.getDenominator());

        c.setNumerator(nums[2]);
        c.setDenominator(dens[2]);
        d.setNumerator(nums[3]);
        d.setDenominator(dens[3]);

        d.invert();
        //print fractions
        a.print();
        b.print();
        c.print();
        d.print();
    }

}

class Fraction {
    private int num, den;

    public Fraction() {
        num = 0;
        den = 1;
    }

    public Fraction (int n, int d) {
        if (d < 0) {
            this.num = -n;
            this.den = -d;
        } else {
            num = n;
            den = d;
        }
        
        if (d == 0) {
            this.den = 1;
        }
    }

    int getNumerator() {
        return this.num;
    }

    int getDenominator() {
        return this.den;
    }

    void setNumerator(int _num) {
        this.num = _num;
    }

    void setDenominator(int _den) {
        
        this.den = _den == 0 ? 1 : _den;

        if (this.den < 0) {
            this.num *= -1;
            this.den *= -1;
        }
    }

    public void invert () {
        if (this.num != 0) {
            int temp = this.num;
            this.num = this.den;
            this.den = temp;
        }

        if (this.den < 0) {
            this.den = -this.den;
            this.num = -this.num;
        }

        this.den = this.den == 0 ? 1 : this.den;
    }

    void print() {
        System.out.println(this.num + "/" + this.den);
    }
}

