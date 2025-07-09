package buoi_03;

// In các tam giác bằng giấu *
public class Bai09 {
//   *
//   **
//   ***
//   ****
//   *****
    public static void hinhA(int canh) {
        System.out.println("Hình a");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//  *****
//  ****
//  ***
//  **
//  *
    public static void hinhB(int canh) {
        System.out.println("\nHình b");

        for (int i = 0; i < canh; i++) {
            for (int j = 1; j <= canh - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

//      *
//     **
//    ***
//   ****
//  *****
    public static void hinhC(int canh) {
        System.out.println("\nHình c");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((j <= canh - i) ? " " : "*");
            }
            System.out.println();
        }
    }

//  *****
//  *  *
//  * *
//  **
//  *
    public static void hinhD(int canh) {
        System.out.println("\nHình d");

        for (int i = 0; i < canh; i++) {
            for (int j = 1; j <= canh - i; j++) {
                System.out.print((i == 0 || j == 1 || j == canh - i) ? "*" : " ");
            }
            System.out.println();
        }
    }

//       *
//      ***
//     *****
//    *******
    public static void hinhE(int height) {
        System.out.println("\nHình e");

        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= (2 * height - 1); j++) {
                System.out.print((height - i <= j && j <= height + i) ? "*" : " ");
            }
            System.out.println();
        }
    }

//    *******
//     *****
//      ***
//       *
    public static void hinhF(int height) {
        System.out.println("\nHình f");

        for (int i = height - 1; i >= 0; i--) {
            for (int j = 1; j <= (2 * height - 1); j++) {
                System.out.print((height - i <= j && j <= height + i) ? "*" : " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        hinhA(5);
        hinhB(5);
        hinhC(5);
        hinhD(5);
        hinhE(4);
        hinhF(4);
    }
}
