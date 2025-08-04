package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.Phone;

import java.util.ArrayList;

public class ShowListPhone {
    // 1. Xem danh sách
    public static void menuShowPhone() {
        System.out.println(">> MENU HIỆN THỊ DANH SÁCH <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Xem tất cả");
        System.out.printf("| 2. %-40s |\n", "Xem điện thoại mới");
        System.out.printf("| 3. %-40s |\n", "Xem điện thoại cũ");
        System.out.printf("| 4. %-40s |\n", "Trở về menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void displayListPhone(ArrayList<? extends Phone> list) {
        if (list.isEmpty()) {
            System.out.println(">>Error: Danh sách trống!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Thông tin điện thoại thứ: " + (i + 1));
            System.out.println(list.get(i).toString());
        }
        System.out.printf("Tìm được %d sản phẩm!\n", list.size());
    }

    public static <T extends Phone> ArrayList<T> getListPhone(Class<T> type, ArrayList<Phone> phones) {
        ArrayList<T> listPhone = new ArrayList<>();
        for (Phone phone : phones) {
            if (type.isInstance(phone)) {
                listPhone.add(type.cast(phone));
            }
        }
        return listPhone;
    }

    public static Phone getPhone(String id, ArrayList<Phone> phones) {
        Phone phone = null;
        for (Phone p : phones) {
            if (p.getId().equalsIgnoreCase(id)) {
                phone = p;
                break;
            }
        }
        return phone;
    }
}
