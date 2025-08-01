package buoi_5.chieu;

import java.util.Scanner;

public class StudentBE extends Student {
    String ngonNguLapTrinh;

    public StudentBE() {
    }

    public StudentBE(String id, String name, int age, String email, double diemTrungBinh, int soBuoiHoc, String ngonNguLapTrinh) {
        super(id, name, age, email, diemTrungBinh, soBuoiHoc);
        this.ngonNguLapTrinh = ngonNguLapTrinh;
    }

    public String getNgonNguLapTrinh() {
        return ngonNguLapTrinh;
    }

    public void setNgonNguLapTrinh(String ngonNguLapTrinh) {
        this.ngonNguLapTrinh = ngonNguLapTrinh;
    }

    @Override
    public void setId(String id) {
        super.setId("HVBE-00" + id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Ngôn ngữ lập trình: " + ngonNguLapTrinh + "\n";
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập ngôn ngữ lập trình: ");
        this.ngonNguLapTrinh = sc.nextLine().trim();
    }

    @Override
    public double getTuition() {
        return this.soBuoiHoc * 50000 * 0.9;
    }

    @Override
    public String xepLoai() {
        if (this.diemTrungBinh >= 7.5) {
            return "Giỏi";
        } else if (this.diemTrungBinh >= 5) {
            return "Khá";
        } else {
            return "Trung Bình";
        }
    }

    @Override
    public double hocPhi() {
        return this.soBuoiHoc * 50000 * 0.9;
    }
}
