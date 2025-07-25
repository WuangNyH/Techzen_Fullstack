package buoi_2.thuc_hanh;

public class Teacher {
    private int id;
    private String fullName;
    private int age;
    private String subject;
    private float teachingHours;

    private static int totalTeachers = 0;

    public Teacher(int id, String fullName, int age, String subject, float teachingHours) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.subject = subject;
        this.teachingHours = teachingHours;

        totalTeachers++;
    }

    public String getFullName() {
        return fullName;
    }

    public float getTeachingHours() {
        return teachingHours;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Full name: " + fullName + "\n" +
                "Age: " + age + "\n" +
                "Subject: " + subject + "\n" +
                String.format("Teaching hours: %.2f", teachingHours);
    }

    public static int getTotalTeachers() {
        return totalTeachers;
    }
}
