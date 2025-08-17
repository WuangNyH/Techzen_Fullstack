package buoi_10.bai_tap.menu;

import static buoi_10.bai_tap.utils.MenuHelper.displayMenu;

public class ShowPhoneMenu {
    public static void showPhoneMenu() {
        String[] options = {
                "Xem tất cả",
                "Xem điện thoại mới",
                "Xem điện thoại cũ",
                "Về menu chính"
        };

        displayMenu(options, 45, "HIỆN THỊ DANH SÁCH ĐIỆN THOẠI");
    }
}
