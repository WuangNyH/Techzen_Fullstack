package buoi_8.ss9_set_map;


import java.util.Objects;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double score;

    public Student() {
    }

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    /// Cần override lại equal() và hashCode()
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student student)) return false;
        return getId() == student.getId() && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    /// Cần triển khai compareTo() của interface Comparable
    @Override
    public int compareTo(Student o) {
        int compare = Double.compare(this.score, o.score);
        if (compare == 0) {
            return Integer.compare(this.id, o.getId());
        }
        return compare;
    }
}
