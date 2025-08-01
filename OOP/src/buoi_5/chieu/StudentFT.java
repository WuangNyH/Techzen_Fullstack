package buoi_5.chieu;

import java.util.Scanner;

public class StudentFT extends Student {
    int soDuAnThamGia;

    public StudentFT() {
    }

    public StudentFT(String id, String name, int age, String email, double diemTrungBinh, int soBuoiHoc, int soDuAnThamGia) {
        super(id, name, age, email, diemTrungBinh, soBuoiHoc);
        this.soDuAnThamGia = soDuAnThamGia;
    }

    public int getSoDuAnThamGia() {
        return soDuAnThamGia;
    }

    public void setSoDuAnThamGia(int soDuAnThamGia) {
        this.soDuAnThamGia = soDuAnThamGia;
    }

    @Override
    public void setId(String id) {
        super.setId("HVFS-00" + id);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Số dự án tham gia: " + soDuAnThamGia + "\n";
    }


    @Override
    public void input(Scanner sc) {
        super.input(sc);
        // Nhập số dự án tham gia
        while (true) {
            System.out.print("Nhập số dự án tham gia: ");
            if (sc.hasNextInt()) {
                this.soDuAnThamGia = Integer.parseInt(sc.nextLine());
                if (this.soDuAnThamGia < 0) {
                    System.out.println("❌ Không hợp lệ! Phải >= 0.");
                    continue;
                }
                break;
            } else {
                System.out.println("❌ Không hợp lệ! Nhập số nguyên.");
            }
        }
    }

    @Override
    public double getTuition() {
        return this.soBuoiHoc * 50000 * 0.85;
    }

    @Override
    public String xepLoai() {
        if (this.soDuAnThamGia >= 2 && this.diemTrungBinh >= 8) {
            return "Giỏi";
        } else if (this.diemTrungBinh >= 6.5) {
            return "Khá";
        } else {
            return "Trung bình";
        }
    }

    @Override
    public double hocPhi() {
        return this.soBuoiHoc * 50000 * 0.85;
    }
}
