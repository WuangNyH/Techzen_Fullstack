package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.models.StudentBE;
import buoi_8.bai_tap.chieu.models.StudentFS;
import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.TeachingAssistant;
import buoi_8.bai_tap.chieu.models.Person;

import java.util.ArrayList;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class AddMember {
    public static void addMemberMenu() {
        System.out.println(">> THÊM THÀNH VIEN <<");
        System.out.println("++ ---------------------------------------------- ++");
        System.out.printf("| 1. %-45s |\n", "Học viên BE");
        System.out.printf("| 2. %-45s |\n", "Học viên FS");
        System.out.printf("| 3. %-45s |\n", "Giảng viên");
        System.out.printf("| 4. %-45s |\n", "Trợ giảng");
        System.out.printf("| 5. %-45s |\n", "Về menu quản lý thành viên");
        System.out.println("++ ---------------------------------------------- ++");
    }

    public static void addMember() {
        while (true) {
            try {
                addMemberMenu();
                System.out.print("Bạn muốn thêm thành viên nào: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        StudentBE newStudentBE = new StudentBE();
                        addNewMember(newStudentBE);
                        break;
                    case 2:
                        StudentFS newStudentFS = new StudentFS();
                        addNewMember(newStudentFS);
                        break;
                    case 3:
                        Lecturer newLecturer = new Lecturer();
                        addNewMember(newLecturer);
                        break;
                    case 4:
                        ArrayList<Lecturer> lecturers = getListMember(Lecturer.class);
                        if (lecturers.isEmpty()) {
                            System.out.println(">>> Error: Ít nhất phải có 1 giảng viên để thực hiện thêm trợ giảng!");
                            break;
                        }

                        TeachingAssistant newTeachingAssistant = new TeachingAssistant();
                        addNewMember(newTeachingAssistant);
                        addLecturerForAssistant(newTeachingAssistant, lecturers);
                        break;
                    case 5:
                        return;
                    case 6:
                        System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static String getRandomIdentify() {
        int number = (int) (Math.random() * 1000);
        return String.format("%03d", number);
    }

    private static <T extends Person> void addNewMember(T person) {
        do {
            person.setId(getRandomIdentify());
        } while (persons.containsKey(person.getId()));
        person.input();
        persons.put(person.getId(), person);
        System.out.println("Thêm thành viên mới thành công!\n");
    }

    private static void addLecturerForAssistant(TeachingAssistant ta, ArrayList<Lecturer> lecturers) {
        while (!lecturers.isEmpty()) {
            System.out.print("Giảng viện hổ trợ: ");
            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                if (ta.getLecturers().contains(lecturer)) {
                    System.out.println((i + 1) + ". " + lecturer.getId() + ": " + lecturer.getFullName() + " - Đang hỗ trợ");
                } else {
                    System.out.println((i + 1) + ". " + lecturer.getId() + ": " + lecturer.getFullName());
                }
            }
            System.out.println((lecturers.size() + 1) + ". " + "Dừng chọn.");

            System.out.println("Chọn GV: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == lecturers.size() + 1) {
                break;
            }

            if (choice < 1 || choice > lecturers.size() + 1) {
                System.out.println("Lựa chọn không hợp lệ!\n");
                continue;
            }

            if (!ta.addLecture(lecturers.get(choice - 1))) {
                System.out.println(">>> Error: Trợ giảng đang hỗ trợ giảng viên này!");
            }
        }
    }
}
