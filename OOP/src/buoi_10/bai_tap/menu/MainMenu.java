package buoi_10.bai_tap.menu;

import static buoi_10.bai_tap.utils.MenuHelper.displayMenu;

public class MainMenu {
    public static void mainMenu() {
        String[] options = {
                "Xem danh sách điện thoại",
                "Thêm mới",
                "Cập nhật",
                "Xóa",
                "Sắp xếp theo giá",
                "Tìm kiếm",
                "Tính tổng tiền",
                "Giảm giá cho điện thoại cũ",
                "Thoát chương trình"
        };

        displayMenu(options, 45, "LỰA CHỌN CHỨC NĂNG");
    }
}
