package buoi_01;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a: ");
        int a = sc.nextInt();

        System.out.print("Input b: ");
        int b = sc.nextInt();

        System.out.printf("%d + %d  = %d%n", a, b, a + b);
        System.out.printf("%d - %d  = %d%n", a, b, a - b);
        System.out.printf("%d * %d  = %d%n", a, b, a * b);
        System.out.printf("%d / %d  = %.1f", a, b, (float) a / b);

        sc.close();
    }
}
