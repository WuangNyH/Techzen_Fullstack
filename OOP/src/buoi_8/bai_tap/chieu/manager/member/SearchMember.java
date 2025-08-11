package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.models.Person;

import java.util.ArrayList;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.printListMember;

public class SearchMember {
    public static void findMember() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        System.out.print("Nhập từ khóa cần tìm (họ tên hoặc email): ");
        String keyword = sc.nextLine().trim().toLowerCase();

        ArrayList<Person> output = new ArrayList<>();

        for (Person person : persons.values()) {
            if (person.getFullName().toLowerCase().contains(keyword) || person.getEmail().toLowerCase().contains(keyword)) {
                output.add(person);
            }
        }

        if (output.isEmpty()) {
            System.out.println(">>> Error: Không tìm thấy thành viên nào với keyword: " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm với keyword : " + keyword);
            printListMember(output);
        }
    }
}
