package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.NullOrEmptyException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import static buoi_8.bai_tap.chieu.Main.sc;

public class Schedule {
    private LocalDate day;
    private String content;
    private boolean assigned;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Schedule() {
        assigned = false;
    }

    public Schedule(LocalDate day, String content, boolean assigned) {
        this.day = day;
        this.content = content;
        this.assigned = assigned;
    }

    public String getDay() {
        return day.format(formatter);
    }

    public String getContent() {
        return content;
    }

    public void setDay(String day) {
        this.day = LocalDate.parse(day, formatter);
    }

    public void setContent(String content) {
        if (content.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Nội dung không được để trống!");
        }

        this.content = content;
    }

    public boolean isAssigned() {
        return this.assigned;
    }

    public void setAssigned(boolean assgined) {
        this.assigned = assgined;
    }

    public void input() {
        // Nhập ngày
        while (true) {
            try {
                System.out.print("Nhập ngày (dd/MM/yyyy): ");
                String dayInput = sc.nextLine().trim();
                setDay(dayInput);
                break;
            } catch (DateTimeParseException e) {
                System.out.println(">>> Error: Vui lòng nhập đúng định dạng dd/MM/yyyy.");
            }
        }

        // Nhập nội dung
        while (true) {
            try {
                System.out.print("Nhập nội dung: ");
                setContent(sc.nextLine().trim());
                break;
            } catch (NullOrEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Schedule schedule)) return false;
        return Objects.equals(getDay(), schedule.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDay());
    }

    @Override
    public String toString() {
        return "Ngày dạy: " + getDay()
                + "\nNội dung: " + getContent() + "\n";
    }
}
