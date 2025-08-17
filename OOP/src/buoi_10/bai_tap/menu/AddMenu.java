package buoi_10.bai_tap.menu;

import static buoi_10.bai_tap.utils.MenuHelper.displayMenu;

public class AddMenu {
    public static void addMenu() {
        String[] options = {
                "Thêm điện thoại mới",
                "Thêm điện thoại cũ",
                "Về menu chính"
        };

        displayMenu(options, 45, "THÊM MỚI ĐIỆN THOẠI");
    }
}
