package buoi_5.chieu;

import java.util.Scanner;

public abstract class Student extends Person implements IStudent {
    double diemTrungBinh;
    int soBuoiHoc;

    public Student() {
    }

    public Student(String id, String name, int age, String email, double diemTrungBinh, int soBuoiHoc) {
        super(id, name, age, email);
        this.diemTrungBinh = diemTrungBinh;
        this.soBuoiHoc = soBuoiHoc;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public double getSoBuoiHoc() {
        return soBuoiHoc;
    }

    public void setSoBuoiHoc(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Điểm TB: " + diemTrungBinh + "\n"
                + "Số buổi học: " + soBuoiHoc + "\n"
                + "Xếp loại: " + this.xepLoai() + "\n"
                + "Học phí: " + String.format("%.2fVND", this.hocPhi()) + "\n";
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        // Nhập điểm trung bình
        while (true) {
            System.out.print("Nhập điểm trung bình: ");
            if (sc.hasNextDouble()) {
                this.diemTrungBinh = Double.parseDouble(sc.nextLine());
                if (this.diemTrungBinh < 0 || this.diemTrungBinh > 10) {
                    System.out.println("❌ Điểm trung bình không hợp lệ! Phải từ 0 - 10.");
                    continue;
                }
                break;
            } else {
                System.out.println("❌ Điểm trung bình không hợp lệ! Nhập số nguyên.");
            }
        }

        System.out.println("sỐ BUỔI HỌC: ");
        this.soBuoiHoc = Integer.parseInt(sc.nextLine());
    }

    public abstract String xepLoai();

    public abstract double hocPhi();
}
