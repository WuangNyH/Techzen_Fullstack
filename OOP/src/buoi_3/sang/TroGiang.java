package buoi_3.sang;

import java.util.Scanner;

public class TroGiang extends NhanSu {
    private String boMonPhuTrach;

    public TroGiang(int id) {
        super();
        this.setId(String.format("TG" + "%03d", id));
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm trợ giảng với id " + this.getTuoi());
        super.input();

        while (true) {
            System.out.print("Nhập môn trở giảng: ");
            this.boMonPhuTrach = sc.nextLine().trim();
            if (this.boMonPhuTrach.matches("^[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+$")) break;
            else System.out.println("Môn học không hợp lệ! Tên môn học không được chứa ký tự đặc biệt.");
        }
    }

    @Override
    public double tinhLuong() {
        return this.getSoGioLam() * 100000;
    }

    @Override
    public String toString() {
        double luong = tinhLuong();
        String formatLuong = String.format("%.2fVND", luong);
        return String.format("| %-10s | %-20s | %-5d | %-12.2f | %-15s | %-18s |",
                this.getId(), this.getHoTen(), this.getTuoi(), this.getSoGioLam(), this.boMonPhuTrach, formatLuong);
    }
}
