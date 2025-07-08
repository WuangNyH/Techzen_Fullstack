package buoi_02;

import java.util.Scanner;

public class Bai02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm: ");
        float diem =  sc.nextFloat();
        String output = "Giỏi";

        if (diem < 5) {
            output = "Yếu";
        } else if (diem >= 5 && diem < 6.5) {
            output = "Trung bình";
        } else if (diem >= 6.5 && diem < 8) {
            output = "Khá";
        }

        System.out.println(output);
    }
}
