package bai_05.bai_tap_method;

import buoi_02.bai_tap_buoi_2.Bai05;

import java.util.Scanner;

public class Bai01 {
    public static char convertChar(char character) {
        return Character.isLowerCase(character) ? Character.toUpperCase(character) : Character.toLowerCase(character);
    }

    public static void giaiPTBac1(int a, int b) {
        if (a == 0) {
            System.out.println(b == 0 ? "Phương trình có vô số nghiệm" : "Phương trình vô nghiệm");
        } else {
            float x = (float) -b / a;
            System.out.printf("Phương trình có một nghiệm x = %.1f%n", x);
        }
    }

    public static void giaiPTBac2(int a, int b, int c) {
        if (a == 0) {
            giaiPTBac1(b, c);
        } else {
            int delta = b*b - 4*a*c;
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm");
            } else if (delta == 0) {
                float x = (float) -b / (2*a);
                System.out.printf("Phương trình có nghiệm kép x1 = x2 = %.1f%n", x);
            } else {
                double sqrtDelta = Math.sqrt(delta);
                double x1 = (-b + sqrtDelta) / (2 * a);
                double x2 = (-b - sqrtDelta) / (2 * a);
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.printf("x1 = %.1f%n", x1);
                System.out.printf("x2 = %.1f%n", x2);
            }
        }
    }

    public static int min(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">> LỰA CHỌN TÍNH NĂNG <<");
            System.out.println("++ ----------------------------------------- ++");
            System.out.println("| 1. Đổi ký tự hoa sang thường và ngược lại   |");
            System.out.println("| 2. Giải phương trình bậc một                |");
            System.out.println("| 3. Giải phương trình bậc hai                |");
            System.out.println("| 4. Tìm số nhỏ nhất trong 4 số               |");
            System.out.println("++ ----------------------------------------- ++");
            System.out.print("Lựa chọn: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Nhập một ký tự bất kỳ: ");
                    char kyTu =  sc.next().charAt(0);
                    kyTu = convertChar(kyTu);
                    System.out.println(kyTu);
                    break;
                case 2:
                    System.out.print("Nhập số nguyên a: ");
                    int a = sc.nextInt();

                    System.out.print("Nhập số nguyên b: ");
                    int b = sc.nextInt();

                    giaiPTBac1(a, b);
                    break;
                case 3:
                    System.out.print("Nhập số nguyên a: ");
                    int a2 = sc.nextInt();

                    System.out.print("Nhập số nguyên b: ");
                    int b2 = sc.nextInt();

                    System.out.print("Nhập số nguyên c: ");
                    int c2 = sc.nextInt();

                    giaiPTBac2(a2, b2, c2);
                    break;
                case 4:
                    System.out.print("Nhập số nguyên a: ");
                    int a3 = sc.nextInt();

                    System.out.print("Nhập số nguyên b: ");
                    int b3 = sc.nextInt();

                    System.out.print("Nhập số nguyên c: ");
                    int c3 = sc.nextInt();

                    System.out.print("Nhập số nguyên c: ");
                    int d3 = sc.nextInt();

                    int min = min(a3, b3, c3, d3);
                    System.out.println("Min = " + min);
                    break;
                default:
                    return;
            }
        }
    }
}
