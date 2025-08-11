package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidPositiveException;
import buoi_8.bai_tap.chieu.exceptions.InvalidScoreException;

import static buoi_8.bai_tap.chieu.Main.sc;

public abstract class Student extends Person implements Comparable<Student> {
    private double avgScore;
    private int sessionNumber;

    public Student() {
    }

    public Student(String id, String fullName, int age, String email, double avgScore, int sessionNumber) {
        super(id, fullName, age, email);
        this.avgScore = avgScore;
        this.sessionNumber = sessionNumber;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        if (avgScore < 0 || avgScore > 10) {
            throw new InvalidScoreException(">>> Error: Điểm trung bình phải từ 0-10!");
        }

        this.avgScore = avgScore;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        if (sessionNumber <= 0) {
            throw new InvalidPositiveException(">>> Error: Số buổi học phải > 0!");
        }

        this.sessionNumber = sessionNumber;
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập điểm trung bình: ");
                setAvgScore(Double.parseDouble(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số thực!");
            } catch (InvalidScoreException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập số buổi học: ");
                setSessionNumber(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            } catch (InvalidPositiveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public abstract String getClassify();

    public abstract double tuitionFee();

    @Override
    public String toString() {
        return super.toString()
                + "Điểm TB: " + this.avgScore + "\n"
                + "Số buổi học: " + this.sessionNumber + "\n"
                + "Xếp loại: " + this.getClassify() + "\n"
                + "Học phí: " + String.format("%,.2fVND", this.tuitionFee()) + "\n";
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.avgScore, student.getAvgScore());
    }
}
