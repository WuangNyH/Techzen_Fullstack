package buoi_03;

import bai_06.Bai01;

import java.util.Scanner;

public class Bai05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        double sum = 0;

        if (n < 0) {
            System.out.println("Nhập số nguyên dương!");
            return;
        }

        for (int i = 1; i <= n; i++) {
            sum += (double) 1 / Bai01.giaiThua(2 * i - 1);
        }

        System.out.println(sum);
    }
}
