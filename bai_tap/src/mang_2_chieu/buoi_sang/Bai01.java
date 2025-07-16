package mang_2_chieu.buoi_sang;

import java.util.Arrays;
import java.util.Scanner;

import static bai_06.bai_tap_method.Bai02.isPrimeNumber;

public class Bai01 {
    public static int[] findMaxOfRow(int[][] arr) {
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i][0];
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            output[i] = max;
        }

        return output;
    }

    public static void displayArray(int[][] arr) {
        for (int[] row : arr) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void swapRows(int[][] arr, int firstRow, int secondRow) {
        int[] temp = arr[firstRow];
        arr[firstRow] = arr[secondRow];
        arr[secondRow] = temp;
    }

    public static void maxOfCheoChinh(int[][] arr) {
        if (arr.length != arr[0].length) {
            System.out.println("Ma trận không có đường chéo chính! ");
        } else {
            // 2 vòng for
//            int max = arr[0][0];
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    if (i - j == 0) {
//                        max = Math.max(max, arr[i][j]);
//                    }
//                }
//            }
//            System.out.println(max);

            // 1 vòng for
            int max = arr[0][0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][i] > 0) {
                    max = arr[i][i];
                }
            }
            System.out.println(max);
        }
    }

    public static void minOfCheoPhu(int[][] arr) {
        if (arr.length != arr[0].length) {
            System.out.println("Ma trận không có đường chéo phụ! ");
        } else {
            // 2 vòng for
//            int min = arr[0][arr[0].length - 1];
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    if (i + j == arr[i].length - 1) {
//                        min = Math.min(min, arr[i][j]);
//                    }
//                }
//            }
//            System.out.println(min);

            // 1 vòng for
            int min = arr[0][arr[0].length - 1];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][arr.length - 1 - i] < min) {
                    min = arr[i][arr.length - 1 - i];
                }
            }
            System.out.println(min);
        }
    }

    public static void swapColumns(int[][] arr, int firstColumn, int secondColumn) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i][firstColumn];
            arr[i][firstColumn] = arr[i][secondColumn];
            arr[i][secondColumn] = temp;
        }
    }

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

        // Câu a
        System.out.println("Câu a: ");
        displayArray(arr);

        // Câu b
        int mulB = 1;

        int[] firstRow = arr[0];
        for (int num : firstRow) {
            if (num % 3 == 0) {
                mulB *= num;
            }
        }
        System.out.println("Câu b: ");
        System.out.println(mulB);

        // Câu c
        System.out.println("Câu c: ");
        System.out.println(Arrays.toString(findMaxOfRow(arr)));

        // Câu d
        int sum = 0;

        int[] lastRow = arr[arr.length - 1];
        for (int num : lastRow) {
            if (num % 5 == 0) {
                sum += num;
            }
        }
        System.out.println("Câu d: ");
        System.out.println(sum);

        // Câu e
        System.out.println("Câu e: ");
        maxOfCheoChinh(arr);


        // Câu f
        System.out.println("Câu f: ");
        minOfCheoPhu(arr);

        // Câu g
        System.out.println("Câu g: ");
        int countPrimes = 0;
        for (int[] array : arr) {
            for (int number : array) {
                if (isPrimeNumber(number)) {
                    countPrimes++;
                }
            }
        }

        System.out.println(countPrimes);

        // Câu h
        System.out.println("Câu h: ");
        swapRows(arr, 0, 1);
        displayArray(arr);

        // Câu i
        System.out.println("Câu i: ");
        swapColumns(arr, 0, 1);
        displayArray(arr);
    }
}
