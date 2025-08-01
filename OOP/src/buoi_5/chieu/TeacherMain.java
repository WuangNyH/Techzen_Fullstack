package buoi_5.chieu;

import java.util.Scanner;

public class TeacherMain extends Teacher implements ITeacher {
    private String boMon;

    public TeacherMain() {
    }

    public TeacherMain(String id, String name, int age, String email, String boMon, Double soGioDay) {
        super(id, name, age, email, soGioDay);
        this.boMon = boMon;
    }

    @Override
    public void input(Scanner sc) {

        super.input(sc); // gọi phương thức input của lớp cha (Person)

        // Nhập bộ môn
        System.out.print("Nhập bộ môn giảng dạy: ");
        this.boMon = sc.nextLine().trim();
    }

    @Override
    public void setId(String id) {
        super.setId("GV-00" + id);
    }

    @Override
    public String toString() {
        return super.toString()
                + "Bộ môn: " + boMon + "\n";
    }

    @Override
    public double getSalary() {
        return getSoGioDay() * 200000 * 1.1;
    }
}
