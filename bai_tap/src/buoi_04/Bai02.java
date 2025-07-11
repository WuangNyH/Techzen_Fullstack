package buoi_04;

import java.util.Scanner;

public class Bai02 {
    public static boolean checkPassword(String password) {
        password = password.trim();

        if (password.contains(" ")) {
            System.out.println("Password không được để khoảng trắng!");
            return false;
        }

        if (password.length() < 8) {
            System.out.println("Mật khẩu chứa ít nhất 8 ký tự!");
            return false;
        }

        int countLowerCase = 0;
        int countUpperCase = 0;
        int countSpecialCharacter = 0;

        for (int  i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                countLowerCase++;
            } else if (Character.isUpperCase(password.charAt(i))) {
                countUpperCase++;
            }  else if (!Character.isLetterOrDigit(password.charAt(i))) {
                countSpecialCharacter++;
            }
        }

        if  (countLowerCase == 0) {
            System.out.println("Mật khẩu phải có ít nhất một chữ thường");
            return false;
        } else if (countUpperCase == 0) {
            System.out.println("Mật khẩu phải có ít nhất một chữ hoa");
            return false;
        } else if (countSpecialCharacter == 0) {
            System.out.println("Mật khẩu phải có ít nhất một ký tự đặt biệt");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mật khẩu của bạn: ");
        String password = sc.nextLine();

        if (checkPassword(password)) {
            System.out.println("Mật khẩu mạnh!");
        }
    }
}
