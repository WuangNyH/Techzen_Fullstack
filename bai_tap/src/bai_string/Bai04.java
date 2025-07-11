package bai_string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Bai04 {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    }
}
