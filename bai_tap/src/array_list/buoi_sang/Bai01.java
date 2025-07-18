package array_list.buoi_sang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai01 {
    static Scanner sc = new Scanner(System.in);

    public static ArrayList<Integer> nhapDanhSach() {
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Nhập số lượng phần thử: ");
        int soPhanTu = sc.nextInt();

        for (int i = 0; i < soPhanTu; i++) {
            System.out.printf("Nhập phần thử thứ %d: ", i + 1);
            arr.add(sc.nextInt());
        }

        return arr;
    }

    public static long countOdd(ArrayList<Integer> arr) {
//        int count = 0;
//        for (int number : arr) {
//            if (number % 2 != 0) {
//                count++;
//            }
//        }

        return arr.stream().filter(x -> x % 2 != 0).count();
    }

    public static int sumOddPositive(ArrayList<Integer> arr) {
//        int sum = 0;
//        for (int number : arr) {
//            if (number > 0 && number % 2 != 0) {
//                sum += number;
//            }
//        }

        return arr.stream().filter(x -> x > 0 && x % 2 != 0).mapToInt(Integer::intValue).sum();
    }

    public static ArrayList<Integer> findIndexOfValue(int value, ArrayList<Integer> arr) {
        ArrayList<Integer> arrIndex = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == value) {
                arrIndex.add(i);
            }
        }

        return arrIndex;
    }

    public static void main(String[] args) {
        // Câu a
        ArrayList<Integer> arr = nhapDanhSach();

        // Câu b
        System.out.println("Câu b: ");
        System.out.println(arr);

        // Câu c:
        System.out.println("\nCâu c: ");
        System.out.println("Number of odd elements in the list: " + countOdd(arr));


        // Câu d
        System.out.println("\nCâu d: ");
        System.out.println("Sum of positive odd elements in the list: " + sumOddPositive(arr));

        // Câu e
        System.out.println("\nCâu e: ");
        System.out.print("Enter number: ");
        int k = sc.nextInt();

        ArrayList<Integer> arrIndex = findIndexOfValue(k, arr);

        if (arrIndex.isEmpty()) {
            System.out.println("Not Found!");
        } else {
            System.out.printf("Index of %d in list: %s\n", k, arrIndex);
        }

        // Câu f
        System.out.println("\nCâu f: ");
        Collections.sort(arr);
        System.out.println("List after sort: " + arr);

        // Câu g
        System.out.println("\nCâu g: ");
        Collections.reverse(arr);
        System.out.println("List after reverse: " + arr);

        // Câu h
        System.out.println("\nCâu h: ");
        System.out.print("Enter number: ");
        int r = sc.nextInt();

        arr.removeIf(n -> n == r);
        System.out.println("List after remove: " + arr);

        // Câu i
        System.out.println("\nCâu i: ");
        System.out.print("Enter index: ");
        int idx = sc.nextInt();

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        if (idx > arr.size()) {
            System.out.println("Index out of bound!");
        } else {
            arr.add(idx, value);
            System.out.println("List after add: " + arr);
        }

        // Câu j
        System.out.println("\nCâu j: ");
        System.out.println("Max of list: " + Collections.max(arr));
        System.out.println("Min of list: " + Collections.min(arr));

        // Câu k
        System.out.println("\nCâu k: ");
        Collections.sort(arr);

        if (arr.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Gía trị lớn nhì của danh sách: " + arr.get(arr.size() - 2));
        }
    }
}
