package bai_string;

import java.util.Scanner;

public class Bai03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi thứ nhất: ");
        String firstStr = sc.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String secondStr = sc.nextLine();

        int compareStr = firstStr.compareToIgnoreCase(secondStr);

        String output = "Hai chuỗi bằng nhau";
        if (compareStr > 0) {
            output = "Chuỗi một lớn hơn";
        } else if (compareStr < 0) {
            output = "Chuỗi hai lớn hơn";
        }

        System.out.println(output);
    }
}
