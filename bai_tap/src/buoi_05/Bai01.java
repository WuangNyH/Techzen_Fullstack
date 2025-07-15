package buoi_05;

import static buoi_05.bai01_class.Bai01.validateData;

import java.util.Scanner;

public class Bai01 {
    public static void displayMenu() {
        System.out.println(">> FUNCTION SELECTION <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Find employee (by ID)                    |");
        System.out.println("| 2. Sort employees by ascending age          |");
        System.out.println("| 3. Display employee list                    |");
        System.out.println("| 4. Exit program                             |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static String createEmployee(Scanner sc, int id, int[] ids, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
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

        ids[id - 1] = id;
        fullNames[id - 1] = name;
        ages[id - 1] = age;
        genders[id - 1] = gender;
        salaries[id - 1] = salary;
        gpas[id - 1] = gpa;

        return String.format("Successfully import employee with ID is %d.", id);
    }

    public static void getEmployeById(int id, int[] ids, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        boolean found = false;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id) {
                System.out.println("++ ----------------------------------------- ++");
                displayEmployee(i, ids, fullNames, ages, genders, salaries, gpas);
                System.out.println("++ ----------------------------------------- ++\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Error: Employee ID does not exist.\n");
        }
    }

    public static void getListEmployees(int[] ids, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        for (int id : ids) {
            getEmployeById(id, ids, fullNames, ages, genders, salaries, gpas);
        }
    }

    public static void displayEmployee(int index, int[] ids, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        System.out.println("ID: " + ids[index]);
        System.out.println("Fullname: " + fullNames[index]);
        System.out.println("Age: " + ages[index]);
        System.out.println("Gender: " + genders[index]);
        System.out.println("Salary: " + String.format("%,.0fVND", salaries[index]));
        System.out.println("GPA: " + String.format("%.1f", gpas[index]));
    }

    public static void sortListByAge(int[] ids, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        int temp;
        String tempString;
        double tempDouble;

        for (int i = 0 ; i < ages.length - 1; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (ages[i] > ages[j]) {
                    // Swap id
                    temp = ids[j];
                    ids[j] = ids[i];
                    ids[i] = temp;

                    // Swap fullName
                    tempString = fullNames[j];
                    fullNames[j] = fullNames[i];
                    fullNames[i] = tempString;

                    // Swap age
                    temp = ages[j];
                    ages[j] = ages[i];
                    ages[i] = temp;

                    // Swap gender
                    tempString = genders[j];
                    genders[j] = genders[i];
                    genders[i] = tempString;

                    // Swap salary
                    tempDouble = salaries[j];
                    salaries[j] = salaries[i];
                    salaries[i] = tempDouble;

                    // Swap GPA
                    tempDouble = gpas[j];
                    gpas[j] = gpas[i];
                    gpas[i] = tempDouble;
                }
            }
        }
        System.out.println("Sorting successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int newId = 1;

        System.out.print("Number of employees to add: ");
        int num = Integer.parseInt(sc.nextLine());

        int[] ids = new int[num];
        String[] fullNames = new String[num];
        int[] ages = new int[num];
        String[] genders = new String[num];
        double[] salaries = new double[num];
        double[] gpas = new double[num];

        for (int i = 0; i < num; i++) {
            while (true) {
                System.out.println("\nImport info of employee with ID " + newId);
                String output = createEmployee(sc, newId, ids, fullNames, ages, genders, salaries, gpas);
                if  (output == null) continue;
                System.out.println(output);
                newId++;
                break;
            }
        }

        while (true) {
            displayMenu();
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    getEmployeById(id, ids, fullNames, ages, genders, salaries, gpas);
                    break;
                case 2:
                    if (ids.length == 0) {
                        System.out.println("Employee list is empty.\n");
                        break;
                    }
                    sortListByAge(ids, fullNames, ages, genders, salaries, gpas);
                    break;
                case 3:
                    if (ids.length == 0) {
                        System.out.println("Employee list is empty.\n");
                        break;
                    }
                    getListEmployees(ids, fullNames, ages, genders, salaries, gpas);
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
