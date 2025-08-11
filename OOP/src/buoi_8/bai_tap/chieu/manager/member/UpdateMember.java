package buoi_8.bai_tap.chieu.manager.member;

import buoi_8.bai_tap.chieu.models.Person;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.member.MemberManager.persons;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getMemberById;

public class UpdateMember {
    public static void updateMember() {
        if (persons.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có thành viên nào!");
            return;
        }

        System.out.print("Nhập ID thành viên muốn cập nhật: ");
        String id = sc.nextLine().trim();

        Person personToUpdate = getMemberById(id);

        if (personToUpdate == null) {
            System.out.println(">>> Error: Không tìm thấy thành viên với id " + id);
            return;
        }

        while (true) {
            try {
                System.out.print("Nhập tên mới: ");
                personToUpdate.setFullName(sc.nextLine().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập tuổi mới: ");
                personToUpdate.setAge(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập email mới: ");
                personToUpdate.setEmail(sc.nextLine().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Cập nhật thông tin thành viên thành công!");
    }
}
