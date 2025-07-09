package buoi_03;

// In các hình hộp bằng dấu *
public class Bai08 {
//        ******
//        *    *
//        *    *
//        *    *
//        *    *
//        ******
    public static void hinhA(int canh) {
        System.out.println("Hình a");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == 1 || i == canh || j == 1 || j == canh) ? "*" : " ");
            }
            System.out.println();
        }
    }

//        ******
//        *
//        *
//        *
//        *
//        ******
    public static void hinhB(int canh) {
        System.out.println("\nHình b");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == 1 || i == canh || j == 1) ? "*" : " ");
            }
            System.out.println();
        }
    }

//        ******
//             *
//             *
//             *
//             *
//        ******
    public static void hinhC(int canh) {
        System.out.println("\nHình c");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == 1 || i == canh || j == canh) ? "*" : " ");
            }
            System.out.println();
        }
    }

//
//        *    *
//        *    *
//        *    *
//        *    *
//        ******
    public static void hinhD(int canh) {
        System.out.println("\nHình d");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == canh || j == 1 || j == canh) ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hinhA(6);
        hinhB(6);
        hinhC(6);
        hinhD(6);
    }
}
