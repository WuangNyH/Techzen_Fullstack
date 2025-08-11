package buoi_8.bai_tap.chieu.models;

import buoi_8.bai_tap.chieu.exceptions.InvalidAgeException;
import buoi_8.bai_tap.chieu.exceptions.InvalidEmailException;
import buoi_8.bai_tap.chieu.exceptions.NullOrEmptyException;

import java.util.Objects;

import static buoi_8.bai_tap.chieu.Main.sc;

public abstract class Person {
    private String id;
    private String fullName;
    private int age;
    private String email;

    public Person() {
    }

    public Person(String id, String fullName, int age, String email) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public void input() {
        while (true) {
            try {
                System.out.print("Nhập tên: ");
                setFullName(sc.nextLine().trim());
                break;
            } catch (IllegalArgumentException | NullOrEmptyException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                setAge(Integer.parseInt(sc.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>> Error: Vui lòng nhập số nguyên dương!");
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập email: ");
                setEmail(sc.nextLine().trim());
                break;
            } catch (InvalidEmailException | NullOrEmptyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Tên không được rỗng!");
        }

        if (!fullName.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            throw new IllegalArgumentException(">> Error: Tên không được chứa số hoặc ký tự đặc biệt.");
        }

        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 100) {
            throw new InvalidAgeException(">>> Error: Tuổi phải từ 18 - 100.");
        }

        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Email không được rỗng!");
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidEmailException(">>> Error: Vui lòng nhập đúng định dạng (vd: ten@gmail.com).");
        }

        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Họ tên: " + fullName + "\n"
                + "Tuổi: " + age + "\n"
                + "Email: " + email + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
