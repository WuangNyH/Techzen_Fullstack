package buoi_2.thuc_hanh;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println(">> LỰA CHỌN CHỨC NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Thêm sinh viên mới                       |");
        System.out.println("| 2. Hiện danh sách tất cả sinh viên          |");
        System.out.println("| 3. Tìm sinh viên theo tên                   |");
        System.out.println("| 4. Hiện thị tổng số sinh viên               |");
        System.out.println("| 5. Sinh viên có điểm cao nhất               |");
        System.out.println("| 6. Sinh viên có điểm dưới trung bình ( < 5) |");
        System.out.println("| 7. Exit                                     |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
    }
}
