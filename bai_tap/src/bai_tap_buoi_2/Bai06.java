package bai_tap_buoi_2;

import java.util.Scanner;

public class Bai06 {
    public static void giaiPTBac2(int a, int b, int c) {
        if (a == 0) {
            Bai05.giaiPTBac1(b, c);
        } else {
            int delta = b*b - 4*a*c;
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm");
            } else if (delta == 0) {
                float x = (float) -b / (2*a);
                System.out.printf("Phương trình có nghiệm kép x1 = x2 = %.1f", x);
            } else {
                double sqrtDelta = Math.sqrt(delta);
                double x1 = (-b + sqrtDelta) / (2 * a);
                double x2 = (-b - sqrtDelta) / (2 * a);
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.printf("x1 = %.1f%n", x1);
                System.out.printf("x2 = %.1f", x2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        System.out.print("Nhập số nguyên c: ");
        int c = sc.nextInt();

        giaiPTBac2(a, b, c);
        sc.close();
    }
}
