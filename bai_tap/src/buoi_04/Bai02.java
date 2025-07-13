package buoi_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai02 {
    public static boolean checkPassword(String password) {
        password = password.trim();

        if (password.contains(" ")) {
            System.out.println("Mật khẩu không được chứa khoảng trắng!");
            return false;
        }

        if (password.length() < 8) {
            System.out.println("Mật khẩu phải chứa ít nhất 8 ký tự!");
            return false;
        }

        Pattern patternLowerCase = Pattern.compile("[a-z]");
        Pattern patternUpperCase = Pattern.compile("[A-Z]");
        Pattern patternNumber = Pattern.compile("\\d");
        Pattern patternSymbol = Pattern.compile("[^0-9A-Za-z]");

        Matcher matcherLowerCase = patternLowerCase.matcher(password);
        Matcher matcherUpperCase = patternUpperCase.matcher(password);
        Matcher matcherNumber = patternNumber.matcher(password);
        Matcher matcherSymbol = patternSymbol.matcher(password);

        if (!matcherLowerCase.find() ||  !matcherUpperCase.find() || !matcherNumber.find() || !matcherSymbol.find()) {
            System.out.println("Mật khẩu phải có ít nhất 1 chữ hoa, 1 chữ thường, 1 chữ số và 1 ký tự đặc biệt!");
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
