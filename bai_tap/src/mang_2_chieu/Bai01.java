package mang_2_chieu;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number of row: ");
        int row = sc.nextInt();

        System.out.print("Input number of column: ");
        int column = sc.nextInt();

        int[][] arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("Enter element [%d][%d]: ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int[] array : arr) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
