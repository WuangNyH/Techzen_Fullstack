package buoi_10.bai_tap.utils;

public class MenuHelper {
    public static void displayMenu(String[] arr, int width, String title) {
        System.out.printf(">> %s <<\n", title);
        System.out.println("++ " + "-".repeat(width + 1) + " ++");

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("| %d. %-" + width + "s |\n", i + 1, arr[i]);
        }

        System.out.println("++ " + "-".repeat(width + 1) + " ++");
    }
}
