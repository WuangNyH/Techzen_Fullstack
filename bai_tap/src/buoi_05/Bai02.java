package buoi_05;

import java.util.Arrays;
import java.util.Scanner;

public class Bai02 {
    public static void displayMenu() {
        System.out.println(">> FUNCTION SELECTION <<");
        System.out.println("++ --------------------------------------------------- ++");
        System.out.println("| 1. Print score table                                  |");
        System.out.println("| 2. Student with highest average score                 |");
        System.out.println("| 3. Sort students by average score in descending order |");
        System.out.println("| 4. Exit program                                       |");
        System.out.println("++ --------------------------------------------------- ++");
    }

    public static String validateData(float mathScore, float englishScore, float itScore) {
        StringBuilder errors = new StringBuilder();

        if (mathScore < 0 || englishScore < 0 || itScore < 0) {
            errors.append("ERROR: Scores cant't be negative.\n");
        }

        if (mathScore > 10 || englishScore > 10 || itScore > 10) {
            errors.append("ERROR: Scores cant't be greater than 10.\n");
        }

        return errors.toString();
    }

    public static String createStudent(int index, String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages, Scanner sc) {
        System.out.print("Enter Fullname: ");
        String name = sc.nextLine();

        System.out.print("Enter math score: ");
        float mathScore = Float.parseFloat(sc.nextLine());

        System.out.print("Enter english score: ");
        float englishScore = Float.parseFloat(sc.nextLine());

        System.out.print("Enter it score: ");
        float itScore = Float.parseFloat(sc.nextLine());

        String errors = validateData(mathScore, englishScore, itScore);

        if (!errors.isEmpty()) {
            System.out.println("Error: " + errors);
            return null;
        }

        fullNames[index] = name;
        mathScores[index] = mathScore;
        englishScores[index] = englishScore;
        itScores[index] = itScore;

        float avarageScore = (mathScore + englishScore + itScore) / 3;
        avarages[index] = avarageScore;

        return String.format("Successfully import student %d.", index + 1);
    }

    public static void getListStudent(String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages) {
        if (fullNames.length == 0) {
            System.out.println("No student data found.");
            return;
        }

        for (int i = 0; i < fullNames.length; i++) {
            System.out.println("++ ----------------------------------------- ++");
            displayStudent(i, fullNames,  mathScores, englishScores, itScores, avarages);
            System.out.println("++ ----------------------------------------- ++\n");
        }
    }

    public static void getStudentHighestAvr(String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages) {
        if (fullNames.length == 0) {
            System.out.println("No student data found.");
            return;
        }

        float maxAvg = avarages[0];

        for (int i = 1; i < avarages.length; i++) {
            if (avarages[i] > maxAvg) {
                maxAvg = avarages[i];
            }
        }

        for (int i = 0; i < fullNames.length; i++) {
            if (avarages[i] == maxAvg) {
                System.out.println("++ ----------------------------------------- ++");
                displayStudent(i, fullNames,  mathScores, englishScores, itScores, avarages);
                System.out.println("++ ----------------------------------------- ++\n");
            }
        }
    }

    public static void displayStudent(int index, String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages) {
        System.out.println("Fullname: " + fullNames[index]);
        System.out.printf("Math score: %.1f\n", mathScores[index]);
        System.out.printf("English score: %.1f\n", englishScores[index]);
        System.out.printf("It score: %.1f\n", itScores[index]);
        System.out.printf("Avarage: %.1f\n", avarages[index]);
    }

    public static void sortStudentByAvr(String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages) {
        if (fullNames.length == 0) {
            System.out.println("No student data found.");
            return;
        }

        String tempString;
        float tempFloat;

        for (int i = 0; i < fullNames.length - 1; i++) {
            for (int j = i + 1; j < fullNames.length; j++) {
                if (avarages[i] < avarages[j]) {
                    // Swap fullNames
                    tempString = fullNames[i];
                    fullNames[i] = fullNames[j];
                    fullNames[j] = tempString;

                    // Swap Math scores
                    tempFloat = mathScores[i];
                    mathScores[i] = mathScores[j];
                    mathScores[j] = tempFloat;

                    // Swap English scores
                    tempFloat = englishScores[i];
                    englishScores[i] = englishScores[j];
                    englishScores[j] = tempFloat;

                    // Swap IT score
                    tempFloat = itScores[i];
                    itScores[i] = itScores[j];
                    itScores[j] = tempFloat;

                    // Swap Average score
                    tempFloat = avarages[i];
                    avarages[i] = avarages[j];
                    avarages[j] = tempFloat;
                }
            }
        }
        System.out.println("Sorting successful!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of students to add: ");
        int num = Integer.parseInt(sc.nextLine());

        String[] fullNames = new String[num];
        float[] mathScores = new float[num];
        float[] englishScores = new float[num];
        float[] itScores = new float[num];
        float[] avarages = new float[num];

        for (int i = 0; i < num; i++) {
            while (true) {
                System.out.println("\nImport score of student " + (i + 1));
                String output = createStudent(i, fullNames, mathScores, englishScores, itScores, avarages, sc);
                if (output == null) continue;
                System.out.println(output);
                break;
            }
        }

        while (true) {
            displayMenu();
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    getListStudent(fullNames, mathScores, englishScores, itScores, avarages);
                    break;
                case 2:
                    getStudentHighestAvr(fullNames, mathScores, englishScores, itScores, avarages);
                    break;
                case 3:
                    sortStudentByAvr(fullNames, mathScores, englishScores, itScores, avarages);
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
