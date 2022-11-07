public class Main {

    public static void main(String args[]){
        twoDieRoll();
    }

     //put your method here 

    public static void twoDieRoll()
    {
        int a = ((int)Math.floor(Math.random() * 6 + 1));
        int b = ((int)Math.floor(Math.random() * 6 + 1));

        System.out.println(a + " and " + b + " ==> total " + (a+b));
    }

}