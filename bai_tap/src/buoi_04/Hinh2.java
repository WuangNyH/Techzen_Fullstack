package buoi_04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Hinh2 {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

        String strDate = "02/28/2023";

        // Câu a
        Date date = sdf.parse(strDate);
        System.out.println("Câu a: " + date);

        // Câu b
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println("Câu b: " + sdf2.format(date2));

        // Câu c
        LocalDate localDate = LocalDate.parse(strDate, dtf);
        System.out.println("Câu c: " + localDate);

        // Câu d
        LocalDate localDate2 = LocalDate.now();
        System.out.println("Câu d: " + dtf2.format(localDate2));

        // Câu e
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Câu e: " + formatDateTime.format(localDateTime));

        // Câu f
        System.out.println("Câu f");
        LocalDate localDate3 = localDate2.plusMonths(1);
        System.out.println("Một tháng sau (tính từ ngày hiện tại) sẽ rơi vào thứ " + localDate3.format(DateTimeFormatter.ofPattern("EEEE")));
        System.out.println("Cách ngày hiện tại " + ChronoUnit.DAYS.between(localDate2, localDate3));

        // Câu g
        LocalDate localDate4 = localDate2.plusDays(1000);
        System.out.println("Câu g: " + dtf2.format(localDate4));

        // Câu h
        System.out.println("Câu h");
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập một ngày bất kỳ (dd/MM/yyyy): ");
        String firstDay = sc.nextLine();

        System.out.print("Nhập một ngày bất kỳ (dd/MM/yyyy): ");
        String secondDay = sc.nextLine();

        LocalDate firstDayDate = LocalDate.parse(firstDay, dtf2);
        LocalDate secondDayDate = LocalDate.parse(secondDay, dtf2);

        System.out.println(dtf2.format(firstDayDate) + " cách ngày " + dtf2.format(secondDayDate) + " " + ChronoUnit.DAYS.between(firstDayDate, secondDayDate));

        // Câu i
        System.out.print("Nhập một ngày bất kỳ (dd/MM/yyyy): ");
        String date3 = sc.nextLine();

        System.out.print("Số ngày cần tính: ");
        int n = sc.nextInt();

        LocalDate localDate5 = LocalDate.parse(date3, dtf2);
        System.out.printf("Ngày đứng sau ngày %s %d ngày là %s", dtf2.format(localDate5), n, dtf2.format(localDate5.plusDays(n)));

    }
}
