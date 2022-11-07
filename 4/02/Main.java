public class Main {
    public static void main(String args[]){
        dieRoll();
    }

     //put your method here 

    public static void dieRoll() {
        System.out.println("You rolled a " + ((int)Math.floor(Math.random() * 6 + 1)));
    }
}