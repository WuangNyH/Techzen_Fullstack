package buoi_1.chieu;

import java.util.Scanner;

public class MainPoint {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter point #1");
        Point p1 = new Point();
        p1.input(sc);

        System.out.println("Enter point #2");
        Point p2 = new Point();
        p2.input(sc);

        System.out.printf("Distance between (%d, %d) and (%d, %d) is %.2f%n", p1.x, p1.y, p2.x, p2.y, p1.distance(p2));
    }
}
