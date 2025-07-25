# 🔁 Static

## 🔹 Static là gì?

* Là từ khóa dùng để khai báo **thuộc tính** và **phương thức** thuộc về **class**, không gắn với instance (đối tượng)
  cụ thể.
* Có thể truy xuất trực tiếp thông qua **tên class**, hoặc qua một đối tượng (dù không khuyến khích).
* Trong một `method static` chỉ sử dụng được các biến/hàm static. Nếu muốn dùng non-static thì phải khởi tạo đối tượng.

📌 **Ví dụ:**

```java
public class MathUtils {
    static double PI = 3.14;

    static double square(double x) {
        return x * x;
    }
}
```

```java
double area = MathUtils.PI * MathUtils.square(5);
```

---

## 🎯 Mục đích của static

* Định nghĩa các **thuộc tính hoặc hành vi chung** cho tất cả đối tượng.
* Tạo các **lớp tiện ích** giống như `Math`, `Collections`.
* **Tiết kiệm bộ nhớ** vì không phải tạo lại cho mỗi object.
* Tạo **counter dùng chung** cho toàn class.

---

## 🧠 Cơ chế lưu trữ static

![Cơ chế lưu trữ](https://aptech.fpt.edu.vn/wp-content/uploads/2022/12/static-trong-java-co-y-nghia-va-ung-dung-gi-556x400.jpg)

* Static memory được cấp phát **một lần duy nhất** khi class được load vào JVM.
* Tồn tại cho đến khi chương trình kết thúc.

---

## 🚫 Ràng buộc khi sử dụng static

| Tình huống                            | Có thể làm không? | Ghi chú         |
|---------------------------------------|-------------------|-----------------|
| Gọi biến static từ phương thức static | ✅                 | Hợp lệ          |
| Gọi biến non-static từ static         | ❌                 | Phải tạo object |
| Dùng `this`, `super` trong static     | ❌                 | Không thể dùng  |
| Gọi static từ phương thức non-static  | ✅                 | Hợp lệ          |

---

### 📌 Khối khởi tạo static (`static block`)

* Dùng để **khởi tạo giá trị static** khi class được load.
* **Chạy trước cả hàm `main()`** nếu class được gọi đến.

```java
public class App {
    static int version;

    static {
        version = 1;
        System.out.println("Khởi tạo static!");
    }

    public static void main(String[] args) {
        System.out.println("Version: " + version);
    }
}
```

🟢 **Output:**

```
Khởi tạo static!
Version: 1
```

---

## ✅ Khi nào nên dùng static?

* **Constant:** sử dụng với `final static` để tạo hằng số.
* **Method tiện ích:** ví dụ `Math.max()`, `Integer.parseInt()`.
* **Counter:** đếm số lượng object đã được tạo.
* **Shared resource:** tài nguyên dùng chung trong nhiều đối tượng.

---

## 🧩 Bonus: So sánh `static` vs `instance`

| Thuộc tính         | Static                  | Instance                   |
|--------------------|-------------------------|----------------------------|
| Thuộc về           | Class                   | Object                     |
| Truy cập           | `ClassName.variable`    | `object.variable`          |
| Số lượng copy      | 1 (dùng chung)          | Mỗi object có bản riêng    |
| Có thể dùng `this` | ❌ Không                 | ✅ Có thể dùng              |
| Ví dụ              | `Math.PI`, `System.out` | `person.name`, `car.speed` |

---

# Các loại biến

## ✅ 1. Biến Instance (Còn gọi là biến toàn cục, biến đối tượng)

### 📌 Đặc điểm:

* Khai báo **bên trong class** nhưng **ngoài tất cả các phương thức**.
* Mỗi **đối tượng (object)** sẽ có bản sao riêng của biến.
* Được cấp phát bộ nhớ khi **đối tượng được tạo**.
* Sử dụng được ở bất kỳ phương thức nào trong class (nếu không phải `private`).

### ✅ Ví dụ:

```java
public class Student {
    // Biến instance
    String name;
    int age;

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

---

## ✅ 2. Biến Local (Biến cục bộ)

### 📌 Đặc điểm:

* Khai báo **bên trong phương thức**, constructor hoặc block `{}`.
* Chỉ sử dụng được trong **phạm vi khai báo**, không truy cập bên ngoài.
* Không có giá trị mặc định → cần khởi tạo trước khi dùng.

### ✅ Ví dụ:

```java
public class Example {
    public void greet() {
        // Biến local
        String message = "Hello, Java!";
        System.out.println(message);
    }
}
```

---

## ✅ 3. Biến Static (Biến class)

### 📌 Đặc điểm:

* Khai báo với từ khóa `static`.
* Thuộc **về class**, chứ không thuộc về bất kỳ đối tượng cụ thể nào.
* Dùng chung cho **mọi object**.
* Có thể truy cập trực tiếp qua `ClassName.variable`.

### ✅ Ví dụ:

```java
public class Counter {
    static int count = 0;  // biến static

    public Counter() {
        count++;
        System.out.println("Count: " + count);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        new Counter();  // Count: 1
        new Counter();  // Count: 2
        System.out.println(Counter.count); // 2
    }
}
```

---

## ✅ Tóm tắt so sánh

| Loại biến    | Khai báo ở đâu            | Gắn với ai           | Thời điểm tồn tại        | Truy cập thông qua |
|--------------|---------------------------|----------------------|--------------------------|--------------------|
| **Instance** | Trong class, ngoài method | Gắn với object       | Khi đối tượng được tạo   | `object.variable`  |
| **Local**    | Trong method hoặc block   | Gắn với method/block | Khi method/block chạy    | Trực tiếp          |
| **Static**   | Trong class với `static`  | Gắn với class        | Khi chương trình bắt đầu | `Class.variable`   |

---

# Kiến thức thêm

- Tại sao static chỉ sử dụng được các thuộc tính static?
- Khi chạy chương trình khởi tạo các biến static trước khi chạy hàn main
