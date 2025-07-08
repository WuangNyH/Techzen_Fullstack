package bai_tap_buoi_2;

import java.util.Scanner;

public class Bai11 {
    public static boolean validateTime(byte day, byte month, int year) {
        if (day < 1 || month < 1 || month > 12 || year < 1) {
            System.out.printf("%d/%d/%d không tồn taị!", day, month, year);
            return false;
        }

        int maxDay = getMaxDayOfMonth(month, year);

        if (day > maxDay) {
            System.out.println("Ngày không hợp lệ!");
            return false;
        } else {
            System.out.println("Ngày hợp lệ: " + day + "/" + month + "/" + year);
            return true;
        }
    }

    public static int getMaxDayOfMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
            default -> 31;
        };
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ngày: ");
        byte day =  sc.nextByte();

        System.out.print("Nhập tháng: ");
        byte month =  sc.nextByte();

        System.out.print("Nhập năm: ");
        int year =  sc.nextInt();

        if (validateTime(day, month, year)) {
            day++;
            int maxDay = getMaxDayOfMonth(month, year);

            if (day > maxDay) {
                day = 1;
                month++;
                if (month > 12){
                    month = 1;
                    year++;
                }
            }
            System.out.printf("Ngày tiếp theo là ngày %d/%d/%d", day, month, year);
        }
    }
}
