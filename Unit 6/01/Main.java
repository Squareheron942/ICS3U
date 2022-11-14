import java.util.Scanner;

class Student {
    String fname = "", lname = "";
    int age = 0, grade = 0;
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Student[] students = new Student[4];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].fname = cin.nextLine();
            students[i].lname = cin.nextLine();
            students[i].age = cin.nextInt();
            cin.nextLine();
            students[i].grade = cin.nextInt();
            cin.nextLine();
        }
        
        cin.close();
        System.out.println(students[0].fname);
        System.out.println(students[1].lname);
        System.out.println(students[2].age);
        System.out.println(students[3].grade);
    }
}
