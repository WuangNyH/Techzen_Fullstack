package buoi_2.thuc_hanh;

public class Student {
    private int id;
    private String name;
    private int age;
    private double avgScore;

    private static int autoId = 1;
    private static int countStudent = 0;

    public Student() {
    }

    public Student(String name, int age, double avgScore) {
        this.id = autoId++;
        this.name = name;
        this.age = age;
        this.avgScore = avgScore;

        countStudent++;
    }

    public String getName() {
        return name;
    }

    public double getAvgScore() {
        return avgScore;
    }
}
