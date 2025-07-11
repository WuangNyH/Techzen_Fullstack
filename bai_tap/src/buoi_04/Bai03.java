package buoi_04;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        System.out.print("Nhập họ và tên của bạn: ");
        String name = sc.nextLine();

        String[] arr = name.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                output.append(arr[i].substring(0, 3).toUpperCase());
            } else if (i == arr.length - 1) {
                output.append(arr[i].toUpperCase());
            } else {
                output.append(arr[i].toUpperCase().charAt(0));
            }
        }

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalTime time = LocalTime.now();
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HHmmss");

        System.out.println(output + formatDate.format(date) + "T" + formatTime.format(time));
    }
}
