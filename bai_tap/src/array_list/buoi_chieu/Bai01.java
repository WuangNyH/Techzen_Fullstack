package array_list.buoi_chieu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static buoi_05.bai01_class.Bai01.validateData;

public class Bai01 {
    static int id = 1;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Object>> employees = new ArrayList<>();

    public static ArrayList<Object> createEmployee(int id) {
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

        ArrayList<Object> employee = new ArrayList<>();
        employee.add(id);
        employee.add(fullName);
        employee.add(age);
        employee.add(gender);
        employee.add(salary);
        employee.add(gpa);

        return employee;
    }


    public static void removeEmployeeById(int id) {
        ArrayList<Object> employee = getEmployeeById(id);

        if (employee == null) {
            System.out.println("No employee with id " + id);
            return;
        }

        employees.removeIf(e -> (int) e.get(0) == id);
        System.out.println("Removed employee with id " + id);
    }

    public static ArrayList<Object> getEmployeeById(int id) {
        return employees.stream().filter(employee -> (int) employee.get(0) == id).findFirst().orElse(null);
    }


    public static void updateEmployee(int id) {
        ArrayList<Object> employee = getEmployeeById(id);

        if (employee == null) {
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

        employee.set(1, fullName);
        employee.set(2, age);
        employee.set(3, gender);
        employee.set(4, salary);
        employee.set(5, gpa);

        System.out.println("Updated employee with id " + id);
    }


    public static void getListEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        for (ArrayList<Object> employee : employees) {
            displayEmployee(employee);
        }
    }


    public static void displayMenu() {
        System.out.println(">> FUNCTION SELECTION <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Add employee                             |");
        System.out.println("| 2. Find employee (by ID)                    |");
        System.out.println("| 3. Remove employee (by ID)                  |");
        System.out.println("| 4. Update employee (by ID)                  |");
        System.out.println("| 5. Display list employee                    |");
        System.out.println("| 6. Top 2 GPA                                |");
        System.out.println("| 7. Find employee (by Name)                  |");
        System.out.println("| 8. Sort employee by age                     |");
        System.out.println("| 9. Exit program                             |");
        System.out.println("++ ----------------------------------------- ++");
    }


    public static void displayEmployee(ArrayList<Object> employee) {
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("ID: " + employee.get(0).toString());
        System.out.println("Fullname: " + employee.get(1).toString());
        System.out.println("Age: " + employee.get(2).toString());
        System.out.println("Gender: " + employee.get(3).toString());
        System.out.println("Salary: " + String.format("%,.0fVND", (double) employee.get(4)));
        System.out.println("GPA: " + String.format("%.1f", (float) employee.get(5)));
        System.out.println("++ ----------------------------------------- ++\n");
    }


    public static void findTopTwoGPA() {
        if (employees.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        employees.sort((e1, e2) -> Float.compare((float) e2.get(5), (float) e1.get(5)));
        displayEmployee(employees.get(0));
        displayEmployee(employees.get(1));
    }


    public static void getEmployeeByName(String name) {
        List<ArrayList<Object>> filtered = employees.stream()
                .filter(x -> x.get(1).toString().contains(name))
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("No employee with name " + name);
            return;
        }

        filtered.forEach(Bai01::displayEmployee);
    }


    public static void sortEmployeeByAge() {
        if (employees.isEmpty()) {
            System.out.println("No employee in list");
            return;
        }

        employees.sort(Comparator.comparingInt(e -> (int) e.get(2)));

        System.out.println("Sorting successful!");
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
                            ArrayList<Object> newEmployee = createEmployee(id);

                            if (newEmployee == null) continue;
                            employees.add(newEmployee);
                            id++;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter id: ");
                    int idGet = Integer.parseInt(sc.nextLine());

                    ArrayList<Object> employee = getEmployeeById(idGet);

                    if (employee == null) {
                        System.out.println("No employee with id " + idGet);
                        break;
                    }

                    displayEmployee(employee);
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
                    System.out.print("Enter name: ");
                    String nameGet = sc.nextLine();

                    getEmployeeByName(nameGet);
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
