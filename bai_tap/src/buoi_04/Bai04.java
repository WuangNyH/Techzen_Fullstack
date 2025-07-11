package buoi_04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Bai04 {
    //  Random String 4 chữ cái
    public static String randomString(int length) {
        StringBuilder output = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char ch = (char)(random.nextInt(26) + 65);
            output.append(ch);
        }
        return output.toString();
    }

    public static String getTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return formatter.format(now);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập loại hàng hóa: ");
        String loaiHoaDon = sc.nextLine();

        System.out.println(String.join("_", loaiHoaDon, getTime(), randomString(4)));
    }
}
