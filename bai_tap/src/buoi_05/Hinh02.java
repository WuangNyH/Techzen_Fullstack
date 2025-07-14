package buoi_05;

import bai_06.bai_tap_method.Bai02;

import java.util.Arrays;

import static bai_06.bai_tap_method.Bai02.isPrimeNumber;

public class Hinh02 {
    public static int[] primeToZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrimeNumber(arr[i])) arr[i] = 0;
        }
        return arr;
    }

    public static int[] chenSoKhong(int[] arr) {
        int primeCount = 0;
        for (int num : arr) {
            if (isPrimeNumber(num)) primeCount++;
        }

        int[] newArr = new int[arr.length + primeCount];

        int newIndex = 0;
        for (int num : arr) {
            newArr[newIndex++] = num;
            if (Bai02.isPrimeNumber(num)) {
                newArr[newIndex++] = 0;
            }
        }

        return newArr;
    }

    public static int[] xoaPhanThu(int[] arr) {}

    public static void main(String[] args) {
        // Câu a
        int[] arrA = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(primeToZero(arrA)));

        // Câu b
        int[] arrB = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(chenSoKhong(arrB)));
    }
}
