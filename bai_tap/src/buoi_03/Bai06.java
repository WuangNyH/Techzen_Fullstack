package buoi_03;

import java.util.Scanner;

public class Bai06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chữ số nguyên: ");
        int n = sc.nextInt();
        int sum = 0;
        int mul = 1;

        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            mul *= digit;
            n /= 10;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Mul: " + mul);
    }
}
