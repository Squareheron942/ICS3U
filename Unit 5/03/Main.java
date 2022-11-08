import java.util.Scanner;

class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        //DO NOT ALTER - this will get your numbers into 2 user entered Arrays
        //you just need to write equals
        int n=s.nextInt();
        double [] myArray = getArray(n);
        int n2=s.nextInt();
        double [] myArray2 = getArray(n2);
        //call max
        System.out.println(equals(myArray,myArray2));
    }

    //do not alter the method getArray
    public static double[] getArray(int n){
    double [] temp = new double[n];
    for(int x=0; x<n; x++){
        temp[x] = s.nextDouble();
    }
    return temp;
    }

    //write your method here---

    static boolean equals(double[] a, double[] b) {

        if (a.length != b.length) {return false;}

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}