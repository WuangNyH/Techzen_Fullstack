package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidPositiveException;

import static buoi_8.bai_tap.chieu.Main.sc;

public abstract class Teacher extends Person {
    private double teachingHours;

    public Teacher() {
    }

    public Teacher(String id, String fullName, int age, String email, double teachingHours) {
        super(id, fullName, age, email);
        this.teachingHours = teachingHours;
    }

    public double getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(double teachingHours) {
        if (teachingHours < 0) {
            throw new InvalidPositiveException(">>> Error: Số giờ dạy phải >= 0!");
        }

        this.teachingHours = teachingHours;
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập số giờ dạy: ");
                setTeachingHours(Double.parseDouble(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số thực!");
            } catch (InvalidPositiveException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public abstract double getSalary();

    @Override
    public String toString() {
        return super.toString()
                + "Số giờ dạy: " + String.format("%.2f", this.teachingHours) + "\n"
                + "Lương: " + String.format("%,.2fVND", this.getSalary()) + "\n";
    }
}
