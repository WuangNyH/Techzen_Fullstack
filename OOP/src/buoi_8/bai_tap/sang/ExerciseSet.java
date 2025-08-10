package buoi_8.bai_tap.sang;

import java.util.*;

public class ExerciseSet {
    private static HashSet<Integer> removeDuplicates(Integer[] arr) {
//        return new HashSet<>(Arrays.asList(arr));
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set, arr);
        return set;
    }

    private static int sumOfUniqueElements(Integer[] arr) {
        if (arr == null) return 0;
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        for (Integer num : arr) {
            if (seen.add(num)) {
                sum += num;
            }
        }
        return sum;
    }

    private static void commonElements(Integer[] list, Integer[] list2) {
        if (list == null || list2 == null || list.length == 0 || list2.length == 0) {
            System.out.println("Không có phần tử chung!");
            return;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        Collections.addAll(hashSet, list);

        if (hashSet.retainAll(Arrays.asList(list2))) {
            System.out.println(hashSet);
        } else {
            System.out.println("Không có phần tử chung!");
        }
    }

    private static void findMinMax(Integer[] list) {
        if (list == null || list.length == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(list));
        System.out.println("Min: " + treeSet.first());
        System.out.println("Max: " + treeSet.last());
    }


    public static void main(String[] args) {
        // Bài a
        Integer[] list = {1, 2, 3};
//        Integer[] list = {1, 2, 3, 3, 5, 4, 5, 6, 6, 6, 10, 10};

        System.out.println("Câu a");
        System.out.println(removeDuplicates(list));

        // Bài b
        System.out.println("\nCâu b");
        System.out.println(sumOfUniqueElements(list));

        // Câu c
        System.out.println("\nCâu c");
        Integer[] list2 = {7, 12, 12, 14};
//        Integer[] list2 = {1, 2, 3, 3, 6, 6, 10, 10, 7, 12, 12, 14};
        System.out.println(">>> Mảng 1: " + removeDuplicates(list));
        System.out.println(">>> Mảng 2: " + removeDuplicates(list2));
        commonElements(list, list2);

        // Câu d
        System.out.println("\nCâu d");
        findMinMax(list2);

    }
}
