package array_list;

import java.util.ArrayList;
import java.util.Scanner;

//import static array_list.Bai01.nhapDanhSach;

public class Bai02 {
    public static boolean hasEven(ArrayList<Integer> arr) {
        for (int number : arr) {
            if (number % 2 == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> arr = nhapDanhSach(sc);

//        if (hasEven(arr)) {
//            System.out.println("Danh sách chứa số chẵn!");
//        } else {
//            System.out.println("Danh sách không chứa số chẵn!");
//        }
//    }
    }
}
