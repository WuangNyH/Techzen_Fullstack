package array_list.buoi_chieu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static buoi_05.bai01_class.Bai01.validateData;
import static array_list.buoi_chieu.Bai01v1.displayMenu;

public class Bai01v2 {
    static Scanner sc = new Scanner(System.in);
    static int id = 1;
    static ArrayList<Integer> ids = new ArrayList<>();
    static ArrayList<String> fullNames = new ArrayList<>();
    static ArrayList<Integer> ages = new ArrayList<>();
    static ArrayList<String> genders = new ArrayList<>();
    static ArrayList<Double> salaries = new ArrayList<>();
    static ArrayList<Float> gpas = new ArrayList<>();


    public static String createEmployee(int id) {
        System.out.print("Enter Fullname: ");
        String fullName = sc.nextLine();

        System.out.print("Enter Age (18 - 100): ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Gender (Male/Female): ");
        String gender = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Enter GPA (0-4): ");
        float gpa = Float.parseFloat(sc.nextLine());

        String errors = validateData(age, gender, salary, gpa, fullName);

        if (!errors.isEmpty()) {
            System.out.println("Error: " + errors);
            return null;
        }

        ids.add(id);
        fullNames.add(fullName);
        ages.add(age);
        genders.add(gender);
        salaries.add(salary);
        gpas.add(gpa);

        return "Employee " + id + " has been created.";
    }


    public static int getEmployeeById(int id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                return i;
            }
        }

        return -1;
    }

    public static void removeEmployeeById(int id) {
        int employeeId = getEmployeeById(id);

        if (employeeId == -1) {
            System.out.println("No employee with id " + id);
            return;
        }

        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                ids.remove(i);
                fullNames.remove(i);
                ages.remove(i);
                genders.remove(i);
                salaries.remove(i);
                gpas.remove(i);
                break;
            }
        }
        System.out.println("Removed employee with id " + id);
    }


    public static void updateEmployee(int id) {
        int employeeIndex = getEmployeeById(id);

        if (employeeIndex == -1) {
            System.out.println("No employee with id " + id);
            return;
        }

        System.out.print("Enter Fullname: ");
        String fullName = sc.nextLine();

        System.out.print("Enter Age (18 - 100): ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Gender (Male/Female): ");
        String gender = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Enter GPA (0-4): ");
        float gpa = Float.parseFloat(sc.nextLine());

        String errors = validateData(age, gender, salary, gpa, fullName);

        if (!errors.isEmpty()) {
            System.out.println("Error: " + errors);
            return;
        }

        fullNames.set(employeeIndex, fullName);
        ages.set(employeeIndex, age);
        genders.set(employeeIndex, gender);
        salaries.set(employeeIndex, salary);
        gpas.set(employeeIndex, gpa);

        System.out.println("Updated employee with id " + id);
    }

    public static void getListEmployee() {
        if (fullNames.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        for (int i = 0; i < ids.size(); i++) {
            displayEmployee(i);
        }
    }

    public static void findTopTwoGPA() {
        if (fullNames.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        if (fullNames.size() == 1) {
            displayEmployee(ids.get(0));
        }


        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < ids.size(); j++) {
                if (gpas.get(i) < gpas.get(j)) {
                    Collections.swap(ids, i, j);
                    Collections.swap(fullNames, i, j);
                    Collections.swap(ages, i, j);
                    Collections.swap(genders, i, j);
                    Collections.swap(salaries, i, j);
                    Collections.swap(gpas, i, j);
                }
            }
        }

        displayEmployee(0);
        displayEmployee(1);
    }

    public static void getEmployeeByName() {
        boolean found = false;

        if (fullNames.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        System.out.print("Enter Fullname: ");
        String fullName = sc.nextLine();

        for (int i = 0; i < ids.size(); i++) {
            if (fullNames.get(i).toLowerCase().contains(fullName.toLowerCase())) {
                found = true;
                displayEmployee(i);
            }
        }

        if (!found) {
            System.out.println("No employee with name " + fullName);
            return;
        }
    }

    public static void sortEmployeeByAge() {
        if (fullNames.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        for (int i = 0; i < ids.size() - 1; i++) {
            for (int j = i + 1; j < ids.size(); j++) {
                if (ages.get(i) > ages.get(j)) {
                    Collections.swap(ids, i, j);
                    Collections.swap(fullNames, i, j);
                    Collections.swap(ages, i, j);
                    Collections.swap(genders, i, j);
                    Collections.swap(salaries, i, j);
                    Collections.swap(gpas, i, j);
                }
            }
        }
        System.out.println("Sorting successful!");
    }


    public static void displayEmployee(int index) {
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("ID: " + ids.get(index));
        System.out.println("Fullname: " + fullNames.get(index));
        System.out.println("Age: " + ages.get(index));
        System.out.println("Gender: " + genders.get(index));
        System.out.println("Salary: " + String.format("%,.0f", salaries.get(index)));
        System.out.println("GPA: " + String.format("%.1f", gpas.get(index)));
        System.out.println("++ ----------------------------------------- ++\n");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Number of employees to add: ");
                    int num = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < num; i++) {
                        while (true) {
                            System.out.println("\nImport info of employee with ID " + id);
                            String status = createEmployee(id);

                            if (status == null) continue;
                            System.out.println(status);
                            id++;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    int idGet = Integer.parseInt(sc.nextLine());

                    int employeeIndex = getEmployeeById(idGet);

                    if (employeeIndex == -1) {
                        System.out.println("No employee with id " + idGet);
                        break;
                    }

                    displayEmployee(employeeIndex);
                    break;
                case 3:
                    System.out.print("Enter id: ");
                    int idRemove = Integer.parseInt(sc.nextLine());

                    removeEmployeeById(idRemove);
                    break;
                case 4:
                    System.out.print("Enter id: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());

                    updateEmployee(idUpdate);
                    break;
                case 5:
                    getListEmployee();
                    break;
                case 6:
                    findTopTwoGPA();
                    break;
                case 7:
                    getEmployeeByName();
                    break;
                case 8:
                    sortEmployeeByAge();
                    break;
                default:
                    System.out.print("Are you sure you want to exit the program? (Y/N): ");
                    String exitChoice = sc.nextLine();
                    if (exitChoice.equalsIgnoreCase("Y") || exitChoice.equalsIgnoreCase("yes")) {
                        return;
                    }
                    break;
            }
        }
    }
}
