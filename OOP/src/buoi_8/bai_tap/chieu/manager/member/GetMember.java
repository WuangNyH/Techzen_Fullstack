package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.exceptions.MemberNotFoundException;
import buoi_8.bai_tap.chieu.models.StudentBE;
import buoi_8.bai_tap.chieu.models.StudentFS;
import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.TeachingAssistant;
import buoi_8.bai_tap.chieu.models.Person;

import java.util.ArrayList;
import java.util.Collection;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;

public class GetMember {
    public static void getMemberMenu() {
        System.out.println(">> HIỆN THỊ THÀNH VIÊN <<");
        System.out.println("++ ---------------------------------------------- ++");
        System.out.printf("| 1. %-45s |\n", "Học viên BE");
        System.out.printf("| 2. %-45s |\n", "Học viên FS");
        System.out.printf("| 3. %-45s |\n", "Giảng viên");
        System.out.printf("| 4. %-45s |\n", "Trợ giảng");
        System.out.printf("| 5. %-45s |\n", "Tất cả");
        System.out.printf("| 6. %-45s |\n", "Về menu quản lý thành viên");
        System.out.println("++ ---------------------------------------------- ++");
    }

    public static void getMember() {
        while (true) {
            try {
                getMemberMenu();
                System.out.print("Bạn muốn thêm thành viên nào: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> printListMember(getListMember(StudentBE.class));
                    case 2 -> printListMember(getListMember(StudentFS.class));
                    case 3 -> printListMember(getListMember(Lecturer.class));
                    case 4 -> printListMember(getListMember(TeachingAssistant.class));
                    case 5 -> printListMember(persons.values());
                    case 6 -> {
                        return;
                    }
                    default -> System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static <T extends Person> ArrayList<T> getListMember(Class<T> type) {
        ArrayList<T> list = new ArrayList<>();

        for (Person person : persons.values()) {
            if (type.isInstance(person)) {
                list.add(type.cast(person));
            }
        }

        return list;
    }

    public static <T extends Person> void printListMember(Collection<T> list) {
        if (list.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        int count = 1;
        for (Person person : list) {
            System.out.println("Thông tin người thứ " + count++ + ": ");
            System.out.println(person);
            System.out.println("----------------------------");
        }
    }

    public static Person getMemberById(String id) {
        if (persons.isEmpty()) {
            return null;
        }
        return persons.get(id);
    }

    public static void findMemberById() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        System.out.print("Nhập ID thành viên cần tìm: ");
        String id = sc.nextLine().trim();
        Person person = getMemberById(id);

        if (person == null) {
            throw new MemberNotFoundException(">>> Error: Không tìm thấy thành viên với id " + id);
        }

        System.out.println("Thông tin thành viên cần tìm: ");
        System.out.println(person);
        System.out.println("----------------------------");
    }
}
