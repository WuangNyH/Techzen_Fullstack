package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.models.Student;
import buoi_8.bai_tap.chieu.models.StudentBE;
import buoi_8.bai_tap.chieu.models.StudentFS;

import java.util.ArrayList;
import java.util.Collections;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class SortStudentByAvg {
    public static void menuSortByAvg() {
        System.out.println(">> SẮP XẾP THEO ĐIỂM TB <<");
        System.out.println("++ ---------------------------------------------- ++");
        System.out.printf("| 1. %-45s |\n", "Học viên BE");
        System.out.printf("| 2. %-45s |\n", "Học viên FS");
        System.out.printf("| 3. %-45s |\n", "Về menu quản lý thành viên");
        System.out.println("++ ---------------------------------------------- ++");
    }

    public static void sortStudentByAvg() {
        while (true) {
            try {
                menuSortByAvg();
                System.out.print("Lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> sortStudents(StudentBE.class);
                    case 2 -> sortStudents(StudentFS.class);
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static <T extends Student> void sortStudents(Class<T> type) {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        ArrayList<T> filteredList = getListMember(type);
        if (filteredList.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có học viên!");
            return;
        }

        while (true) {
            try {
                System.out.println("++ ---------------------------------------------- ++");
                System.out.printf("| 1. %-45s |\n", "Tăng dần theo điểm trung bình");
                System.out.printf("| 2. %-45s |\n", "Giảm dần theo điểm trung bình");
                System.out.println("++ ---------------------------------------------- ++");
                System.out.print("Chọn cách sắp xếp: ");
                int choose = Integer.parseInt(sc.nextLine());

                if (choose == 1) {
                    Collections.sort(filteredList);
                    break;
                } else if (choose == 2) {
                    filteredList.sort(Collections.reverseOrder());
                    break;
                } else {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo điểm trung bình -----");
        int count = 1;
        for (T student : filteredList) {
            System.out.println("Học viên thứ " + count++);

            System.out.println("ID: " + student.getId());
            System.out.println("Tên: " + student.getFullName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Điểm trung bình: " + student.getAvgScore());
            System.out.println("Xếp loại: " + student.getClassify());
            System.out.println("----------------------------");
        }
    }
}
