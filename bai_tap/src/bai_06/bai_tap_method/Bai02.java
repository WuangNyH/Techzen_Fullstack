package bai_06.bai_tap_method;

import java.util.Scanner;

public class Bai02 {
    public static int reversedNumber(int number) {
        int reversedNumber = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }

        return reversedNumber;
    }

    public static boolean isPalindrome(int number) {
        return number == reversedNumber(number);
    }

    public static boolean isPerfectSquare(int number) {
        double sqrtNumber = Math.sqrt(number);
        return (int) sqrtNumber == sqrtNumber;
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfOddNum(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += (digit % 2 != 0) ? digit : 0;
            number /= 10;
        }
        return sum;
    }

    public static int sumOfPrimeNum(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += (isPrimeNumber(digit)) ? digit : 0;
            number /= 10;
        }
        return sum;
    }

    public static int sumOfPerfectSquare(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += (isPerfectSquare(digit)) ? digit : 0;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        String output = "";

        System.out.printf("Số đảo của %d là %d%n", n, reversedNumber(n));

        output = isPalindrome(n) ? " là số đối xứng" : " không phải là số đối xứng";
        System.out.println(n + output);

        output = isPerfectSquare(n) ? " là số chính quy" : " không phải là số chính quy";
        System.out.println(n + output);

        output = isPrimeNumber(n) ? " là số nguyên tố" : " không phải là số nguyên tố";
        System.out.println(n + output);

        System.out.printf("Tổng các số lẻ từ 1 đến %d = %d%n", n, sumOfOddNum(n));
        System.out.printf("Tổng các số nguyên tố từ 1 đến %d = %d%n", n, sumOfPrimeNum(n));
        System.out.printf("Tổng các số chính phương từ 1 đến %d = %d%n", n, sumOfPerfectSquare(n));
    }
}
