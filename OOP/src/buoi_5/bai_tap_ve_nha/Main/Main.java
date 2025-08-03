package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.NewPhone;
import buoi_5.bai_tap_ve_nha.OldPhone;
import buoi_5.bai_tap_ve_nha.Phone;
import buoi_5.bai_tap_ve_nha.PhoneConstants;

import java.util.ArrayList;
import java.util.Scanner;

import static buoi_5.bai_tap_ve_nha.Main.AddPhone.addPhone;
import static buoi_5.bai_tap_ve_nha.Main.AddPhone.menuAddPhone;
import static buoi_5.bai_tap_ve_nha.Main.ShowListPhone.*;
import static buoi_5.bai_tap_ve_nha.Main.UpdatePhone.updateNewPhone;
import static buoi_5.bai_tap_ve_nha.Main.UpdatePhone.updateOldPhone;
import static buoi_5.bai_tap_ve_nha.Main.SortPhoneByPrice.*;

public class Main implements PhoneConstants {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Phone> phones = new ArrayList<>();

    public static void initializePhones() {
        // Thêm điện thoại mới
        phones.add(new NewPhone("DTM000", "iPhone 15 Pro", 25000000, 24, OSType.IOS, "Apple", 50));
        phones.add(new NewPhone("DTM001", "Samsung Galaxy S24", 22000000, 24, OSType.ANDROID, "Samsung", 30));
        phones.add(new NewPhone("DTM002", "iPhone 14", 20000000, 24, OSType.IOS, "Apple", 25));
        phones.add(new NewPhone("DTM003", "Xiaomi 13 Pro", 15000000, 18, OSType.ANDROID, "Xiaomi", 40));
        phones.add(new NewPhone("DTM004", "Google Pixel 8", 18000000, 24, OSType.ANDROID, "Google", 20));

        // Thêm điện thoại cũ
        phones.add(new OldPhone("DTC000", "iPhone 12", 12000000, 6, OSType.IOS, "Apple", 85));
        phones.add(new OldPhone("DTC001", "Samsung Galaxy S21", 10000000, 6, OSType.ANDROID, "Samsung", 78));
        phones.add(new OldPhone("DTC002", "iPhone 11", 8000000, 3, OSType.IOS, "Apple", 70));
        phones.add(new OldPhone("DTC003", "Huawei P40", 7000000, 6, OSType.ANDROID, "Huawei", 65));
        phones.add(new OldPhone("DTC004", "Nokia 8.3", 5000000, 3, OSType.ANDROID, "Nokia", 80));
        phones.add(new OldPhone("DTC005", "BlackBerry Key2", 3000000, 3, OSType.BLACKBERRY_OS, "BlackBerry", 60));
        phones.add(new OldPhone("DTC006", "iPhone 14", 6000000, 3, OSType.IOS, "Apple", 55));
    }

    private static void mainMenu() {
        System.out.println(">> LỰA CHỌN CHỨC NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Xem danh sách điện thoại");
        System.out.printf("| 2. %-40s |\n", "Thêm mới");
        System.out.printf("| 3. %-40s |\n", "Cập nhật");
        System.out.printf("| 4. %-40s |\n", "Xóa");
        System.out.printf("| 5. %-40s |\n", "Sắp xếp theo giá");
        System.out.printf("| 6. %-40s |\n", "Tìm kiếm");
        System.out.printf("| 7. %-40s |\n", "Tính tổng tiền");
        System.out.printf("| 8. %-40s |\n", "Giảm giá cho điện thoại cũ");
        System.out.printf("| 9. %-40s |\n", "Thoát chương trình");
        System.out.println("++ ----------------------------------------- ++");
    }

    //1. Hiển thị danh sách
    private static void processShowPhone() {
        while (true) {
            try {
                menuShowPhone();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> displayListPhone(phones);
                    case 2 -> displayListPhone(getListPhone(NewPhone.class, phones));
                    case 3 -> displayListPhone(getListPhone(OldPhone.class, phones));
                    case 4 -> {
                        return;
                    }
                    case 5 -> System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    // 2. Thêm mới
    private static void processAddPhone() {
        while (true) {
            try {
                menuAddPhone();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        NewPhone newPhone = new NewPhone();
                        addPhone(newPhone, phones);
                        break;
                    case 2:
                        OldPhone oldPhone = new OldPhone();
                        addPhone(oldPhone, phones);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    // 3. Cập nhật
    private static void processUpdatePhone() {
        System.out.print("Nhập id sản phẩm: ");
        String id = sc.nextLine().trim();
        Phone phone = getPhone(id, phones);

        if (phone == null) {
            System.out.println(">>Error: ID không tồn tại!");
        }

        if (phone instanceof NewPhone) {
            updateNewPhone(phone);
        } else if (phone instanceof OldPhone) {
            updateOldPhone(phone);
        }
    }

    // 4. Xóa
    private static void processDeletePhone() {
        System.out.print("Nhập id sản phẩm: ");
        String id = sc.nextLine().trim();
        boolean found = false;

        for (Phone phone : phones) {
            if (phone.getId().equals(id)) {
                found = true;
                phones.remove(phone);
                break;
            }
        }

        if (!found) {
            System.out.println(">>Error: ID không tồn tại!");
            return;
        }
        System.out.println("Xóa điện thoại với id #" + id + " thành công!");
    }

    // 5. Sắp xếp theo giá
    private static void processSortByPrice() {
        while (true) {
            try {
                menuSortPhone();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        sortByFor(phones, true);
                        displayListPhone(phones);
                    }
                    case 2 -> {
                        sortByFor(phones, false);
                        displayListPhone(phones);
                    }
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

    public static void main(String[] args) {
        initializePhones();
        while (true) {
            try {
                mainMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        processShowPhone();
                        break;
                    case 2:
                        processAddPhone();
                        break;
                    case 3:
                        processUpdatePhone();
                        break;
                    case 4:
                        processDeletePhone();
                        break;
                    case 5:
                        processSortByPrice();
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }
}
