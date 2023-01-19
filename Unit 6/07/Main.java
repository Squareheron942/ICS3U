import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String adminPass;
        // Create random students 
        String [] names = {"Adam", "Bert", "Cansu", "David", "Ernie"};
        int [] ages = {12, 13, 14, 15, 16};
        String [] addresses = {"123 Happy Lane, Ottawa, ON", "45 Colonel By Dr, Ottawa, ON", "32 Abc Dr, Ottawa, ON"};
        String [] phones = {"613-555-3333", "613-555-3333", "613-555-2312"};


        Student [] students = new Student[3];

        for(int i = 0; i < 3; i++){
            students[i] = new Student();
            students[i].name = names[i];
            students[i].age = ages[i];
            students[i].address = addresses[i];
            students[i].phone = phones[i];
            students[i].email = names[i]+"mom@gmail.com";
            students[i].setStudentPassword();
        }

        // Print student passwords if adminPass ='admin'
        for (int x=0; x<3; x++){
            adminPass = s.nextLine();
            System.out.println("Password check - student " +(x+1) +" : " + students[x].getStudentPassword(adminPass)); 
        }
        s.close();
    }
}


class Student {
    private String password;
    String name, address, phone, email;
    int age;

    String getStudentPassword(String adminPass) {
        if (adminPass.equals("admin")) return this.password;
        return "invalid";
    }

    void setStudentPassword() {
        this.password = String.valueOf(this.name.charAt(1)) + String.valueOf(String.valueOf(this.age).charAt(1)) + this.address.charAt(0) + this.phone.substring(3, 6);
    }
}