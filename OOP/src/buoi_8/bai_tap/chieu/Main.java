package buoi_8.bai_tap.chieu;

import java.util.Scanner;

import static buoi_8.bai_tap.chieu.manager.member.MemberManager.memberManager;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.courseManager;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println(">> QUẢN LÝ ACADEMY <<");
        System.out.println("++ ---------------------------------------------- ++");
        System.out.printf("| 1. %-45s |\n", "Quản lý thành viên");
        System.out.printf("| 2. %-45s |\n", "Quản lý khóa học");
        System.out.printf("| 3. %-45s |\n", "Thoát chương trình");
        System.out.println("++ ---------------------------------------------- ++");
    }

    public static void main(String[] args) {
        while (true) {
            try {
                mainMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> memberManager();
                    case 2 -> courseManager();
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương!");
            }
        }
    }
}
