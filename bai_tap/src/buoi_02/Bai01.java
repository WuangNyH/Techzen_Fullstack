package buoi_02;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("NHập một số nguyên: ");
        int n = sc.nextInt();
        System.out.printf(n % 2 == 0 ? "%d là số chẵn" : "%d là số lẻ", n);
    }
}
