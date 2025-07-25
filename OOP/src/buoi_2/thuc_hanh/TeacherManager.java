package buoi_2.thuc_hanh;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherManager {
    static Scanner sc = new Scanner(System.in);
    static int id = 1;
    static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void addTeacher() {
        System.out.println("Add new teacher with id #" + id);

        String fullName;
        int age;
        String subject;
        float teachingHours;

        while (true) {
            System.out.print("Enter full name: ");
            fullName = sc.nextLine().trim();
            if (fullName.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) break;
            else System.out.println("Name is invalid!, name cannot contain special characters and digit.");
        }

        while (true) {
            System.out.print("Enter age (18-100): ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                if (age < 18 || age > 100) {
                    System.out.println("Age is invalid!");
                    continue;
                }
                sc.nextLine();
                break;
            } else {
                System.out.println("Age is invalid!");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Enter subject: ");
            subject = sc.nextLine().trim();
            if (subject.matches("^[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+$")) break;
            else System.out.println("Subject is invalid!, Subject names cannot contain special characters.");
        }

        while (true) {
            System.out.print("Enter teaching hours (0-1500): ");
            if (sc.hasNextFloat()) {
                teachingHours = sc.nextFloat();
                if (teachingHours < 0 || teachingHours > 1500) {
                    System.out.println("Teaching hours is invalid!");
                    continue;
                }
                sc.nextLine();
                break;
            } else {
                System.out.println("Teaching hours is invalid!");
                sc.next();
            }
        }

        Teacher newTeacher = new Teacher(id++, fullName, age, subject, teachingHours);
        Utils.addObject(teachers, newTeacher);
        System.out.println("Teacher added!\n");
    }

    public static void displayTeachers(ArrayList<Teacher> list) {
        Utils.displayList(list);
    }

    public static ArrayList<Teacher> getTeachersByName(String name) {
        ArrayList<Teacher> teachersByName = new ArrayList<>();
        String keyword = name.toLowerCase().trim();

        for (Teacher teacher : teachers) {
            if (teacher.getFullName().toLowerCase().contains(keyword)) {
                teachersByName.add(teacher);
            }
        }

        return teachersByName;
    }

    public static int getTotalTeachers() {
        return Teacher.getTotalTeachers();
    }

    public static ArrayList<Teacher> getTopTeachingHour() {
        ArrayList<Teacher> topTeachingHour = new ArrayList<>();
        float topHour = -1;

        for (Teacher teacher : teachers) {
            if (teacher.getTeachingHours() > topHour) {

                topTeachingHour.clear();
                topHour = teacher.getTeachingHours();
                topTeachingHour.add(teacher);

            } else if (teacher.getTeachingHours() == topHour) {

                topTeachingHour.add(teacher);

            }
        }

        return topTeachingHour;
    }

    public static ArrayList<Teacher> listWithUnder20Hours() {
        ArrayList<Teacher> under20Hours = new ArrayList<>();

        for (Teacher teacher : teachers) {
            if (teacher.getTeachingHours() < 20) under20Hours.add(teacher);
        }

        return under20Hours;
    }

    public static void displayMenu() {
        System.out.println(">> FEATURE SELECTION <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Add teacher                              |");
        System.out.println("| 2. Find teacher by name                     |");
        System.out.println("| 3. Total teachers                           |");
        System.out.println("| 4. Top teaching hours                       |");
        System.out.println("| 5. Under 20 hours                           |");
        System.out.println("| 6. Display teachers                         |");
        System.out.println("| 7. Exit                                     |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Number of teachers to add: ");
                    int num = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < num; i++) {
                        addTeacher();
                    }
                    break;
                case 2:
                    System.out.print("Enter teacher name: ");
                    String name = sc.nextLine();
                    ArrayList<Teacher> foundTeachers = getTeachersByName(name);
                    if (foundTeachers.isEmpty()) {
                        System.out.println("Teacher not found!\n");
                        break;
                    }
                    displayTeachers(foundTeachers);
                    System.out.printf("Found %d teachers!\n", foundTeachers.size());
                    break;
                case 3:
                    System.out.println("Total teachers: " + getTotalTeachers() + "\n");
                    break;
                case 4:
                    ArrayList<Teacher> topTeachers = getTopTeachingHour();
                    if (topTeachers.isEmpty()) {
                        System.out.println("Teacher not found!\n");
                        break;
                    }
                    displayTeachers(topTeachers);
                    System.out.printf("Found %d teachers!\n", topTeachers.size());
                    break;
                case 5:
                    ArrayList<Teacher> under20Hours = listWithUnder20Hours();
                    if (under20Hours.isEmpty()) {
                        System.out.println("Teacher not found!\n");
                        break;
                    }
                    displayTeachers(under20Hours);
                    System.out.printf("Found %d teachers!\n", under20Hours.size());
                    break;
                case 6:
                    if (teachers.isEmpty()) {
                        System.out.println("Teacher not found!\n");
                        break;
                    }
                    displayTeachers(teachers);
                    System.out.printf("Found %d teachers!\n", teachers.size());
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
