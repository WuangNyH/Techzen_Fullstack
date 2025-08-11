package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.exceptions.MemberNotFoundException;
import buoi_8.bai_tap.chieu.models.*;

import java.util.ArrayList;
import java.util.HashMap;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.AddMember.addMember;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getMember;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getMemberById;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.findMemberById;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.printListMember;
import static buoi_8.bai_tap.chieu.manager.member.SearchMember.findMember;
import static buoi_8.bai_tap.chieu.manager.member.UpdateMember.updateMember;
import static buoi_8.bai_tap.chieu.manager.member.DeleteMember.deleteMember;
import static buoi_8.bai_tap.chieu.manager.member.SortStudentByAvg.sortStudentByAvg;

public class MemberManager {
    static HashMap<String, Person> persons = new HashMap<>();

    private static void initializeSampleData() {
        // Create Lecturers first (for Teaching Assistants to reference)
        Lecturer lecturer1 = new Lecturer("L001", "Dr. John Smith", 45, "john.smith@university.edu",
                40, "Computer Science");
        Lecturer lecturer2 = new Lecturer("L002", "Prof. Sarah Johnson", 38, "sarah.johnson@university.edu",
                35, "Software Engineering");
        Lecturer lecturer3 = new Lecturer("L003", "Dr. Michael Brown", 42, "michael.brown@university.edu",
                38, "Database Systems");

        // Add Backend Students
        StudentBE be1 = new StudentBE("BE001", "Alice Chen", 22, "alice.chen@student.edu", 8.7, 45, "Java");
        StudentBE be2 = new StudentBE("BE002", "Bob Wilson", 23, "bob.wilson@student.edu", 7.2, 42, "Python");
        StudentBE be3 = new StudentBE("BE003", "Charlie Davis", 21, "charlie.davis@student.edu", 6.8, 38, "C#");
        StudentBE be4 = new StudentBE("BE004", "Diana Lee", 24, "diana.lee@student.edu", 9.1, 48, "Java");

        persons.put(be1.getId(), be1);
        persons.put(be2.getId(), be2);
        persons.put(be3.getId(), be3);
        persons.put(be4.getId(), be4);

        // Add Fullstack Students
        StudentFS fs1 = new StudentFS("FS001", "Eva Martinez", 23, "eva.martinez@student.edu", 8.3, 50, 3);
        StudentFS fs2 = new StudentFS("FS002", "Frank Thompson", 22, "frank.thompson@student.edu", 7.9, 47, 2);
        StudentFS fs3 = new StudentFS("FS003", "Grace Kim", 25, "grace.kim@student.edu", 8.8, 52, 5);
        StudentFS fs4 = new StudentFS("FS004", "Henry Garcia", 24, "henry.garcia@student.edu", 6.5, 44, 1);

        persons.put(fs1.getId(), fs1);
        persons.put(fs2.getId(), fs2);
        persons.put(fs3.getId(), fs3);
        persons.put(fs4.getId(), fs4);

        // Add Lecturers
        persons.put(lecturer1.getId(), lecturer1);
        persons.put(lecturer2.getId(), lecturer2);
        persons.put(lecturer3.getId(), lecturer3);

        // Add Teaching Assistants
        TeachingAssistant ta1 = new TeachingAssistant("TA001", "Ivan Petrov", 26,
                "ivan.petrov@university.edu", 20, 15);
        ta1.addLecture(lecturer1);
        ta1.addLecture(lecturer2);

        TeachingAssistant ta2 = new TeachingAssistant("TA002", "Julia Wang", 25,
                "julia.wang@university.edu", 18, 12);
        ta2.addLecture(lecturer2);
        ta2.addLecture(lecturer3);

        persons.put(ta1.getId(), ta1);
        persons.put(ta2.getId(), ta2);
    }

    public static void memberMenu() {
        System.out.println(">> QUẢN LÝ THÀNH VIÊN <<");
        System.out.println("++ ----------------------------------------------- ++");
        System.out.printf("|  1. %-45s |\n", "Thêm thành viên");
        System.out.printf("|  2. %-45s |\n", "Hiển thị danh sách thành viên");
        System.out.printf("|  3. %-45s |\n", "Tìm kiếm thành viên theo tên hoặc email");
        System.out.printf("|  4. %-45s |\n", "Tìm thành viên theo ID");
        System.out.printf("|  5. %-45s |\n", "Cập nhật thông tin cho thành viên");
        System.out.printf("|  6. %-45s |\n", "Xóa thành viên");
        System.out.printf("|  7. %-45s |\n", "Sắp xếp học viên theo điểm trung bình");
        System.out.printf("|  8. %-45s |\n", "Tính học phí của học viên");
        System.out.printf("|  9. %-45s |\n", "Tính lương của giảng viên");
        System.out.printf("| 10. %-45s |\n", "Tìm kiếm giảng viên có bao nhiêu trợ giảng");
        System.out.printf("| 11. %-45s |\n", "Về màn hình chính");
        System.out.println("++ ----------------------------------------------- ++");
    }

    public static void memberManager() {
        initializeSampleData();
        while (true) {
            try {
                memberMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> addMember();
                    case 2 -> getMember();
                    case 3 -> findMember();
                    case 4 -> {
                        try {
                            findMemberById();
                        } catch (MemberNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 5 -> updateMember();
                    case 6 -> deleteMember();
                    case 7 -> sortStudentByAvg();
                    case 8 -> getTuitionStudent();
                    case 9 -> getSalaryTeacher();
                    case 10 -> findSupportsOfTeacher();
                    case 11 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }


    // Tính học phí của học viên
    public static void getTuitionStudent() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại không có thành viên nào!");
            return;
        }

        while (true) {
            try {
                System.out.println(">> TÍNH HỌC PHÍ HỌC VIÊN <<");
                System.out.println("++ ---------------------------------------------- ++");
                System.out.printf("| 1. %-45s |\n", "Học viên BE");
                System.out.printf("| 2. %-45s |\n", "Học viên FS");
                System.out.printf("| 3. %-45s |\n", "Tất cả học viên");
                System.out.printf("| 4. %-45s |\n", "Về menu quản lý thành viên");
                System.out.println("++ ---------------------------------------------- ++");

                System.out.print("Lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> System.out.printf("Tổng học phí HV Backend %,.2fVND\n", totalTuition(StudentBE.class));
                    case 2 -> System.out.printf("Tổng học phí HV Fullstack %,.2fVND\n", totalTuition(StudentFS.class));
                    case 3 -> System.out.printf("Tổng học phí tất cả học viên %,.2fVND\n", totalTuition(Student.class));
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static <T extends Student> double totalTuition(Class<T> type) {
        double sum = 0;
        for (Person person : persons.values()) {
            if (type.isInstance(person)) {
                T student = type.cast(person);
                sum += student.tuitionFee();
            }
        }
        return sum;
    }


    // Tính lương của giảng viên và trợ giảng
    public static <T extends Teacher> double totalSalary(Class<T> type) {
        double totalSalary = 0;
        for (Person person : persons.values()) {
            if (type.isInstance(person)) {
                T teacher = type.cast(person);
                totalSalary += teacher.getSalary();
            }
        }
        return totalSalary;
    }

    public static void getSalaryTeacher() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại không có thành viên nào!");
            return;
        }

        while (true) {
            try {
                System.out.println(">> TÍNH LƯƠNG GIẢNG VIÊN <<");
                System.out.println("++ ---------------------------------------------- ++");
                System.out.printf("| 1. %-45s |\n", "Giảng viên");
                System.out.printf("| 2. %-45s |\n", "Trợ giảng");
                System.out.printf("| 3. %-45s |\n", "Tất cả");
                System.out.printf("| 4. %-45s |\n", "Về menu quản lý thành viên");
                System.out.println("++ ---------------------------------------------- ++");

                System.out.print("Lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> System.out.printf("Tổng lương giảng viên %,.2fVND\n", totalSalary(Lecturer.class));
                    case 2 -> System.out.printf("Tổng lương TG %,.2fVND\n", totalSalary(TeachingAssistant.class));
                    case 3 -> System.out.printf("Tổng lương của nhân sự %,.2fVND\n", totalSalary(Teacher.class));
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    // Tìm giảng viên có bao nhiêu trợ giảng
    private static void findSupportsOfTeacher() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        System.out.print("Nhập ID giảng viên muốn tra cứu: ");
        String id = sc.nextLine().trim();

        Lecturer foundLecturer = (Lecturer) getMemberById(id);

        if (foundLecturer == null) {
            System.out.println(">>> Error: Không tìm thấy giảng viên với id " + id);
            return;
        }

        ArrayList<TeachingAssistant> teachingAssistants = new ArrayList<>();
        for (Person p : persons.values()) {
            if (p instanceof TeachingAssistant ta) {
                for (Lecturer lt : ta.getLecturers()) {
                    if (lt.equals(foundLecturer)) {
                        teachingAssistants.add(ta);
                        break;
                    }
                }
            }
        }

        if (teachingAssistants.isEmpty()) {
            System.out.println("Giảng viên " + foundLecturer.getFullName() + " không có trợ giảng nào!");
            return;
        }

        System.out.printf("Số lượng trợ giảng hỗ trợ của %s: %d trợ giảng\n", foundLecturer.getFullName(), teachingAssistants.size());
        printListMember(teachingAssistants);
    }

    public static void main(String[] args) {
        memberManager();
    }

}
