import java.util.*;
public class Main {
  public static void main(String[] args) {
  //DO NOT ALTER THIS MAIN
     //collect user input
     Scanner s = new Scanner(System.in);

     double x= s.nextDouble();
     double y= s.nextDouble();
     double z= s.nextDouble();

    //Call to findLargest
    System.out.println(findLargest(x,y,z));

  }
  //write method here

  static double findLargest(double x, double y, double z) {
    double[] a = {x, y, z};
    Arrays.sort(a);
    return a[a.length - 1];
  }
}