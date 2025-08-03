package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.NewPhone;
import buoi_5.bai_tap_ve_nha.OldPhone;
import buoi_5.bai_tap_ve_nha.Phone;

import java.util.ArrayList;

import static buoi_5.bai_tap_ve_nha.Main.Main.sc;
import static buoi_5.bai_tap_ve_nha.Main.ShowListPhone.getListPhone;
import static buoi_5.bai_tap_ve_nha.Main.ShowListPhone.displayListPhone;

public class SearchPhone {
    public static void menuSearchPhone() {
        System.out.println(">> MENU TÌM KIẾM <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Tìm theo loại");
        System.out.printf("| 2. %-40s |\n", "Tìm theo giá");
        System.out.printf("| 3. %-40s |\n", "Tìm theo tên");
        System.out.printf("| 4. %-40s |\n", "Quay về menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void searchByStatus(ArrayList<Phone> list) {
        while (true) {
            try {
                System.out.println("++ ----------------------------------------- ++");
                System.out.printf("| 1. %-40s |\n", "Loại mới");
                System.out.printf("| 2. %-40s |\n", "Loại cũ");
                System.out.printf("| 3. %-40s |\n", "Quay về menu tìm kiếm");
                System.out.println("++ ----------------------------------------- ++");

                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> displayListPhone(getListPhone(NewPhone.class, list));
                    case 2 -> displayListPhone(getListPhone(OldPhone.class, list));
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }

        }
    }

    public static void searchByPrice(ArrayList<Phone> list) {
        if (list.isEmpty()) {
            System.out.println(">>Error: Danh sách trống!");
            return;
        }

        double lowestPrice;
        double highestPrice;

        while (true) {
            try {
                System.out.print("Nhập giá thấp nhất cần tìm: ");
                lowestPrice = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Giá phải là một số thực!");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập giá cao nhất cần tìm: ");
                highestPrice = Double.parseDouble(sc.nextLine());

                if (highestPrice < lowestPrice) {
                    System.out.println(">>Error: Giá cao nhất phải bé hơn giá thấp nhất!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Giá phải là một số thực!");
            }
        }

        ArrayList<Phone> listPhone = new ArrayList<>();
        for (Phone phone : list) {
            if (phone.getPrice() >= lowestPrice && phone.getPrice() <= highestPrice) {
                listPhone.add(phone);
            }
        }
        displayListPhone(listPhone);
    }

    public static void searchByName(ArrayList<Phone> list) {
        if (list.isEmpty()) {
            System.out.println(">>Error: Danh sách trống!");
            return;
        }

        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        ArrayList<Phone> listPhone = new ArrayList<>();
        for (Phone phone : list) {
            if (phone.getName().toLowerCase().contains(keyword)) {
                listPhone.add(phone);
            }
        }
        displayListPhone(listPhone);
    }
}
