package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.Phone;

import java.util.ArrayList;
import java.util.Collections;

public class SortPhoneByPrice {
    public static void menuSortPhone() {
        System.out.println(">> MENU SẮP XẾP THEO GIÁ <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Tăng dần");
        System.out.printf("| 2. %-40s |\n", "Giảm dần");
        System.out.printf("| 3. %-40s |\n", "Trở về menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void sortByCollections(ArrayList<Phone> phones, boolean ascending) {
        if (phones.isEmpty()) {
            System.out.println(">>Error: Danh sách trống!");
            return;
        }

        if (ascending) {
            Collections.sort(phones);
        } else {
            phones.sort(Collections.reverseOrder());
        }
    }
}
