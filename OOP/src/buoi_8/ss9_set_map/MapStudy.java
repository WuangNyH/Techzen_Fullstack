package buoi_8.ss9_set_map;


import java.util.*;

public class MapStudy {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(2, "Nguyễn Văn B");
        map.put(1, "Nguyễn Văn A");
        map.put(3, "Nguyễn Văn C");

        System.out.println(map.containsValue("Nguyễn Văn A"));


        /// Duyệt qua các phần tử của map???
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
