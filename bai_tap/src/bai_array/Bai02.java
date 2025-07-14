package bai_array;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = new int[soPhanTu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        // Bài 02
        for (int phanTu : arr) {
            if (phanTu % 2 != 0) {
                System.out.print("Mảng có số lẻ!");
                return;
            }
        }

        System.out.println("Mảng toàn số chẵn");
    }
}
