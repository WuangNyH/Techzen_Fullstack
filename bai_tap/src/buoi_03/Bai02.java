package buoi_03;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Nhập số nguyên dương!");
            return;
        }

        int firstNum = 0;
        int secondNum = 1;

        while (firstNum <= n) {
            System.out.print(firstNum + " ");
            int thirdNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = thirdNum;
        }
    }
}
