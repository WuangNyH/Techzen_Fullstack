package buoi_02.bai_tap_buoi_2;

import java.util.Scanner;

public class Bai09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một ký tự: ");
        String string = sc.nextLine();

        if (string.length() != 1) {
            System.out.println("Vui lòng chỉ nhập 1 ký tự");
            return;
        }

        char character = string.charAt(0);
        int acsii = character;
        System.out.println(acsii);

        // Cách 1
        if (acsii < 65 || acsii > 122 || acsii < 97 && acsii > 90) {
            System.out.println("Vui lòng nhập một ký tự từ a-z hoặc A-Z");
            return;
        }
        char switched1 = (acsii > 90) ? Character.toUpperCase(character) : Character.toLowerCase(character);
        System.out.println(switched1);

        // Cách 2
        if (!Character.isLetter(character)) {
            System.out.println("Vui lòng nhập một ký tự từ a-z hoặc A-Z");
            return;
        }
        char switched2 = Character.isUpperCase(character) ? Character.toLowerCase(character) : Character.toUpperCase(character);
        System.out.println(switched2);

    }
}
