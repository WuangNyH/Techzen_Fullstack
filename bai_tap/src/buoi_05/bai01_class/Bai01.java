package buoi_05.bai01_class;

import java.util.*;

public class Bai01 {
    public static String validateData(int age, String gender, double salary, float gpa, String fullName) {
        StringBuilder errors = new StringBuilder();

        if (fullName.isEmpty()) {
            errors.append("Fullname cannot be empty\n");
        }

        if (age < 18 || age > 100) {
            errors.append("Age must be between 18 and 100.\n");
        }

        if (!(gender.equals("Male") || gender.equals("Female"))) {
            errors.append("Gender must be either 'Male' or 'Female'.\n");
        }

        if (salary <= 0) {
            errors.append("Salary must be greater than 0.\n");
        }

        if (gpa < 0 || gpa > 4) {
            errors.append("GPA must be between 0 and 4.\n");
        }

        return errors.toString();
    }

    public static void displayMenu() {
        System.out.println(">> FUNCTION SELECTION <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Add employee                             |");
        System.out.println("| 2. Find employee (by ID)                    |");
        System.out.println("| 3. Sort employees by ascending age          |");
        System.out.println("| 4. Display employee list                    |");
        System.out.println("| 5. Exit program                             |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static Employee createEmployee(Scanner sc, int id) {
        System.out.print("Enter Fullname: ");
        String name = sc.nextLine();

        System.out.print("Enter Age (18 - 100): ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Gender (Male/Female): ");
        String gender = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.print("Enter GPA (0-4): ");
        float gpa = Float.parseFloat(sc.nextLine());

        String errors = validateData(age, gender, salary, gpa, name);

        if (!errors.isEmpty()) {
            System.out.println("Error: " + errors);
            return null;
        }

        return new Employee(id, name, age, gender, salary, gpa);
    }

    public static void getListEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("++ ----------------------------------------- ++");
            System.out.println(employee);
            System.out.println("++ ----------------------------------------- ++\n");
        }
    }

    public static void getEmployeeById(int id, List<Employee> employees) {
        boolean found = false;

        for (Employee employee : employees) {
            if (id == employee.getId()) {
                System.out.println("++ ----------------------------------------- ++");
                System.out.println(employee);
                System.out.println("++ ----------------------------------------- ++\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Error: Employee ID does not exist.\n");
        }
    }

    public static void sortListByAge(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Employee list is empty.\n");
        } else {
            for (int i = 0; i < employees.size() - 1; i++) {
                for (int j = i + 1; j < employees.size(); j++) {
                    if (employees.get(i).getAge() > employees.get(j).getAge()) {
                        Collections.swap(employees, i, j);
                    }
                }
            }
            System.out.println("Sorting successful.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        int newId = 1;

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
                            System.out.println("\nImport info of employee with ID " + newId);
                            Employee newEmployee = createEmployee(sc, newId);

                            if (newEmployee == null) continue;
                            employees.add(newEmployee);
                            newId++;
                            break;
                        }
                    }
                    System.out.println(num == 1 ? "Successfully import 1 employee." : String.format("Successfully import %d employees.", num));
                    break;
                case 2:
                    System.out.print("Enter employee ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    getEmployeeById(id, employees);
                    break;
                case 3:
                    sortListByAge(employees);
                    break;
                case 4:
                    if (employees.isEmpty()) {
                        System.out.println("Employee list is empty.\n");
                        break;
                    }
                    getListEmployees(employees);
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
