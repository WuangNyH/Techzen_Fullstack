package mang_2_chieu;

import java.util.Scanner;

public class Bai02 {
    public static boolean checkAllEven(int[][] arr) {
        for (int[] array : arr) {
            for (int num : array) {
                if (num % 2 != 0) return false;
            }
        }
        return true;
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

        if (checkAllEven(arr)) {
            System.out.println("All even number");
        }  else {
            System.out.println("Not all even number");
        }
    }
}
