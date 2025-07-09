package bai_06.bai_tap_vong_lap;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        // Cách 1
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        System.out.println();

        // Cách 2
        for (int i = 1; i <= n; i += 2) {
            System.out.println(i);
        }
    }
}
