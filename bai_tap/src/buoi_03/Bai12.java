package buoi_03;

import java.util.Scanner;

import static bai_06.bai_tap_method.Bai02.*;

public class Bai12 {
    public static boolean isIncreasingNumber(int number) {
        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;
            if (lastDigit != (number % 10) + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        String output;

        System.out.print("Nhập một số nguyên bất kỳ: ");

        if (sc.hasNextInt()) {
            number = sc.nextInt();
        } else {
            System.out.println("Dữ liệu nhập vào không phải là số nguyên dương");
            return;
        }

        if (number < 0) {
            System.out.println("Dữ liệu nhập vào phải là số nguyên nhỏ hơn 0");
            return;
        }

        output = isPalindrome(number) ? " là số đối xứng" : " không phải là số đối xứng";
        System.out.println(number + output);

        output = isPrimeNumber(number) ? " là số nguyên tố" : " không phải là số nguyên tố";
        System.out.println(number + output);

        output = isIncreasingNumber(number) ? " là số tăng dần" : " không phải là số tăng dần";
        System.out.println(number + output);
    }
}
