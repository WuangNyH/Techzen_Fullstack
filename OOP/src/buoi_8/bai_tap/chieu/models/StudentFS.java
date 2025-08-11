package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidPositiveException;

import static buoi_8.bai_tap.chieu.Main.sc;

public class StudentFS extends Student {
    private int joinedProjects;

    public StudentFS() {
    }

    public StudentFS(String id, String fullName, int age, String email, double avgScore, int sessionNumber, int joinedProjects) {
        super(id, fullName, age, email, avgScore, sessionNumber);
        this.joinedProjects = joinedProjects;
    }

    public int getJoinedProjects() {
        return joinedProjects;
    }

    public void setJoinedProjects(int joinedProjects) {
        if (joinedProjects <= 0) {
            throw new InvalidPositiveException(">>> Error: Số dự án tham gia phải > 0!");
        }

        this.joinedProjects = joinedProjects;
    }

    @Override
    public void setId(String id) {
        super.setId("HVFS-00" + id);
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập số dự án tham gia: ");
                setJoinedProjects(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            } catch (InvalidPositiveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getClassify() {
        if (this.joinedProjects >= 2 && this.getAvgScore() >= 8) {
            return "Giỏi";
        } else if (this.getAvgScore() >= 6.5) {
            return "Khá";
        } else {
            return "Trung bình";
        }
    }

    @Override
    public double tuitionFee() {
        return this.getSessionNumber() * 50000 * 0.85;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Số dự án tham gia: " + this.joinedProjects + "\n";
    }
}
