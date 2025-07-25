package buoi_2.thuc_hanh;

import java.util.ArrayList;

public class Utils {
    private Utils() {};

    // add list
    //.display list
    public static <T> void addObject(ArrayList<T> list, T object) {
        list.add(object);
    }

    public static <T> void displayList(ArrayList<T> list) {
        for (T object : list) {
            System.out.println("++ ----------------------------------------- ++");
            System.out.println(object);
            System.out.println("++ ----------------------------------------- ++\n");
        }
    }
}
