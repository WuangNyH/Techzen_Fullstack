package buoi_3.sang;

import java.util.Scanner;

public class GiangVien extends NhanSu {
    private String monGiangDay;

    public GiangVien(int id) {
        super();
        this.setId(String.format("GV" + "%03d", id));
    }

    @Override
    public double tinhLuong() {
        return this.getSoGioLam() * 200000;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm giảng viên với id " + this.getId());
        super.input();

        while (true) {
            System.out.print("Nhập môn giảng dạy: ");
            this.monGiangDay = sc.nextLine().trim();
            if (this.monGiangDay.matches("^[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+$")) break;
            else System.out.println("Môn học không hợp lệ! Tên môn học không được chứa ký tự đặc biệt.");
        }
    }

    @Override
    public String toString() {
        double luong = tinhLuong();
        String formatLuong = String.format("%,.2fVND", luong);
        return String.format("| %-10s | %-20s | %-5d | %-12.2f | %-15s | %-18s |",
                this.getId(), this.getHoTen(), this.getTuoi(), this.getSoGioLam(), this.monGiangDay, formatLuong);
    }
}
