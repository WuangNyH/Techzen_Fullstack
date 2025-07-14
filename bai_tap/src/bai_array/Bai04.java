package bai_array;

import java.util.Scanner;

public class Bai04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = new int[soPhanTu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        // Bài 04
        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();
        int output = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                output = i;
            }
        }

        System.out.printf("Vị trí cuối cùng của %d ở ví trị %d", x, output);
    }
}
