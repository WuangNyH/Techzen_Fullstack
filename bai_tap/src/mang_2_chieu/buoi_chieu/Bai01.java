package mang_2_chieu.buoi_chieu;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = {
                {1, 2, 5, -6},
                {3, -4, 7, 8},
                {5, -6, 3, -6}
        };

        System.out.print("Enter the size of the square: ");
        int k = sc.nextInt();

        long max = Long.MIN_VALUE;
        int[] coorMax = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j + k - 1 < arr[i].length && i + k - 1 < arr.length) {
                    int sum = 0;
                    for (int x = i; x <= i + k - 1; x++) {
                        for (int y = j; y <= j + k - 1; y++) {
                            sum += arr[x][y];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                        coorMax[0] = i;
                        coorMax[1] = j;
                    }
                }
            }
        }

        System.out.println(max);
        System.out.println(coorMax[0] + " " + coorMax[1]);

    }
}
