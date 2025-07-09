package bai_06;

import java.util.Scanner;

public class Bai03 {
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: ");
        int a = sc.nextInt();

        System.out.print("Nhập b: ");
        int b = sc.nextInt();

        System.out.println("Số lớn nhất là: " + max(a, b));
    }
}
