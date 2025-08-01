package buoi_5.chieu;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherSupport extends Teacher implements ITeacher {
    private int soBuoiThucHanh;
    private final ArrayList<TeacherMain> teacherMains = new ArrayList<>();

    public TeacherSupport() {
    }

    public TeacherSupport(String id, String name, int age, String email, int soBuoiThucHanh, Double soGioDay) {
        super(id, name, age, email, soGioDay);
        this.soBuoiThucHanh = soBuoiThucHanh;
    }

    @Override
    public void input(Scanner sc) {

        super.input(sc);
        // Nhập số giờ dạy
        while (true) {
            System.out.print("Nhập số buổi thực hành: ");
            if (sc.hasNextInt()) {
                this.soBuoiThucHanh = sc.nextInt();
                if (this.soBuoiThucHanh < 0) {
                    System.out.println("❌ Số số buổi thực hành không hợp lệ! Phải >= 0.");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                break;
            } else {
                System.out.println("❌ Vui lòng nhập số thực!");
                sc.nextLine();
            }
        }
    }

    @Override
    public void setId(String id) {
        super.setId("TG-00" + id);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Giảng viên hỗ trợ: " + getIdTeacher();
    }

    @Override
    public double getSalary() {
        return this.getSoGioDay() * 100000;
    }

    public String getIdTeacher() {
        StringBuilder output = new StringBuilder();

        for (TeacherMain teacherMain : teacherMains) {
            output.append(teacherMain.getId()).append(" ");
        }
        return output.toString();
    }

    public ArrayList<TeacherMain> getTeachers() {
        return this.teacherMains;
    }

    public void setTeachers(TeacherMain teacherMain) {
        this.teacherMains.add(teacherMain);
    }
}
