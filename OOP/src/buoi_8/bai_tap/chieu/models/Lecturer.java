package buoi_8.bai_tap.chieu.models;

import java.util.HashSet;

import static buoi_8.bai_tap.chieu.Main.sc;

public class Lecturer extends Teacher {
    private String subject;
    private final HashSet<Schedule> schedules = new HashSet<>();

    public Lecturer() {
    }

    public Lecturer(String id, String fullName, int age, String email, double teachingHours, String subject) {
        super(id, fullName, age, email, teachingHours);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (!subject.matches("[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+")) {
            throw new IllegalArgumentException(">>> Error: Tên môn học không được chứa ký tự đặt biệt!");
        }

        this.subject = subject;
    }

    public HashSet<Schedule> getSchedules() {
        return schedules;
    }

    public boolean addSchedule(Schedule schedule) {
        return schedules.add(schedule);
    }

    public void removeSchedule(String date) {
        schedules.removeIf(schedule -> schedule.getDay().equals(date));
    }

    @Override
    public void setId(String id) {
        super.setId("GV-00" + id);
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập bộ môn giảng dạy: ");
                setSubject(sc.nextLine().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public double getSalary() {
        return this.getTeachingHours() * 200000 * 1.1;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Môn giảng dạy: " + this.subject + "\n";
    }
}
