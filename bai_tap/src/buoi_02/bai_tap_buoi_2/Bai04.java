package buoi_02.bai_tap_buoi_2;

import java.util.Scanner;

public class Bai04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        int max = 0;
        int min = 0;

        // Cách 1
        System.out.println("===Cách 1===");
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        System.out.println("Số lớn nhất là " + max);
        System.out.println("Số nhỏ nhất là " + min);

        // Cách 2
        System.out.println("===Cách 2===");
        max = Math.max(a, b);
        min = Math.min(a, b);
        System.out.println("Số lớn nhất là " + max);
        System.out.println("Số nhỏ nhất là " + min);

        // Cách 3
        System.out.println("===Cách 3===");
        max = (a > b) ? a : b;
        min = (a > b) ? b : a;
        System.out.println("Số lớn nhất là " + max);
        System.out.println("Số nhỏ nhất là " + min);
    }
}
