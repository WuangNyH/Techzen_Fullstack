package bai_array;

import java.util.Arrays;
import java.util.Scanner;

public class Bai06 {
    public static int[] remove(int[] arr, int index) {
        int newIndex = 0;
        int [] newArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[newIndex++] = arr[i];
            }
        }

        return newArr;
    }

    public static int[] add(int[] arr, int index, int value) {
        int count = 0;
        int [] newArr = new int[arr.length + 1];

        for (int i = 0; i < newArr.length; i++) {
            if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = arr[count++];
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = new int[soPhanTu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        System.out.print("Nhập index cần xóa: ");
        int removeIndex = sc.nextInt();

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(remove(arr, removeIndex)));

        System.out.print("Nhập index muốn thêm: ");
        int addIndex = sc.nextInt();

        System.out.print("Nhập value: ");
        int value = sc.nextInt();

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(add(arr, addIndex, value)));
    }
}
