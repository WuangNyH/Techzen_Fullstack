package buoi_02.bai_tap_buoi_2;

import java.util.Scanner;

public class Bai08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year;
        int month;

        // KIểm tra dữ liệu nhập vào là số nguyên
        System.out.print("Nhập năm: ");
        if (sc.hasNextInt()) {
            year = sc.nextInt();
            System.out.println("Năm: " +  year);
        } else {
            System.out.println("Vui lòng nhập số nguyên!");
            return;
        }

        if (year < 1) {
            System.out.print("Số năm không hợp lệ!");
            return;
        }

        // KIểm tra dữ liệu nhập vào là số nguyên
        System.out.print("Nhập tháng: ");
        if (sc.hasNextInt()) {
            month = sc.nextInt();
            System.out.println("Tháng: " +  month);
        } else {
            System.out.println("Vui lòng nhập số nguyên!");
            return;
        }

        if (month < 1 || month > 12) {
            System.out.print("Số tháng không hợp lệ!");
            return;
        }

        // TÍnh năm nhuận
        boolean laNamNhuan = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int day = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> laNamNhuan ? 29 : 28;
            default -> 31;
        };

        System.out.printf("Số ngày của tháng %d của năm %d có %d ngày", month, year, day);
    }
}
