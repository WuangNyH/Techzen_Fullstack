package bai_06.bai_tap_vong_lap;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int temp = -1;

        // Cách 1
        for (int i = 2; i <= n; i += 2) {
            if (temp < 0) {
                temp = i;
                System.out.print(i + " ");
            } else {
                temp = -i;
                System.out.print(-i + " ");
            }
        }

        System.out.println();

        // Cách 2
        for (int i = 2; i <= n; i += 2) {
            System.out.print(i % 4 == 0 ? -i + " " : i + " ");
        }
    }
}
