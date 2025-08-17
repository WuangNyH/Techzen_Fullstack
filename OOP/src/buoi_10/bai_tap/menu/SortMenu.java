package buoi_10.bai_tap.menu;

import static buoi_10.bai_tap.utils.MenuHelper.displayMenu;

public class SortMenu {
    public static void sortMenu() {
        String[] options = {
                "Tăng dần",
                "Giảm dần",
                "Về menu chính"
        };

        displayMenu(options, 45, "SẮP XẾP THEO GIÁ TIỀN");
    }
}
