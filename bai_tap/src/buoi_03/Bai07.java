package buoi_03;

import java.util.Scanner;

public class Bai07 {
//    TÌm UCLN và BCNN của hai số nguyên dương
    public static int UCLN(int a, int b) { // Thuật toán Euclid
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int BCNN(int a, int b) {
        return (a*b) / UCLN(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        System.out.printf("Ước chung lớn nhất của %d và %d là %d\n",  a, b, UCLN(a, b));
        System.out.printf("Bội chung nhỏ nhất của %d và %d là %d", a, b, BCNN(a, b));
    }

}
