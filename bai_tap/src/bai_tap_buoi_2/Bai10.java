package bai_tap_buoi_2;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một số nguyên: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Vui lòng nhập số nguyên dương!");
            return;
        }

        double sqrtNumber =  Math.sqrt(number);

        // Cách 1
        String output = sqrtNumber % 1 == 0 ? " là số chính nguyên" : " không phải là số chính nguyên";
        System.out.println(number + output);

        // Cách 2
        System.out.println(sqrtNumber);
        System.out.println((int) sqrtNumber);
        String output2 =  (sqrtNumber == (int) sqrtNumber) ? " là số chính nguyên" : " không phải là số chính nguyên";
        System.out.println(number + output2);
    }
}
