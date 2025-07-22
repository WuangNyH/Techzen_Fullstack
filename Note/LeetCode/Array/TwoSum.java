package LeetCode.Array;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int P = 21 * a + 5  * b  - 2009;
        double Q = (21 * Math.pow(a, 2) - 5 * b) / (2009 * Math.pow(b, 2));
        double R = (21 * a + 5 * Math.pow(b, 2)) / (2009 * b + 15);

        System.out.printf("%d %.4f\n%.6f", P, Q, R);
    }
}