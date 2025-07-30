# 💡 **ĐA HÌNH (Polymorphism)**

### ✅ Khái niệm:

* "Đa hình" trong OOP là khả năng một phương thức hoặc hành vi có thể hoạt động theo **nhiều cách khác nhau** dựa vào **ngữ cảnh cụ thể**.
* Cùng một lời gọi hàm, nhưng **kết quả hoặc cách thực hiện khác nhau**.

---

## 🧭 Có 2 loại đa hình:

---

### 1. **Đa hình lúc biên dịch (Compile-time)** — *Method Overloading*

#### 📌 Mô tả:

* Gọi là **nạp chồng phương thức**.
* Nhiều phương thức **cùng tên** trong một lớp nhưng khác:

    * Số lượng tham số.
    * Kiểu tham số.

#### ✅ Ví dụ:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

#### 🧠 Khi biên dịch:

* Trình biên dịch sẽ chọn **phiên bản phù hợp** dựa vào **kiểu và số lượng đối số**.

---

### 2. **Đa hình lúc thực thi (Runtime)** — *Method Overriding*

#### 📌 Mô tả:

* Xảy ra khi **lớp con ghi đè (override)** phương thức của **lớp cha**.
* Khi gọi phương thức thông qua **biến lớp cha**, nhưng **đối tượng là lớp con**, thì phương thức lớp con được gọi.

#### ✅ Ví dụ:

```java
class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Cat meows");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.speak(); // Dog barks
        a2.speak(); // Cat meows
    }
}
```

#### 🎯 Ý nghĩa:

* Cho phép xử lý linh hoạt và mở rộng hệ thống dễ dàng thông qua kế thừa.

---

## ✅ `instanceof` là gì?

`instanceof` là một **toán tử logic** trong Java dùng để **kiểm tra xem một đối tượng có phải là một thể hiện (instance) của một lớp cụ thể hoặc lớp con của nó hay không**.

### 🔹 Cú pháp:

```java
object instanceof ClassName
```

### 🔹 Trả về:

* `true`: nếu `object` là thể hiện của `ClassName` (hoặc lớp con của nó)
* `false`: nếu không phải

### 🔹 Ví dụ:

```java
Person p = new Student();
System.out.println(p instanceof Person);  // true
System.out.println(p instanceof Student); // true
System.out.println(p instanceof Teacher); // false
```

---

## ✅ So sánh với `getClass()`

| Đặc điểm           | `instanceof`               | `getClass()`                        |
|--------------------|----------------------------|-------------------------------------|
| Dùng trong đa hình | ✅ Có                       | ❌ Không                             |
| So sánh kế thừa    | ✅ So sánh cả lớp cha/con   | ❌ Chỉ chính xác khi cùng class      |
| Cách dùng          | `obj instanceof ClassName` | `obj.getClass() == ClassName.class` |

---

## ✅ Lớp `Object` — lớp cha của tất cả các lớp trong Java

### Một số phương thức quan trọng:

| Phương thức        | Mục đích                          |
|--------------------|-----------------------------------|
| `toString()`       | Trả về chuỗi đại diện của object  |
| `equals(Object o)` | So sánh hai object có bằng nhau   |
| `hashCode()`       | Trả về mã băm (sử dụng trong map) |
| `getClass()`       | Trả về lớp thực tế của object     |

---

## 📌 Tổng kết vai trò đa hình

| Mục tiêu       | Compile-time                             | Runtime                                    |
|----------------|------------------------------------------|--------------------------------------------|
| Xảy ra khi nào | Khi biên dịch                            | Khi chạy chương trình                      |
| Cơ chế         | Overloading                              | Overriding                                 |
| Tính linh hoạt | Cho phép nhiều method tên giống          | Cho phép đối tượng hành xử theo cách riêng |
| Ví dụ          | `add(int, int)` vs `add(double, double)` | `speak()` của `Animal`, `Dog`, `Cat`       |

---