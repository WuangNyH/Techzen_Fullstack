package mang_2_chieu.buoi_chieu;

import static mang_2_chieu.buoi_sang.Bai01.displayArray;

public class Bai02 {

    public static int[][] rotateMatrix90(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                newMatrix[row][col++] = matrix[j][i];
                if (col == matrix.length) {
                    col = 0;
                    row++;
                }
            }
        }

        return newMatrix;
    }

    public static void rotateMatrix90v2(int[][] matrix) {
        for  (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        for (int[] array : matrix) {
            reverseArray(array);
        }
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 1, 2, 3},
                {4, 5, 6, 7}
        };


        displayArray(rotateMatrix90(arr));
        rotateMatrix90v2(arr);
        displayArray(arr);
    }
}
