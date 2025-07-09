package buoi_03;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Nhập số nguyên dương!");
            return;
        }

        int firstNum = 1;

        while (firstNum <= n) {
            System.out.print(firstNum + " ");
            firstNum = firstNum * 2 + 1;
        }
    }
}
