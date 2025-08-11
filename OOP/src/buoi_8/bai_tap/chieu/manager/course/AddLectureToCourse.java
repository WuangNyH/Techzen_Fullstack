package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.exceptions.TeacherNotFoundException;
import buoi_8.bai_tap.chieu.models.Course;
import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.Person;

import java.util.ArrayList;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.courses;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getMemberById;

public class AddLectureToCourse {
    public static void addLectureToCourse() {
        if (courses.isEmpty()) {
            System.out.println(">>> Error: Hiện tại không có lớp học!");
            return;
        }

        ArrayList<Course> coursesNotHaveLecture = new ArrayList<>();
        for (Course c : courses.values()) {
            if (c.getLecturer() == null) {
                coursesNotHaveLecture.add(c);
            }
        }

        if (coursesNotHaveLecture.isEmpty()) {
            System.out.println(">>> Error: Hiện tại mọi lớp học đều có giảng viên!");
            return;
        }

        Course selectedCourse;
        while (true) {
            try {
                System.out.println("==== Danh sách khóa học ====");
                for (int i = 0; i < coursesNotHaveLecture.size(); i++) {
                    Course c = coursesNotHaveLecture.get(i);
                    System.out.println((i + 1) + ". " + c.getId() + " - " + c.getName());
                }

                System.out.print("Lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > courses.size()) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }

                selectedCourse = coursesNotHaveLecture.get(choice - 1);
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }

        System.out.print("Nhập ID giảng viên: ");
        String id = sc.nextLine().trim();

        Person lecturer = getMemberById(id);

        if (lecturer == null) {
            throw new TeacherNotFoundException(">>> Error: Không tìm thấy giảng viên với id " + id);
        }

        if (!(lecturer instanceof Lecturer)) {
            throw new TeacherNotFoundException(">>> Error: ID nhập vào không phải là giảng viên");
        }

        selectedCourse.setLecturer((Lecturer) lecturer);
        System.out.println("Thêm giảng viên vào lớp học thành công!");
    }
}
