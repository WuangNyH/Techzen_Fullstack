package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.Course;
import buoi_8.bai_tap.chieu.models.Student;

import java.util.ArrayList;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.courses;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class AddStudentToClass {
    public static void addStudentToClass() {
        ArrayList<Student> students = getListMember(Student.class);
        if (courses.isEmpty()) {
            System.out.println(">>> Error: Hiện chưa có lớp học nào.");
            return;
        }

        if (students.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có học viên nào!");
            return;
        }

        ArrayList<Course> coursesList = new ArrayList<>(courses.values());

        System.out.println("==== DANH SÁCH LỚP HỌC ====");
        int choice;
        while (true) {
            try {
                for (int i = 0; i < coursesList.size(); i++) {
                    System.out.println((i + 1) + ". " + coursesList.get(i).getId() + " - " + coursesList.get(i).getName());
                }

                System.out.print("Chọn lớp học để thêm học viên: ");
                choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > courses.size()) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
        Course selectedCourse = coursesList.get(choice - 1);

        while (true) {
            try {
                System.out.println("==== DANH SÁCH HỌC VIÊN ====");
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (selectedCourse.getStudents().contains(student)) {
                        System.out.printf("%d. %s - %s - Đã tham gia\n", i + 1, students.get(i).getId(), students.get(i).getFullName());
                    } else {
                        System.out.printf("%d. %s - %s\n", i + 1, students.get(i).getId(), students.get(i).getFullName());
                    }
                }
                System.out.println((students.size() + 1) + ". Dừng chọn");

                System.out.print("Chọn học viên để thêm: ");
                int studentChoice = Integer.parseInt(sc.nextLine());

                if (studentChoice < 1 || studentChoice > students.size() + 1) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }

                if (studentChoice == students.size() + 1) {
                    System.out.println("Hoàn thành thêm học viên.");
                    return;
                }

                Student selectedStudent = students.get(studentChoice - 1);
                if (selectedCourse.addStudents(selectedStudent)) {
                    System.out.printf("Đã thêm học viên %s vào lớp %s.\n", selectedStudent.getFullName(), selectedCourse.getName());
                } else {
                    System.out.printf(">>> Error: Học viên %s đã tham gia lớp %s\n", selectedStudent.getFullName(), selectedCourse.getName());
                }

            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }
}
