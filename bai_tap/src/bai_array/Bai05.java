package bai_array;

import bai_06.bai_tap_method.Bai02;

import java.util.Arrays;
import java.util.Scanner;

public class Bai05 {

    public static int[] chenSoKhong(int[] arr) {
        int primeCount = 0;
        for (int num : arr) {
            if (Bai02.isPrimeNumber(num)) primeCount++;
        }

        int[] newArr = new int[arr.length + primeCount];

        int newIndex = 0;
        for (int num : arr) {
            newArr[newIndex++] = num;
            if (Bai02.isPrimeNumber(num)) {
                newArr[newIndex++] = 0;
            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            if (Bai02.isPrimeNumber(arr[i])) {
//                arr[i] *= 10;
//            }
//        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = new int[soPhanTu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(chenSoKhong(arr)));
    }
}
