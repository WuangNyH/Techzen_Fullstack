package buoi_1.chieu;

import java.util.Scanner;

public class Point {
    public int x;
    public int y;

    public void input(Scanner sc) {
        while (true) {
            System.out.print("Enter x: ");
            if (sc.hasNextInt()) {
                this.x = sc.nextInt();
                sc.nextLine();
                break;
            }
            System.out.println("Invalid x. Please try again. (Integer)!");
            sc.nextLine();
        }

        while (true) {
            System.out.print("Enter y: ");
            if (sc.hasNextInt()) {
                this.y = sc.nextInt();
                sc.nextLine();
                break;
            }
            System.out.println("Invalid y. Please try again. (Integer)!");
            sc.nextLine();
        }
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
}
