package buoi_8.bai_tap.chieu.manager.course;

import buoi_8.bai_tap.chieu.models.Course;
import buoi_8.bai_tap.chieu.models.Schedule;

import static buoi_8.bai_tap.chieu.manager.course.CourseManager.courses;
import static buoi_8.bai_tap.chieu.manager.course.CourseManager.schedules;
import static buoi_8.bai_tap.chieu.manager.member.AddMember.getRandomIdentify;

public class AddCourseSchedule {
    public static void addNewCourse() {
        Course newCourse = new Course();
        do {
            newCourse.setId(getRandomIdentify());
        } while (courses.containsKey(newCourse.getId()));
        newCourse.input();
        courses.put(newCourse.getId(), newCourse);
        System.out.println("Thêm mới lớp học thành công!");
    }

    public static void addSchedule() {
        Schedule newSchedule = new Schedule();
        System.out.println("=== Thêm buổi giảng mới ===");
        newSchedule.input();
        schedules.add(newSchedule);
    }
}
