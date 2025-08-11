package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.Person;
import buoi_8.bai_tap.chieu.models.TeachingAssistant;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getMemberById;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;

public class DeleteMember {
    public static void deleteMember() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        System.out.print("Nhập ID thành viên muốn xóa: ");
        String id = sc.nextLine().trim();

        Person personToDelete = getMemberById(id);

        if (personToDelete == null) {
            System.out.println(">>> Error: Không tìm thấy thành viên với id " + id);
            return;
        }

        if (personToDelete instanceof Lecturer) {
            for (Person p : persons.values()) {
                if (p instanceof TeachingAssistant ta) {
                    ta.removeLecture((Lecturer) personToDelete);
                }
            }
        }
        persons.remove(personToDelete.getId());

        System.out.println("Đã xóa thành viên thành công.");
    }
}
