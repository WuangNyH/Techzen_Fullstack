package bai_05;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int temp = n;

        int sum = 0;
        while (temp > 0) {
            sum += temp % 2 == 0 ? temp : 0;
            temp--;
        }

        System.out.printf("Tổng các số chẳn từ 1 đến %d = %d", n, sum);
    }
}
