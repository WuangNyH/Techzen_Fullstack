package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.Lecturer;
import buoi_8.bai_tap.chieu.models.Schedule;

import java.util.ArrayList;

import static buoi_8.bai_tap.chieu.Main.sc;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.schedules;
import static buoi_8.bai_tap.chieu.manager.member.GetMember.getListMember;

public class AddScheduleToLecture {
    public static void addScheduleToLecture() {
        ArrayList<Lecturer> teachers = getListMember(Lecturer.class);
        if (schedules.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có lịch giảng dạy nào!");
            return;
        }

        if (teachers.isEmpty()) {
            System.out.println(">>> Error: Hiện tại chưa có giảng viên nào!");
            return;
        }

        ArrayList<Schedule> schedulesNotAssigned = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (!schedule.isAssigned()) {
                schedulesNotAssigned.add(schedule);
            }
        }

        if (schedulesNotAssigned.isEmpty()) {
            System.out.println(">>> Error: Hiện tại mọi lịch dạy đã được đảm nhiệm!");
        }

        System.out.println("==== DANH SÁCH GIẢNG VIÊN ====");
        int choice;
        while (true) {
            try {
                for (int i = 0; i < teachers.size(); i++) {
                    System.out.println((i + 1) + ". " + teachers.get(i).getId() + " - " + teachers.get(i).getFullName());
                }

                System.out.print("Chọn giảng viên: ");
                choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > teachers.size()) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
        Lecturer lecturerSelected = teachers.get(choice - 1);

        while (true) {
            try {
                System.out.println("==== DANH SÁCH LỊCH GIẢNG DẠY ====");
                for (int i = 0; i < schedulesNotAssigned.size(); i++) {
                    Schedule schedule = schedulesNotAssigned.get(i);
                    if (lecturerSelected.getSchedules().contains(schedule)) {
                        System.out.printf("%d. %s - %s - Đã có lịch\n", (i + 1), schedule.getDay(), schedule.getContent());
                    } else {
                        System.out.printf("%d. %s - %s\n", (i + 1), schedule.getDay(), schedule.getContent());
                    }
                }
                System.out.println((schedulesNotAssigned.size() + 1) + ". Dừng chọn");

                System.out.print("Chọn lịch dạy: ");
                int scheduleChoice = Integer.parseInt(sc.nextLine());

                if (scheduleChoice < 1 || scheduleChoice > schedulesNotAssigned.size() + 1) {
                    System.out.println(">>> Error: Lựa chọn không hợp lệ!");
                    continue;
                }

                if (scheduleChoice == schedulesNotAssigned.size() + 1) {
                    System.out.println("Hoàn thành thêm lịch dạy.");
                    return;
                }

                Schedule selectedSchedule = schedulesNotAssigned.get(scheduleChoice - 1);
                if (lecturerSelected.addSchedule(selectedSchedule)) {
                    selectedSchedule.setAssigned(true);
                    schedulesNotAssigned.remove(selectedSchedule);
                    System.out.printf("Đã thêm lịch dạy %s cho giảng viên %s.\n", selectedSchedule.getContent(), lecturerSelected.getFullName());
                } else {
                    System.out.printf(">>> Error: Giảng viên %s đã bận vào ngày %s\n", lecturerSelected.getFullName(), selectedSchedule.getDay());
                }

            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }
}
