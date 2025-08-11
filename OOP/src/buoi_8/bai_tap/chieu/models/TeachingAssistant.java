package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidPositiveException;

import java.util.HashSet;

import static buoi_8.bai_tap.chieu.Main.sc;

public class TeachingAssistant extends Teacher {
    private int practiceSessions;
    private final HashSet<Lecturer> lecturers = new HashSet<>();

    public TeachingAssistant() {
    }

    public TeachingAssistant(String id, String fullName, int age, String email, double teachingHours, int practiceSessions) {
        super(id, fullName, age, email, teachingHours);
        this.practiceSessions = practiceSessions;
    }

    public int getPracticeSessions() {
        return practiceSessions;
    }

    public void setPracticeSessions(int practiceSessions) {
        if (practiceSessions < 0) {
            throw new InvalidPositiveException(">>> Error: Số buổi thực hành phải >= 0!");
        }

        this.practiceSessions = practiceSessions;
    }

    public HashSet<Lecturer> getLecturers() {
        return lecturers;
    }

    public boolean addLecture(Lecturer lecturer) {
        return this.lecturers.add(lecturer);
    }

    public void removeLecture(Lecturer lecturer) {
        this.lecturers.remove(lecturer);
    }

    @Override
    public void setId(String id) {
        super.setId("TG-00" + id);
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập số buổi thực hành: ");
                setPracticeSessions(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên đương!");
            } catch (InvalidPositiveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public double getSalary() {
        return this.getTeachingHours() * 100000;
    }

    public String getIdTeacher() {
        StringBuilder output = new StringBuilder();

        for (Lecturer lecturer : lecturers) {
            output.append(lecturer.getId()).append(" ");
        }
        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (lecturers.isEmpty()) {
            output.append("Chưa có giảng viên hỗ trợ");
        } else {
            output.append("\n");
            for (Lecturer lecturer : lecturers) {
                output.append("\t").append("+ ").append(lecturer.getId()).append(": ").append(lecturer.getFullName()).append("\n");
            }
        }

        return super.toString()
                + "Giảng viên hỗ trợ: " + output;
    }
}
