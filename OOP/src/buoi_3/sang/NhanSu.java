package buoi_3.sang;

import java.util.Scanner;

public class NhanSu {
    private String id;
    private String hoTen;
    private int tuoi;
    private double soGioLam;

    private static int soLuongNhanSu = 0;

    public NhanSu() {
        soLuongNhanSu++;
    }

    public String getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public double getSoGioLam() {
        return soGioLam;
    }

    public static int tongNhanSu() {
        return soLuongNhanSu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập họ tên: ");
            this.hoTen = sc.nextLine().trim();
            if (this.hoTen.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) break;
            else System.out.println("Tên không hợp lệ!. Vui lòng nhập tên không chứa ký tự đặt biệt và chữ số");
        }

        while (true) {
            System.out.print("Nhập tuổi: ");
            if (sc.hasNextInt()) {
                this.tuoi = sc.nextInt();
                if (this.tuoi < 0) {
                    System.out.println("Tuổi không hợp lệ!. Vui lòng nhập tuổi lớn hơn 0!");
                    continue;
                }
                sc.nextLine();
                break;
            } else {
                System.out.println("Tuổi không hợp lệ!. Vui lòng nhập tuổi lớn hơn 0!");
                sc.nextLine();
            }
        }

        while (true) {
            System.out.print("Nhập số giờ làm: ");
            if (sc.hasNextFloat()) {
                this.soGioLam = sc.nextFloat();
                if (this.soGioLam < 0) {
                    System.out.println("Số giờ làm không hợp lệ!. Vui lòng nhập số giờ làm từ 0 - 10!");
                    continue;
                }
                sc.nextLine();
                break;
            } else {
                System.out.println("Số giờ làm không hợp lệ!. Vui lòng nhập số giờ làm từ 0 - 10!");
                sc.nextLine();
            }
        }
    }

    public double tinhLuong() {
        return 0;
    }

    @Override
    public String toString() {
        double luong = this.tinhLuong();
        String formatLuong = String.format("%,.2fVND", luong);
        return String.format("| %-10s | %-20s | %-5d | %-12.2f | %-18s |",
                this.getId(), this.getHoTen(), this.getTuoi(), this.getSoGioLam(), formatLuong);
    }
}
