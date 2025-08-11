package buoi_9.sang;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void calcSqrt() {
        try {
            System.out.print("Nhập số nguyên dương: ");
            int num = Integer.parseInt(sc.nextLine());

            if (num < 0) {
                throw new IllegalArgumentException(">>> Error: Số nhập vào phải >= 0!");
            }

            System.out.printf("Căn bậc hai của %d là %.2f\n", num, Math.sqrt(num));
        } catch (NumberFormatException e) {
            System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Chương trình kết thúc");
        }
    }

    public static double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException(">>> Error: Division by zero!");
        }

        return (double) a / b;
    }

    public static void main(String[] args) {
        System.out.println("Bài 1");
        calcSqrt();

        System.out.println("\nBài 2");
        try {
            int a;
            int b;

            while (true) {
                try {
                    System.out.print("Nhập a: ");
                    a = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
                }
            }

            while (true) {
                try {
                    System.out.print("Nhập b: ");
                    b = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
                }
            }

            System.out.println(divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
