package mang_2_chieu;

import java.util.Arrays;
import java.util.Scanner;

public class Bai04 {
//    public static int[][] swapRows(int[][] arr, int firstRow, int secondRow) {
//        int[] temp = arr[firstRow];
//        arr[firstRow] = arr[secondRow];
//        arr[secondRow] = temp;
//        return arr;
//    }

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

//        System.out.println(Arrays.deepToString(swapRows(arr, 0, 1)));
    }
}
