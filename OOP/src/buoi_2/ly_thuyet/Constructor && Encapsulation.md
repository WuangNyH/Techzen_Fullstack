# ✅ Constructor

### 👉 Định nghĩa:

* `Constructor` là **phương thức đặc biệt** dùng để **khởi tạo đối tượng** từ một lớp (class).
* Tên của constructor **trùng với tên class** và **không có kiểu trả về**, kể cả `void`.

### 👉 Các loại constructor:

1. **Constructor mặc định (default constructor)**:

    * Do Java tự tạo ra nếu bạn không khai báo constructor nào.
    * Không có tham số.

2. **Constructor có tham số (parameterized constructor)**:

    * Do lập trình viên định nghĩa.
    * Dùng để khởi tạo object với các giá trị truyền vào.

### 👉 Đặc điểm:

* Có thể khai báo **nhiều constructor** với số lượng tham số khác nhau (**constructor overloading**).
* Khi đã khai báo constructor có tham số, **constructor mặc định sẽ không còn tồn tại** trừ khi bạn tự định nghĩa lại.
* Có thể dùng `this(...)` để gọi constructor khác trong **cùng class** (nằm ở dòng đầu tiên của constructor).
* `this` dùng để tham chiếu đến **biến hoặc phương thức của đối tượng hiện tại**.
* Ghi đè (`override`) phương thức `toString()` giúp in ra thông tin đối tượng theo định dạng mong muốn.

---

# ✅ Access Modifier (Phạm vi truy cập)

### 👉 Mục đích:

* **Xác định mức độ truy cập** của class, method, biến, hoặc constructor từ bên ngoài hoặc bên trong package.

### 👉 Bảng tổng hợp:

| Access Modifier | Inside Class | Inside Package | Subclass Outside Package | Outside Package |
|-----------------|--------------|----------------|--------------------------|-----------------|
| `private`       | ✅ Yes        | ❌ No           | ❌ No                     | ❌ No            |
| `default`       | ✅ Yes        | ✅ Yes          | ❌ No                     | ❌ No            |
| `protected`     | ✅ Yes        | ✅ Yes          | ✅ Yes                    | ❌ No            |
| `public`        | ✅ Yes        | ✅ Yes          | ✅ Yes                    | ✅ Yes           |

---

# ✅ Tính bao đóng (Encapsulation)

### 👉 Định nghĩa:

* Là một trong **4 tính chất cơ bản của lập trình hướng đối tượng (OOP)**.
* Giúp **che giấu dữ liệu nội bộ** của object khỏi truy cập trực tiếp từ bên ngoài.
* Chỉ cho phép truy cập thông qua các **phương thức gián tiếp** (getter/setter).

### 👉 Cách thực hiện:

* **Khai báo các thuộc tính (biến) là `private`**.
* **Cung cấp `getter` và `setter`** để truy cập và thay đổi giá trị của biến.

```java
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

---

# ✅ Cần học:

- Nắm rõ OOP là gì? Class và Object
- Nắm rõ 4 quy tắc trong lập trình OOP