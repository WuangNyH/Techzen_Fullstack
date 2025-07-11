package buoi_04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Bai05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ngày bắt đầu làm việc: ");
        String strDate = sc.nextLine();

        StringBuilder output = new StringBuilder("=== Danh sách các thứ hai ===\n");
        LocalDate ldDate = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate now = LocalDate.now();

        long soTuan = ChronoUnit.WEEKS.between(ldDate, now);
        int count = 1;

        while (ldDate.isBefore(now)) {
            ldDate = ldDate.plusDays(1);

            if (ldDate.getDayOfWeek() == DayOfWeek.SATURDAY || ldDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                continue;
            }

            if (ldDate.getDayOfWeek() == DayOfWeek.MONDAY) {
                output.append("Monday: ");
                output.append(ldDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                output.append("\n");
            }

            count++;
        }

        System.out.println("Số ngày làm việc là " + count);
        System.out.println("Số tuần làm việc là " + soTuan);
        System.out.println(output);
    }
}
