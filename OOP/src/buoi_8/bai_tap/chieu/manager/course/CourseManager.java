package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.*;

import java.util.ArrayList;
import java.util.HashMap;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.AddCourseSchedule.addNewCourse;
import static buoi_8.bai_tap.chieu.manager.course.AddCourseSchedule.addSchedule;
import static buoi_8.bai_tap.chieu.manager.course.AddScheduleToLecture.addScheduleToLecture;
import static buoi_8.bai_tap.chieu.manager.course.AddStudentToClass.addStudentToClass;
import static buoi_8.bai_tap.chieu.manager.course.DeleteSchedule.deleteSchedule;
import static buoi_8.bai_tap.chieu.manager.course.GetCourseSchedule.*;

public class CourseManager {
    static HashMap<String, Course> courses = new HashMap<>();
    static ArrayList<Schedule> schedules = new ArrayList<>();

    public static void memberMenu() {
        System.out.println(">> QUẢN LÝ KHÓA HỌC <<");
        System.out.println("++ ---------------------------------------------- ++");
        System.out.printf("|  1. %-45s |\n", "Thêm lớp học");
        System.out.printf("|  2. %-45s |\n", "Thêm lịch dạy");
        System.out.printf("|  3. %-45s |\n", "Hiển thị lớp học");
        System.out.printf("|  4. %-45s |\n", "Hiển thị lịch dạy");
        System.out.printf("|  5. %-45s |\n", "Thêm học viên vào lớp học");
        System.out.printf("|  6. %-45s |\n", "Chọn lịch dạy cho giảng viên");
        System.out.printf("|  7. %-45s |\n", "Xóa lịch dạy theo ngày");
        System.out.printf("|  8. %-45s |\n", "Tìm lớp học theo mã lớp");
        System.out.printf("|  9. %-45s |\n", "Hiện lịch dạy của giảng viên");
        System.out.printf("| 10. %-45s |\n", "Về màn hình chính");
        System.out.println("++ ---------------------------------------------- ++");
    }

    public static void courseManager() {
        while (true) {
            try {
                memberMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> addNewCourse();
                    case 2 -> addSchedule();
                    case 3 -> showCourses();
                    case 4 -> showSchedule();
                    case 5 -> addStudentToClass();
                    case 6 -> addScheduleToLecture();
                    case 7 -> deleteSchedule();
                    case 8 -> findCourseById();
                    case 9 -> printScheduleOfLecture();
                    case 10 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }


}
