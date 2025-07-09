package bai_06;

import java.util.Scanner;

public class Bai01 {
    public static int giaiThua(int n) {
        int giaiThua = 1;
        for (int i = 1; i <= n; i++) {
            giaiThua *= i;
        }
        return giaiThua;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên: ");
        int n = sc.nextInt();

        int giaiThua = giaiThua(n);
        System.out.printf("Giai thừa của %d bằng %d", n, giaiThua);
    }
}
