package buoi_8.bai_tap.chieu.models;

import static buoi_8.bai_tap.chieu.Main.sc;

public class StudentBE extends Student {
    private String progLanguage;

    public StudentBE() {
    }

    public StudentBE(String id, String fullName, int age, String email, double avgScore, int sessionNumber, String progLanguage) {
        super(id, fullName, age, email, avgScore, sessionNumber);
        this.progLanguage = progLanguage;
    }

    public String getProgLanguage() {
        return progLanguage;
    }

    public void setProgLanguage(String progLanguage) {
        if (!progLanguage.matches("[a-zA-Z0-9\\s]+")) {
            throw new IllegalArgumentException(">>> Error: Ngôn ngữ lập trình không được chứa ký tự đặt biệt!");
        }

        this.progLanguage = progLanguage;
    }

    @Override
    public void setId(String id) {
        super.setId("HVBE-00" + id);
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập ngôn ngữ lập trình: ");
                setProgLanguage(sc.nextLine().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getClassify() {
        if (this.getAvgScore() >= 7.5) {
            return "Giỏi";
        } else if (this.getAvgScore() >= 5) {
            return "Khá";
        } else {
            return "Trung Bình";
        }
    }

    @Override
    public double tuitionFee() {
        return this.getSessionNumber() * 50000 * 0.9;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Ngôn ngữ lập trình: " + this.progLanguage + "\n";
    }
}
