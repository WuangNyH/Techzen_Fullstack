package bai_array;

import java.util.Arrays;
import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = new int[soPhanTu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        System.out.print(Arrays.toString(arr));
    }
}
