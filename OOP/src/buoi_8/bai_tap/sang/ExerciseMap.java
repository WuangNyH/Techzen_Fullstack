package buoi_8.bai_tap.sang;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExerciseMap {
    private static HashMap<String, Integer> wordCount(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }

    private static void uniqueAndDuplicatesName(String[] names) {
        HashMap<String, Integer> map = wordCount(names);

        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<String> duplicateWords = new ArrayList<>();

        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            } else {
                duplicateWords.add(entry.getKey());
            }
        }

        System.out.println("Danh sách từ duy nhất: " + uniqueWords);
        System.out.println("Danh sách từ trùng lặp: " + duplicateWords);
    }


    public static void main(String[] args) {
        // Alice is girl and Bob is boy
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một đoạn văn: ");
        String param = sc.nextLine().trim().toLowerCase();
        String[] words = param.split("\\s+");
        HashMap<String, Integer> map = wordCount(words);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("Từ %s xuất hiện %d lần\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nCâu b: ");
        System.out.print("Nhập số lượng tên trong danh sách: ");
        int n = Integer.parseInt(sc.nextLine().trim().toLowerCase());
        String[] listName = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên thứ " + (i + 1) + ": ");
            listName[i] = sc.nextLine().trim();
        }

        uniqueAndDuplicatesName(listName);
    }
}
