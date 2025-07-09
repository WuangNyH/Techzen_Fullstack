package bai_06.bai_tap_vong_lap;

import java.util.Scanner;

public class Bai04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        for (int i = 2; i <= 2*n; i += 2) {
            System.out.print(i + " ");
        }
    }
}
