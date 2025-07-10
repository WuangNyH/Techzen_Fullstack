package buoi_03;

import java.util.Scanner;

import static bai_06.bai_tap_method.Bai02.*;

public class Bai13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();


        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        if (b < a) {
            System.out.print("Số nguyên b phải lớn hơn a");
            return;
        }

        int sumOfPalindrome = 0;
        int sumOfPrime = 0;
        int isPerfectSquare = 0;

        for (int i = a; i <= b; i++) {
            sumOfPalindrome += (isPalindrome(i)) ? i : 0;
            sumOfPrime += (isPrimeNumber(i)) ? i : 0;
            isPerfectSquare += (isPerfectSquare(i)) ? i : 0;
        }

        System.out.println("Tổng của các số đối xứng: " + sumOfPalindrome);
        System.out.println("Tổng của các số nguyên tố: " + sumOfPrime);
        System.out.println("Tổng của các số đối chính phương: " + isPerfectSquare);
    }
}
