package array_list;

import java.util.ArrayList;
import java.util.Scanner;

//import static array_list.Bai01.nhapDanhSach;

public class Bai04 {
    public static void sortList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> arr = nhapDanhSach(sc);

//        System.out.println("Danh sách trước khi sắp xếp: " + arr);
//        sortList(arr);
//        System.out.println("Danh sách sau khi sắp xếp: " + arr);
    }
}
