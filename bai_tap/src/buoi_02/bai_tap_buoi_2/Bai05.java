package buoi_02.bai_tap_buoi_2;

import java.util.Scanner;

public class Bai05 {
    public static void giaiPTBac1(int a, int b) {
        if (a == 0) {
            System.out.println(b == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
        } else {
            float x = (float) -b / a;
            System.out.printf("Phương trình có một nghiệm x = %.1f", x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        giaiPTBac1(a, b);
    }
}
