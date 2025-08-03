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

    public static void sortByFor(ArrayList<Phone> phones, boolean ascending) {
        if (phones.isEmpty()) {
            System.out.println(">>Error: Danh sách trống!");
            return;
        }

        for (int i = 0; i < phones.size() - 1; i++) {
            for (int j = i + 1; j < phones.size(); j++) {
                double priceI = phones.get(i).getPrice();
                double priceJ = phones.get(j).getPrice();

                boolean sortCondition = ascending ? priceI > priceJ : priceI < priceJ;

                if (sortCondition) {
                    Collections.swap(phones, i, j);
                }
            }
        }
    }
}
