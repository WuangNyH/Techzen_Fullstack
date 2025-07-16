package mang_2_chieu;

import java.util.Arrays;
import java.util.Scanner;

public class Bai03 {
//    public static int[] findMaxOfRow(int[][] arr) {
//        int[] output = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            int max = arr[i][0];
//            for (int j = 1; j < arr[i].length; j++) {
//                if (arr[i][j] > max) {
//                    max = arr[i][j];
//                }
//            }
//            output[i] = max;
//        }
//
//        return output;
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

//        System.out.println(Arrays.toString(findMaxOfRow(arr)));
    }
}
