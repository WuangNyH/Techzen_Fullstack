package buoi_03;

// In cách hình bằng dấu *
public class Bai10 {

//    ******
//     *
//      *
//       *
//        *
//    ******
    public static void hinhA(int canh) {
        System.out.println("Hình a");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == 1 || i == 6 || j == i) ? "*" : " ");
            }
            System.out.println();
        }
    }

//  ******
//      *
//     *
//    *
//   *
//  ******
    public static void hinhB(int canh) {
        System.out.println("\nHình b");

        for (int i = 0; i < canh; i++) {
            for (int j = 1; j <= canh; j++) {
                System.out.print((i == 0 || i == canh - 1 || j == canh - i) ? "*" : " ");
            }
            System.out.println();
        }
    }

//    ******
//    **   *
//    * *  *
//    *  * *
//    *   **
//    ******
    public static void hinhC(int canh) {
        System.out.println("\nHình c");

        for (int i = 1; i <= canh; i++) {
            for (int j = 1; j <= canh; j++) {
                // Để vẽ hình chữ nhật ( i và j bằng cạnh hoặc bằng 1)
                // Để vẽ đường chéo (j bằng i)
                System.out.print((i == 1 || i == canh || j == i || j == 1 || j == canh) ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hinhA(6);
        hinhB(6);
        hinhC(6);
    }
}
