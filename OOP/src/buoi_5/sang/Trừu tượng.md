# 🧠 Trừu tượng trong Java

## ✅ Khái niệm

* Ẩn chi tiết xử lý, chỉ hiển thị kết quả cho người dùng.
* Người dùng chỉ quan tâm kết quả, không cần biết cách thực hiện.
* Trong Java, thể hiện qua `abstract class` và `interface`.

---

## 🧱 Abstract Class

### 🧩 Là gì?

* Lớp có tính trừu tượng cao, **không thể tạo được đối tượng**.
* Dùng để **định nghĩa khung** cho các lớp con triển khai.

### 🎯 Lợi ích

* Không muốn tạo đối tượng.
* Một số phương thức không thể triển khai ngay.
* Dùng chung logic giữa các lớp liên quan.

### ⚠️ Lưu ý

* **Phương thức rỗng**: không làm gì cả.
* **Phương thức trừu tượng**: lớp con **bắt buộc override**.
* Abstract **không thể kết hợp với `final`**.
* Một lớp chứa method `abstract` → bắt buộc là `abstract`.
* Có thể kế thừa từ một abstract class khác mà không cần override toàn bộ.

### 🧪 Ví dụ:

```java
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound(); // phương thức trừu tượng

    public void eat() {
        System.out.println(name + " is eating...");
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}
```

---

## 🧩 Interface

### 📘 Là gì?

* Là **bản thiết kế hành vi** cho các lớp triển khai (`implements`).
* Thường dùng khi các lớp **không liên quan vẫn có hành vi chung**.

### 📌 Tính chất

| Tính năng     | Interface                           |
|---------------|-------------------------------------|
| Tạo đối tượng | ❌ Không                             |
| Biến          | ✅ Mặc định là `public static final` |
| Phương thức   | ✅ Mặc định là `public abstract`     |
| Constructor   | ❌ Không hỗ trợ                      |
| Kế thừa       | ✅ Kế thừa nhiều interface           |

### 🆕 Java 8 cập nhật

* **default method**: có thân hàm, được override bởi class con.
* **static method**: có thân hàm, **không override được**, gọi qua tên interface.

### 🔰 Ví dụ:

```java
public interface Flyable {
    void fly();
}

public interface Swimmable {
    void swim();
}

public class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying!");
    }

    public void swim() {
        System.out.println("Duck is swimming!");
    }
}
```

### 🔧 Java 8 - Default & Static:

```java
public interface Utility {
    static void printInfo() {
        System.out.println("Utility info...");
    }
}

public interface Vehicle {
    default void start() {
        System.out.println("Vehicle starting...");
    }
}

public class Car implements Vehicle {
    public void start() {
        System.out.println("Car starting...");
    }
}
```

---

## 🆚 So sánh: `Abstract class` vs `Interface`

| Tiêu chí                | Abstract Class          | Interface                    |
|-------------------------|-------------------------|------------------------------|
| Có constructor          | ✅ Có                    | ❌ Không                      |
| Chứa biến thường        | ✅ Có                    | ❌ Chỉ `public static final`  |
| Phương thức có thân hàm | ✅ Có                    | ❌ Không (trừ default/static) |
| Đa kế thừa              | ❌ Không                 | ✅ Có                         |
| Mục đích sử dụng        | Kế thừa & chia sẻ logic | Định nghĩa hành vi chung     |

---

## 📝 Ghi nhớ nhanh

* Dùng **abstract class** khi:

    * Có logic dùng chung cần tái sử dụng.
    * Có thuộc tính hoặc constructor.

* Dùng **interface** khi:

    * Nhiều class cần chung một hành vi (dù không liên quan).
    * Muốn tận dụng đa kế thừa.
