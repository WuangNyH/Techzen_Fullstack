package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.Course;
import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.Schedule;

import java.util.ArrayList;
import java.util.HashSet;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.courses;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.schedules;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class GetCourseSchedule {
    public static void showCourses() {
        if (courses.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có lớp học nào!");
            return;
        }

        System.out.println("Danh sách lớp học");
        for (Course c : courses.values()) {
            System.out.println(c);
        }
    }

    public static void showSchedule() {
        if (schedules.isEmpty()) {
            System.out.println("Hiện tại chưa có lịch dạy!");
            return;
        }

        System.out.println("Danh sách lịch dạy: ");
        for (Schedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

    public static void findCourseById() {
        if (courses.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có khóa học nào!");
            return;
        }

        System.out.print("Nhập ID khóa học cần tìm: ");
        String id = sc.nextLine().trim();
        Course course = courses.get(id);

        if (course == null) {
            System.out.println(">>> Error: Không tìm thấy khóa học với id " + id);
            return;
        }

        System.out.println("Thông tin khóa học cần tìm: ");
        System.out.println(course);
        System.out.println("----------------------------");
    }

    public static void printScheduleOfLecture() {
        ArrayList<Lecturer> teachers = getListMember(Lecturer.class);
        if (teachers.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có giảng viên nào!");
            return;
        }

        System.out.println("==== DANH SÁCH GIẢNG VIÊN ====");
        int choice;
        while (true) {
            try {
                for (int i = 0; i < teachers.size(); i++) {
                    System.out.println((i + 1) + ". " + teachers.get(i).getId() + " - " + teachers.get(i).getFullName());
                }

                System.out.print("Chọn giảng viên: ");
                choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > teachers.size()) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
        Lecturer lecturerSelected = teachers.get(choice - 1);

        HashSet<Schedule> schedules = lecturerSelected.getSchedules();

        if (schedules.isEmpty()) {
            System.out.println("Giảng viên " + lecturerSelected.getFullName() + " không có lịch dạy!");
            return;
        }

        System.out.println("Lịch dạy của " + lecturerSelected.getFullName());
        for (Schedule schedule : lecturerSelected.getSchedules()) {
            System.out.println(schedule);
        }
    }
}
