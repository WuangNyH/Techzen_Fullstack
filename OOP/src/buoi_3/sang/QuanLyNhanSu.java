package buoi_3.sang;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanSu {
    static ArrayList<NhanSu> danhSachNhanSu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int autoId = 1;

    public static void hienMenu() {
        System.out.println(">> LỰA CHỌN CHỨC NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Thêm nhân sự                             |");
        System.out.println("| 2. Hiện danh sách tất cả nhân sự            |");
        System.out.println("| 3. Tìm nhân sự theo tên                     |");
        System.out.println("| 4. Hiện thị tổng số nhân sự                 |");
        System.out.println("| 5. Nhân sự có số giờ làm việc nhiều nhất    |");
        System.out.println("| 6. Nhân sự có số giờ làm việc nhỏ hơn 20    |");
        System.out.println("| 7. Hiển thị lương của từng nhân sự          |");
        System.out.println("| 8. Thoát chương trình                       |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void hienMenu1() {
        System.out.println(">> LỰA CHỌN CHỨC VỤ <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Giảng viên                               |");
        System.out.println("| 2. Trợ giảng                                |");
        System.out.println("| 3. Thoát                                    |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void hienDanhSachNhanSu(ArrayList<NhanSu> danhSachNhanSu) {
        System.out.println("============= Danh sách nhân sự =============");
        System.out.printf("| %-10s | %-20s | %-5s | %-12s | %-15s | %-18s |\n",
                "ID", "Họ Tên", "Tuổi", "Số giờ làm", "Môn học", "Lương");

        for (NhanSu nhanSu : danhSachNhanSu) {
            System.out.println(nhanSu);
        }
        System.out.println();
    }

    public static void themNhanSu(int luaChon) {
        NhanSu nhanSuMoi;

        if (luaChon == 1) {
            nhanSuMoi = new GiangVien(autoId++);
        } else {
            nhanSuMoi = new TroGiang(autoId++);
        }

        nhanSuMoi.input();
        danhSachNhanSu.add(nhanSuMoi);
        System.out.println("Thêm nhân sự thành công!\n");
    }

    public static ArrayList<NhanSu> nhanSuTheoTen(String keyword) {
        ArrayList<NhanSu> danhSach = new ArrayList<>();

        if (danhSachNhanSu.isEmpty()) {
            System.out.println("Hiện tại chưa có nhân sự!\n");
            return danhSach;
        }

        for (NhanSu nhanSu : danhSachNhanSu) {
            if (nhanSu.getHoTen().toLowerCase().contains(keyword)) {
                danhSach.add(nhanSu);
            }
        }

        return danhSach;
    }

    public static ArrayList<NhanSu> nhieuGioNhat() {
        ArrayList<NhanSu> danhSach = new ArrayList<>();

        if (danhSachNhanSu.isEmpty()) {
            System.out.println("Hiện tại chưa có nhân sự!\n");
            return danhSach;
        }

        double max = danhSachNhanSu.get(0).getSoGioLam();

        for (NhanSu nhanSu : danhSachNhanSu) {
            if (nhanSu.getSoGioLam() > max) {
                max = nhanSu.getSoGioLam();
                danhSach.clear();
                danhSach.add(nhanSu);
            } else if (nhanSu.getSoGioLam() == max) {
                danhSach.add(nhanSu);
            }
        }

        return danhSach;
    }

    public static ArrayList<NhanSu> itHon20Gio() {
        ArrayList<NhanSu> danhSach = new ArrayList<>();

        if (danhSachNhanSu.isEmpty()) {
            System.out.println("Hiện tại chưa có nhân sự!\n");
            return danhSach;
        }

        for (NhanSu nhanSu : danhSachNhanSu) {
            if (nhanSu.getSoGioLam() < 20) {
                danhSach.add(nhanSu);
            }
        }

        return danhSach;
    }

    public static void hienThiLuong() {

        if (danhSachNhanSu.isEmpty()) {
            System.out.println("Hiện tại chưa có nhân sự!\n");
            return;
        }

        System.out.println("============= Bảng lương =============");
        System.out.printf("| %-10s | %-20s | %-18s |\n",
                "ID", "Họ Tên", "Lương");

        for (NhanSu nhanSu : danhSachNhanSu) {
            double luong = nhanSu.tinhLuong();
            String formatLuong = String.format("%,.2fVND", luong);
            System.out.printf("| %-10s | %-20s | %-18s |\n",
                    nhanSu.getId(), nhanSu.getHoTen(), formatLuong);
        }
    }

    public static void main(String[] args) {
        while (true) {
            hienMenu();
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    hienMenu1();
                    System.out.print("Chọn chức vụ: ");
                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1, 2:
                            themNhanSu(choice);
                            break;
                        default:
                            System.out.println("Thoát Menu!\n");
                            break;
                    }
                    break;
                case 2:
                    hienDanhSachNhanSu(danhSachNhanSu);
                    break;
                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    String keyword = sc.nextLine().trim().toLowerCase();
                    ArrayList<NhanSu> timTheoTen = nhanSuTheoTen(keyword);

                    if (!timTheoTen.isEmpty()) {
                        hienDanhSachNhanSu(timTheoTen);
                    }

                    break;
                case 4:
                    if (danhSachNhanSu.isEmpty()) {
                        System.out.println("Hiện tại chưa có nhân sự!\n");
                        break;
                    }

                    System.out.println("Tổng số nhân sự: " + NhanSu.tongNhanSu());
                    break;
                case 5:
                    ArrayList<NhanSu> nhieuGioNhat = nhieuGioNhat();

                    if (!nhieuGioNhat.isEmpty()) {
                        hienDanhSachNhanSu(nhieuGioNhat);
                    }

                    break;
                case 6:
                    ArrayList<NhanSu> itHon20Gio = itHon20Gio();

                    if (!itHon20Gio.isEmpty()) {
                        hienDanhSachNhanSu(itHon20Gio);
                    }
                    break;
                case 7:
                    hienThiLuong();
                    break;
                default:
                    System.out.print("Chắc chắn muốn thoát chương trình (Y/N): ");
                    String exit = sc.nextLine();
                    if (exit.equalsIgnoreCase("y")) {
                        return;
                    }
                    break;
            }
        }
    }
}
