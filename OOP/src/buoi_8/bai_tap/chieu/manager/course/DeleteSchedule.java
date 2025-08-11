package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.Schedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.schedules;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class DeleteSchedule {
    public static void deleteSchedule() {
        if (schedules.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có lịch giảng dạy nào!");
            return;
        }

        LocalDate dateToDelete;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String keyword;

        while (true) {
            System.out.print("Nhập ngày-tháng-năm cần xóa (dd/MM/yyyy): ");
            keyword = sc.nextLine().trim();
            try {
                dateToDelete = LocalDate.parse(keyword, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println(">>> Error: Vui lòng nhập đúng định dạng.\n");
            }
        }

        String date = dateToDelete.format(formatter);

        boolean found = false;

        ArrayList<Lecturer> lecturers = getListMember(Lecturer.class);

        for (Lecturer lecturer : lecturers) {
            lecturer.removeSchedule(date);
        }

        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()) {
            if (it.next().getDay().equals(date)) {
                it.remove();
                found = true;
            }
        }

        if (found) {
            System.out.println("Đã xóa lịch có ngày " + keyword);
        } else {
            System.out.println("Không tìm thấy lịch có ngày " + keyword);
        }
    }
}
