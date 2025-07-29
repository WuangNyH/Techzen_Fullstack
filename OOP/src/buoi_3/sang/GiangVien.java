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
        return super.toString() + String.format(" %-15s |", this.monGiangDay);
    }
}
