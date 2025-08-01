package buoi_5.chieu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Person> persons = new ArrayList<>();


    public static String getRandomIdentify() {
        int number = (int) (Math.random() * 1000);
        return String.format("%03d", number);
    }

    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 1 =====\nTHÊM MỚI");
                System.out.println("1. Học viên BE");
                System.out.println("2. Học viên FT");
                System.out.println("3. Giảng viên");
                System.out.println("4. Trở giảng");
                System.out.println("5. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        StudentBE studentBE = new StudentBE();
                        addNew(studentBE, getRandomIdentify(), getStudentBE());
                        break;
                    case 2:
                        StudentFT studentFT = new StudentFT();
                        addNew(studentFT, getRandomIdentify(), getStudentFT());
                        break;
                    case 3:
                        TeacherMain teacherMain = new TeacherMain();
                        addNew(teacherMain, getRandomIdentify(), getTeacher());
                        return;
                    case 4:
                        TeacherSupport teacherSupport = new TeacherSupport();
                        addNew(teacherSupport, getRandomIdentify(), getTeacherSupport());
                        addTeacherToTS(teacherSupport);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    public static void addTeacherToTS(TeacherSupport teacherSupport) {
        ArrayList<TeacherMain> teacherMains = getTeacher();

        for (int i = 0; i < teacherMains.size(); i++) {
            System.out.println(i + 1 + ". " + teacherMains.get(i).getId() + ": " + teacherMains.get(i).getName());
        }

        while (true) {
            System.out.println("Chọn giảng viên hộ trợ: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > teacherMains.size() + 1) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }

            teacherSupport.setTeachers(teacherMains.get(choice - 1));
            break;
        }
    }

    private static <T extends Person> void addNew(T newPerson, String id, ArrayList<T> person) {
        newPerson.input(sc);
        newPerson.setId(id);

        for (Person p : person) {
            if (p.getId().equals(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        persons.add(newPerson);
        System.out.println("Thêm nhân viên quản lý mới thành công");
    }

    private static ArrayList<StudentBE> getStudentBE() {
        ArrayList<StudentBE> studentBE = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof StudentBE) {
                studentBE.add((StudentBE) p);
            }
        }

        return studentBE;
    }

    private static ArrayList<StudentFT> getStudentFT() {
        ArrayList<StudentFT> studentFT = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof StudentFT) {
                studentFT.add((StudentFT) p);
            }
        }

        return studentFT;
    }

    private static ArrayList<TeacherMain> getTeacher() {
        ArrayList<TeacherMain> teacherMain = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof TeacherMain) {
                teacherMain.add((TeacherMain) p);
            }
        }

        return teacherMain;
    }

    private static ArrayList<TeacherSupport> getTeacherSupport() {
        ArrayList<TeacherSupport> teacherSupport = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof TeacherSupport) {
                teacherSupport.add((TeacherSupport) p);
            }
        }

        return teacherSupport;
    }

    private static void printPerson() {
        System.out.println("Bạn muốn hiển thị danh sách thành viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        System.out.println("3. Giảng viên");
        System.out.println("4. Trợ giảng");
        System.out.println("5. Tất cả");
        System.out.println("6. Thoát");

        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    printList(getStudentBE());
                    break;
                case 2:
                    printList(getStudentFT());
                    break;
                case 3:
                    printList(getTeacher());
                    break;
                case 4:
                    printList(getTeacherSupport());
                    break;
                case 5:
                    printList(persons);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choose < 1 || choose > 6);
    }

    private static <T extends Person> void printList(ArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Thông tin người thứ " + (i + 1));
            System.out.println(list.get(i));
        }
    }

    //    // 3 - Như
    public static void findPerson(Scanner sc, ArrayList<Person> listMembers) {
        System.out.print("Nhập từ khóa cần tìm (họ tên hoặc email): ");
        String keyword = sc.nextLine().trim();
        String lowerKeyword = keyword.toLowerCase();

        ArrayList<Person> ketQua = new ArrayList<>();
        String kieuTimKiem = "";

        if (isValidEmail(keyword)) {
            for (Person p : listMembers) {
                if (p.getEmail().equalsIgnoreCase(keyword)) {
                    ketQua.add(p);
                }
            }
            kieuTimKiem = "email";
        } else if (isValidName(keyword)) {
            for (Person p : listMembers) {
                if (p.getName().toLowerCase().equals(lowerKeyword)) {
                    ketQua.add(p);
                }
            }
            kieuTimKiem = "tên";
        } else {
            System.out.println("Từ khóa không hợp lệ. Vui lòng nhập tên hoặc email đúng định dạng.");
            return;
        }

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy thành viên nào với " + kieuTimKiem + " \"" + keyword + "\"");
        } else {
            System.out.println("Kết quả tìm kiếm theo " + kieuTimKiem + ":");
            printList(ketQua);
        }
    }


    public static boolean isValidName(String keyword) {
        return keyword.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidEmail(String keyword) {
        return keyword.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$");
    }


    public static ArrayList<Person> findByEmail(String keyword) {
        ArrayList<Person> dsTimTheoEmail = new ArrayList<>();
        for (Person p : persons)
            if (p.getEmail().trim().toLowerCase().contains(keyword)) {
                dsTimTheoEmail.add(p);
            }
        return dsTimTheoEmail;
    }

    public static ArrayList<Person> findByName(String keyword) {
        ArrayList<Person> dsTimTheoTen = new ArrayList<>();
        for (Person p : persons)
            if (p.getName().trim().toLowerCase().contains(keyword)) {
                dsTimTheoTen.add(p);
            }
        return dsTimTheoTen;
    }

    private static void menuUpdate() {
        System.out.println("===== Màn Hình 2 =====");
        System.out.print("Nhập vào ID muốn cập nhật thông tin: ");
        String id = sc.nextLine().trim();

        boolean isFound = false;

        for (Person person : persons) {
            if (person.getId().equalsIgnoreCase(id)) {
                isFound = true;

                System.out.println("Chọn thông tin cần cập nhật:");
                System.out.println("1. Tên");
                System.out.println("2. Tuổi");
                System.out.println("3. Email");
                System.out.print("Lựa chọn của bạn (1-3): ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine().trim();
                        person.setName(newName);
                        System.out.println("Đã cập nhật tên thành công!");
                        break;
                    case 2:
                        System.out.print("Nhập tuổi mới: ");
                        try {
                            int newAge = Integer.parseInt(sc.nextLine().trim());
                            person.setAge(newAge);
                            System.out.println("Đã cập nhật tuổi thành công!");
                        } catch (NumberFormatException e) {
                            System.out.println("Tuổi không hợp lệ!");
                        }
                        break;
                    case 3:
                        System.out.print("Nhập email mới: ");
                        String newEmail = sc.nextLine().trim();
                        person.setEmail(newEmail);
                        System.out.println("Đã cập nhật email thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                        break;
                }

                break;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy ID muốn cập nhật!");
        }
    }

    // 5 - như
    private static void menuDelete() {
        System.out.println("===== Màn Hình 2 =====\nXÓA THÔNG TIN THÀNH VIÊN");
        System.out.print("Nhập vào ID muốn xóa: ");
        String id = sc.nextLine().trim();

        Person personToDelete = null;

        for (Person person : persons) {
            if (person.getId().equalsIgnoreCase(id)) {
                personToDelete = person;
                break;
            }
        }

        if (personToDelete == null) {
            System.out.println("Không tìm thấy ID.");
            return;
        }

        if (personToDelete instanceof Teacher) {
            for (Person p : persons) {
                if (p instanceof TeacherSupport ts) {
                    ts.getTeachers().removeIf(t -> t.getId().equalsIgnoreCase(id));
                }
            }
        }
        persons.remove(personToDelete);

        System.out.println("Đã xóa thành viên thành công.");
    }

    //6---------------------------------------------------------------------------------------
    private static <T extends Person & IStudent> void sortAllStudentsUtil(Class<T> clazz, ArrayList<Person> persons) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (Person e : persons) {
            if (clazz.isInstance(e)) {
                filteredList.add((T) e);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("Không có học viên nào !");
            return;
        }

        System.out.println("1. Tăng dần theo điểm trung bình");
        System.out.println("2. Giảm dần theo điểm trung bình");
        System.out.print("Chọn cách sắp xếp: ");
        int choose = Integer.parseInt(sc.nextLine());

        if (choose == 1) {
            sortByFor(filteredList, true);
        } else if (choose == 2) {
            sortByFor(filteredList, false);
        } else {
            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
            return;
        }

        System.out.println("----- Danh sách sau khi sắp xếp theo điểm trung bình -----");
        int count = 1;
        for (T l : filteredList) {
            System.out.println("Học viên thứ " + count++);

            System.out.println("ID: " + l.getId());
            System.out.println("Tên: " + l.getName());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Điểm trung bình: " + l.getDiemTrungBinh());
            System.out.println("Xếp loại: " + l.xepLoai());
            System.out.println("----------------------------");
        }
    }

    // Sắp xếp danh sách theo điểm trung bình
    private static <T extends Person & IStudent> void sortByFor(List<T> list, boolean ascending) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double avgI = list.get(i).getDiemTrungBinh();
                double avgJ = list.get(j).getDiemTrungBinh();

                boolean needSwap = ascending ? avgI > avgJ : avgI < avgJ;
                if (needSwap) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    //7  In danh sách
    private static <T extends Person & IStudent> void printListStudent(List<T> list) {
        int count = 1;
        for (T l : list) {
            if (l instanceof StudentBE) {
                System.out.println("Học viên backend thứ " + count++);
            } else if (l instanceof StudentFT) {
                System.out.println("Học viên fullstack thứ " + count++);
            }

            System.out.println("ID: " + l.getId());
            System.out.println("Tên: " + l.getName());
            System.out.println("Email: " + l.getEmail());
            System.out.println("Điểm trung bình: " + l.getDiemTrungBinh());
            System.out.println("Xếp loại: " + l.xepLoai());
            System.out.println("Học phí: " + l.getTuition() + " VND");
            System.out.println("----------------------------");
        }
    }

    //8
    private static void calculateSalary() {
        System.out.println("Hãy lựa chọn: ");
        System.out.println("1. Giảng viên");
        System.out.println("2. Trợ giảng");
        System.out.print("Mời bạn nhập: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("====== Danh sách lương các giảng viên ======");
            for (Person p : persons) {
                if (p instanceof Teacher) {
                    System.out.printf("Giảng viên: %-20s | Lương: %,.0f VND%n", p.getName(), ((Teacher) p).getSalary());
                }
            }
        } else if (choice == 2) {
            System.out.println("====== Danh sách lương các trợ giảng ======");
            for (Person p : persons) {
                if (p instanceof TeacherSupport) {
                    System.out.printf("Trợ giảng: %-20s | Lương: %,.0f VND%n", p.getName(), ((TeacherSupport) p).getSalary());
                }
            }
        }
    }

    //9
    private static void findSupportsOfTeacherByName() {
        sc.nextLine();
        System.out.print("Nhập id giảng viên cần tra cứu: ");
        String id = sc.nextLine().trim();

        Teacher foundTeacher = null;

        // Tìm giảng viên theo ID
        for (Person p : persons) {
            if (p instanceof Teacher && id.equals(p.getId())) {
                foundTeacher = (Teacher) p;
                break;
            }
        }
        // Nếu không tìm thấy
        if (foundTeacher == null) {
            System.out.println("Không tìm thấy giảng viên với ID: " + id);
            return;
        }
        // Duyệt toàn bộ danh sách để tìm các trợ giảng hỗ trợ giảng viên này
        ArrayList<TeacherSupport> teacherSupports = new ArrayList<>();
        for (Person p : persons) {
            if (p instanceof TeacherSupport ts) {
                for (Teacher supported : ts.getTeachers()) {
                    if (supported.equals(foundTeacher)) {
                        teacherSupports.add(ts);
                        break;
                    }
                }
            }
        }
        // In kết quả
        System.out.println("Giảng viên: " + foundTeacher);
        System.out.println("Số lượng trợ giảng hỗ trợ: " + teacherSupports.size());

        if (teacherSupports.isEmpty()) {
            System.out.println("Không có trợ giảng nào hỗ trợ giảng viên này.");
        } else {
            System.out.println("Danh sách trợ giảng:");
            for (TeacherSupport ts : teacherSupports) {
                System.out.println(" - " + ts);
            }
        }
    }

    //---------------------------------------------------------------------------------------
    private static <T extends Student & IStudent> ArrayList<T> filterStudent(Class<T> type) { // type = ManagementEmployee.class
        ArrayList<T> result = new ArrayList<>();
        for (Person student2 : persons) {
            if (type.isInstance(student2)) {
                result.add(type.cast(student2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int choose;
        while (true) {
            do {
                System.out.println("\n===== Màn Hình =====\nHệ Thống Quản Lý Academy");
                System.out.println("1. Thêm thành viên");
                System.out.println("2. Hiển thị danh sách thành viên");
                System.out.println("3. Tìm kiếm thành viên theo tên hoặc email");
                System.out.println("4. Cập nhật thông tin cho thành viên");
                System.out.println("5. Xóa thành viên");
                System.out.println("6. Sắp xếp học viên theo điểm trung bình");
                System.out.println("7. Tính học phí của học viên");
                System.out.println("8. Tính  lương của  giảng viên");
                System.out.println("9. Tìm kếm giảng viên có bao nhiêu trợ giảng");
                System.out.println("10. Thoát...");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1 -> menuAddNew();

                    case 2 -> printPerson();

                    case 3 -> findPerson(sc, persons);
                    case 4 -> menuUpdate();
                    case 5 -> menuDelete();
                    case 6 -> menuSortByAVG();
                    case 7 -> tuitionStudent();
//                   case 8 -> tuitionTeacher();
                    case 9 -> findSupportsOfTeacherByName();

                    case 10 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 7);
        }
    }

    private static void menuSortByAVG() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 4 =====\nSẮP XẾP THEO ĐIỂM TRUNG BÌNH");
                System.out.println("1. Học viên backend");
                System.out.println("2. Học viên fullstack");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        sortAllStudentsUtil(StudentBE.class, persons);
                        break;
                    case 2:
                        sortAllStudentsUtil(StudentFT.class, persons);
                        break;

                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static double totalAll() {
        double sum = 0;
        for (Person p : persons) {
            if (p instanceof Student student) {
                sum += student.getTuition();
            }
        }
        return sum;
    }

    private static double totalBe() {
        double sum = 0;
        for (Person p : persons) {
            if (p instanceof StudentBE student) {
                sum += student.getTuition();
            }
        }
        return sum;
    }

    private static double totalFT() {
        double sum = 0;
        for (Person p : persons) {
            if (p instanceof StudentFT student) {
                sum += student.getTuition();
            }
        }
        return sum;
    }

    private static void tuitionStudent() {
        System.out.println("Bạn muốn tính học phí cho học viên nào?");
        System.out.println("1. Học viên Backend");
        System.out.println("2. Học viên Fullstack");
        System.out.println("3. Tất cả");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1 -> System.out.println("Tong hoc phi backend" + totalBe());
                case 2 -> System.out.println("Tong hoc phi Fullend" + totalFT());
                case 3 -> System.out.println("Tong tat hoc phi " + totalAll());
                default -> System.out.println("Bạn đã nhập sai ! Vui lòng chọn 1 - 2.");
            }
        } while (choose < 1 || choose > 3);
    }
}
