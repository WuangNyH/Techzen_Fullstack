package buoi_1.sang;

import java.util.Scanner;

public class Student {
    private String fullName;
    private float mathScore;
    private float literatureScore;


    public void input(Scanner sc) {
        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        float math;
        float literature;

        do {
            System.out.print("Enter math score: ");
            math = Float.parseFloat(sc.nextLine());

            if (math < 0 || math > 10) {
                System.out.println("\u001B[31m" + "Invalid math score. Please enter a score between 0 and 10." + "\u001B[0m");
                continue;
            }
            break;
        } while (true);

        do {
            System.out.print("Enter literature score: ");
            literature = Float.parseFloat(sc.nextLine());

            if (literature < 0 || literature > 10) {
                System.out.println("\u001B[31m" + "Invalid literature score. Please enter a score between 0 and 10." +  "\u001B[0m");
                continue;
            }
            break;
        } while (true);

        this.fullName = name;
        this.mathScore = math;
        this.literatureScore = literature;
    }

    public float calculateAverageScore(float mathScore, float literatureScore) {
        return (mathScore + literatureScore) / 2;
    }

    public void output() {
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";
        final String GREEN = "\u001B[32m";
        final String PURPLE = "\u001B[35m";

        System.out.println(CYAN + "Full name: " + this.fullName);
        System.out.printf(YELLOW + "Math score: " + "%.1f\n", this.mathScore);
        System.out.printf(GREEN + "Literature score: " + "%.1f\n", this.literatureScore);
        System.out.printf(PURPLE + "GPA: " + "%.1f\u001B[0m\n", calculateAverageScore(this.mathScore, this.literatureScore));
    }

}
