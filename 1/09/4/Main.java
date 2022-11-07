import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Double> grade = new ArrayList<>();
        double total = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter mark 1:");
        grade.add(Double.parseDouble(input.nextLine()));
        System.out.println("Marks: " + grade.toString().replace("[", "").replace("]", ""));
        System.out.println("Enter mark 2:");
        grade.add(Double.parseDouble(input.nextLine()));
        System.out.println("Marks: " + grade.toString().replace("[", "").replace("]", ""));
        total = 0;
        for (int i = 0; i < 2; i++) {
            total += grade.get(i);
        }
        System.out.println("Mark total is " + total);
        System.out.println("Enter mark 3:");
        grade.add(Double.parseDouble(input.nextLine()));
        System.out.println("Marks: " + grade.toString().replace("[", "").replace("]", ""));
        total = 0;
        for (int i = 0; i < 3; i++) {
            total += grade.get(i);
        }
        System.out.println("Mark total is " + total);
        System.out.println("Enter mark 4:");
        grade.add(Double.parseDouble(input.nextLine()));
        System.out.println("Marks: " + grade.toString().replace("[", "").replace("]", ""));
        total = 0;
        for (int i = 0; i < 4; i++) {
            total += grade.get(i);
        }
        double average = total/4;
        System.out.println("Mark total is " + total);
        System.out.println("The average is " + average);
        input.close();
    }
}