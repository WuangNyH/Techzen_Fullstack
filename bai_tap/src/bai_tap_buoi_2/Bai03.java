package bai_tap_buoi_2;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập biến a: ");
        int a = sc.nextInt();

        System.out.print("Nhập biến b: ");
        int b = sc.nextInt();

        // Cách 1
        System.out.println("===Cách 1=== ");
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Cách 2 (không sử dụng biến tạm)
        System.out.println("===Cách 2=== ");
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
