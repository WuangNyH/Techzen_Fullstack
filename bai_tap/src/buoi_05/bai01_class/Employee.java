package buoi_05.bai01_class;

public class Employee {
    private int id;
    private String fullName;
    private int age;
    private String gender;
    private double salary;
    private float gpa;

    public Employee(int id, String fullName, int age, String gender, double salary, float gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.gpa = gpa;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nFullname: %s\nAge: %d\nGender: %s\nSalary: %,.0fVND\nGPA: %.1f",
                this.id, this.fullName, this.age, this.gender, this.salary, this.gpa);
    }
}
