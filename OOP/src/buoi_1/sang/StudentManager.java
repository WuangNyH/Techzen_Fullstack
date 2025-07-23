package buoi_1.sang;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String PURPLE = "\u001B[35m";
    static final String RED = "\u001B[31m";

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent() {
        Student student = new Student();
        student.input(sc);
        students.add(student);
    }

    public static void displayStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(CYAN + "++ ----------------------------------------- ++");
            System.out.println(YELLOW + "Sinh viên thứ " + (i + 1) + ":" + RESET);
            student.output();
            System.out.println(CYAN + "++ ----------------------------------------- ++\n" + RESET);
        }
    }

    public static void displayMenu() {
        System.out.println(CYAN + ">> LỰA CHỌN TÍNH NĂNG <<" + RESET);
        System.out.println(CYAN + "++ ----------------------------------------- ++");
        System.out.println(GREEN + "| 1. Thêm sinh viên                           |");
        System.out.println(YELLOW + "| 2. In danh sách sinh viên                   |");
        System.out.println(PURPLE + "| 3. Kết thúc                                 |");
        System.out.println(CYAN + "++ ----------------------------------------- ++" + RESET);
    }



    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print(YELLOW + "Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print(CYAN + "Enter the number of students to input: ");
                    int n =  Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < n; i++) {
                        System.out.println(PURPLE + "Enter information for student #" + (i + 1) + RESET);
                        addStudent();
                    }
                    break;
                case 2:
                    displayStudents();
                    break;
                default:
                    System.out.print("Are u sure exit program (Y/N): ");
                    String exit = sc.nextLine();
                    if (exit.equalsIgnoreCase("y")) {
                        return;
                    }
                    break;
            }
        }
    }
}
