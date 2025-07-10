package buoi_03;

import java.util.Scanner;

import static bai_06.Bai01.giaiThua;

public class Bai11 {
    //    Tính tổng giai thừa của 3 số nguyên dương
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: ");
        int a = sc.nextInt();

        System.out.print("Nhập b: ");
        int b = sc.nextInt();

        System.out.print("Nhập c: ");
        int c = sc.nextInt();

        int sum = giaiThua(a) + giaiThua(b) + giaiThua(c);
        System.out.println("Tổng giai thừa của a, b và c: " + sum);
    }
}
