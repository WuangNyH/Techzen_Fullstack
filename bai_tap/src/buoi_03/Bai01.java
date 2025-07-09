package buoi_03;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        for (int i = 2; i <= n; i += 2) {
            System.out.println(i % 4 == 0 ? -i : i);
        }
    }
}
