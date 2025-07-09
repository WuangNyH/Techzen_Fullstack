package bai_06;

import java.util.Scanner;

public class Bai02 {
    public static boolean soNguyenTo(int n) {
        if (n == 0 || n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên: ");
        int n = sc.nextInt();

        String output = soNguyenTo(n) ? " là số nguyên tố" : " không phải là số nguyên tố";
        System.out.println(n + output);
    }
}
