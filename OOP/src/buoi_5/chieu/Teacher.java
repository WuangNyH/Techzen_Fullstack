package buoi_5.chieu;

import java.util.Scanner;

public abstract class Teacher extends Person implements ITeacher {
    private Double soGioDay;

    public Teacher() {
    }

    public Teacher(String id, String name, int age, String email, Double soGioDay) {
        super(id, name, age, email);
        this.soGioDay = soGioDay;
    }

    public Double getSoGioDay() {
        return soGioDay;
    }

    public void setSoGioDay(Double soGioDay) {
        this.soGioDay = soGioDay;
    }

    @Override
    public void input(Scanner sc) {

        super.input(sc); // gọi phương thức input của lớp cha (Person)

        // Nhập số giờ dạy
        while (true) {
            System.out.print("Nhập số giờ dạy: ");
            if (sc.hasNextDouble()) {
                this.soGioDay = sc.nextDouble();
                if (this.soGioDay < 0) {
                    System.out.println("❌ Số giờ không hợp lệ! Phải >= 0.");
                    sc.nextLine(); // clear buffer
                    continue;
                }
                sc.nextLine(); // clear buffer
                break;
            } else {
                System.out.println("❌ Vui lòng nhập số thực!");
                sc.nextLine(); // clear buffer
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "Số giờ dạy: " + String.format("%.2f", this.soGioDay) + "\n"
                + "Lương: " + String.format("%.2f", this.getSalary()) + "\n";
    }

    public abstract double getSalary();
}
