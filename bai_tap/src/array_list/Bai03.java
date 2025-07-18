package array_list;

import java.util.ArrayList;
import java.util.Scanner;

//import static array_list.Bai01.nhapDanhSach;

public class Bai03 {
    public static int[] sumAndMax(ArrayList<Integer> arr) {
        int sum = 0;
        int max = arr.get(0);

        for (int number : arr) {
            sum += number;

            if (number > max) {
                max = number;
            }
        }

        return new int[]{sum, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> arr = nhapDanhSach(sc);
//
//        if (arr.isEmpty()) {
//            System.out.println("Danh sách rỗng!");
//            return;
//        }
//
//        int[] sumAndMax = sumAndMax(arr);
//
//        System.out.println("Tổng của danh sách: " + sumAndMax[0]);
//        System.out.println("Số lớn nhất trong mảng: " + sumAndMax[1]);
    }
}
