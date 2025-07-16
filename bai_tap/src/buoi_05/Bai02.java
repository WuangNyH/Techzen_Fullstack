package buoi_05;

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

//    public static String
//
//    public static String validateData(float mathScore, float englishScore, float itScore) {
//        StringBuilder errors = new StringBuilder();
//
//
//        return errors.toString();
//    }

    public static void createStudent(String[] fullNames, float[] mathScores, float[] englishScores, float[] itScores, float[] avarages, Scanner sc) {
        System.out.print("Enter Fullname: ");
        String name = sc.nextLine();

        System.out.print("Enter math score: ");
        float mathScore = Float.parseFloat(sc.nextLine());

        System.out.print("Enter english score: ");
        float englishScore = Float.parseFloat(sc.nextLine());

        System.out.print("Enter it score: ");
        float itScore = Float.parseFloat(sc.nextLine());
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


    }
}
