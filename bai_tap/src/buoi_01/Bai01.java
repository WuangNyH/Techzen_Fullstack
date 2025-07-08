package buoi_01;

import java.time.Year;
import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input your year born: ");
        int year = sc.nextInt();

        int age = Year.now().getValue() - year;
        System.out.print("Your age: " + age);

        sc.close();
    }
}
