package buoi_02.bai_tap_buoi_2;

import java.util.Scanner;

public class Bai07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int luongCanBan = 650000;
        float heSo = 4.5f;

        System.out.print("Nhập vào thâm niên công tác: ");
        int TNCT =  sc.nextInt();

        if (TNCT < 12) {
            heSo = 1.92f;
        } else if (TNCT < 36) {
            heSo = 2.34f;
        }  else if (TNCT < 60) {
            heSo = 3;
        }

        System.out.printf("Lương = %,.2f$", heSo * luongCanBan);
    }
}
