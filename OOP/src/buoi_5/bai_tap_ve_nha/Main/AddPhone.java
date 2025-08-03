package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.Phone;

import java.util.ArrayList;

public class AddPhone {
    public static void menuAddPhone() {
        System.out.println(">> MENU THÊM MỚI ĐIỆN THOẠI <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Thêm điện thoại mới");
        System.out.printf("| 2. %-40s |\n", "Thêm điện thoại cũ");
        System.out.printf("| 3. %-40s |\n", "Trở về menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static <T extends Phone> void addPhone(T phone, ArrayList<Phone> phones) {
        phone.input();
        phones.add(phone);
        System.out.println("Thêm điện thoại mới thành công!");
    }
}
