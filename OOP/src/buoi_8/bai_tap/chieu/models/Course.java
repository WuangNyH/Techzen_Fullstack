package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidStringException;
import buoi_8.bai_tap.chieu.exceptions.NullOrEmptyException;

import java.util.HashSet;
import java.util.Objects;

import static buoi_8.bai_tap.chieu.Main.sc;

public class Course {
    private String id;
    private String name;
    private final HashSet<Student> students = new HashSet<>();
    private Lecturer lecturer;

    public Course() {
    }

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = String.format("C-00" + id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Tên khóa học không được rỗng!");
        }

        if (!name.matches("[a-zA-Z0-9#+]+")) {
            throw new InvalidStringException(">>Error: Tên không được chứa ký tự đặt biệt!");
        }

        this.name = name;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public boolean addStudents(Student student) {
        return this.students.add(student);
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void input() {
        while (true) {
            try {
                System.out.print("Nhập tên khóa học: ");
                setName(sc.nextLine().trim());
                break;
            } catch (InvalidStringException | NullOrEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Course course)) return false;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        StringBuilder studentOutput = new StringBuilder();

        if (students.isEmpty()) {
            studentOutput.append("Hiện tại chưa có học viên nào trong lớp!\n");
        } else {
            studentOutput.append("\n");
            for (Student student : students) {
                studentOutput.append("\t+ ").append(student.getId()).append(": ").append(student.getFullName()).append("\n");
            }
        }

        return "Mã lớp học: " + this.id + "\n"
                + "Tên: " + this.name + "\n"
                + "Danh sách sinh viên: "
                + studentOutput
                + "Giảng viên đảm nhận: " + ((lecturer != null) ? this.lecturer.getFullName() : "Chưa có giảng viên đảm nhận") + "\n";
    }
}
