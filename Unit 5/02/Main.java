import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static Scanner s = new Scanner(System.in);
  public static void main(String[] args) {
    //DO NOT ALTER - this will get your numbers into an Array
    int n=s.nextInt();
    double [] myArray = getArray(n);

    //call max
    System.out.println(max(myArray));
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

public static double max(double[] d) {
    Arrays.sort(d);
    return d[d.length-1];
}



}