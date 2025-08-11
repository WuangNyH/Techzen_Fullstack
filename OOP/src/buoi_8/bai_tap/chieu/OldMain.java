//package buoi_8.bai_tap.chieu;
//
//import buoi_8.bai_tap.chieu.models.*;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.*;
//
//public class OldMain {
//    public static Scanner sc = new Scanner(System.in);
//    static ArrayList<Person> persons = new ArrayList<>();
//    static ArrayList<Course> courses = new ArrayList<>();
//    static LinkedList<Schedule> schedules = new LinkedList<>();
//
/// /    private static void initializeSampleData() {
/// /        // Create Lecturers first (for Teaching Assistants to reference)
/// /        Lecturer lecturer1 = new Lecturer("L001", "Dr. John Smith", 45, "john.smith@university.edu",
/// /                40, "Computer Science");
/// /        Lecturer lecturer2 = new Lecturer("L002", "Prof. Sarah Johnson", 38, "sarah.johnson@university.edu",
/// /                35, "Software Engineering");
/// /        Lecturer lecturer3 = new Lecturer("L003", "Dr. Michael Brown", 42, "michael.brown@university.edu",
/// /                38, "Database Systems");
/// /
/// /        // Add Backend Students
/// /        persons.add(new StudentBE("BE001", "Alice Chen", 22, "alice.chen@student.edu",
/// /                8.7, 45, "Java"));
/// /        persons.add(new StudentBE("BE002", "Bob Wilson", 23, "bob.wilson@student.edu",
/// /                7.2, 42, "Python"));
/// /        persons.add(new StudentBE("BE003", "Charlie Davis", 21, "charlie.davis@student.edu",
/// /                6.8, 38, "C#"));
/// /        persons.add(new StudentBE("BE004", "Diana Lee", 24, "diana.lee@student.edu",
/// /                9.1, 48, "Java"));
/// /
/// /        // Add Fullstack Students
/// /        persons.add(new StudentFS("FS001", "Eva Martinez", 23, "eva.martinez@student.edu",
/// /                8.3, 50, 3));
/// /        persons.add(new StudentFS("FS002", "Frank Thompson", 22, "frank.thompson@student.edu",
/// /                7.9, 47, 2));
/// /        persons.add(new StudentFS("FS003", "Grace Kim", 25, "grace.kim@student.edu",
/// /                8.8, 52, 5));
/// /        persons.add(new StudentFS("FS004", "Henry Garcia", 24, "henry.garcia@student.edu",
/// /                6.5, 44, 1));
/// /
/// /        // Add Lecturers
/// /        persons.add(lecturer1);
/// /        persons.add(lecturer2);
/// /        persons.add(lecturer3);
/// /
/// /        // Add Teaching Assistants
/// /        TeachingAssistant ta1 = new TeachingAssistant("TA001", "Ivan Petrov", 26,
/// /                "ivan.petrov@university.edu", 20, 15);
/// /        ta1.addLecture(lecturer1);
/// /        ta1.addLecture(lecturer2);
/// /
/// /        TeachingAssistant ta2 = new TeachingAssistant("TA002", "Julia Wang", 25,
/// /                "julia.wang@university.edu", 18, 12);
/// /        ta2.addLecture(lecturer2);
/// /        ta2.addLecture(lecturer3);
/// /
/// /        persons.add(ta1);
/// /        persons.add(ta2);
/// /    }
//
//    private static void mainMenu() {
//        System.out.println("===== Màn Hình =====");
//        System.out.println("Hệ Thống Quản Lý Academy");
//        System.out.println("1. Quản lý thành viên");
//        System.out.println("2. Quản lý lớp học / lịch học");
//        System.out.println("3. Kết thúc chương trình");
//    }
//
//    private static void menuMemberManager() {
//        System.out.println("===== Màn Hình =====");
//        System.out.println("Hệ Thống Quản Lý Academy");
//        System.out.println("1. Thêm thành viên");
//        System.out.println("2. Hiển thị danh sách thành viên");
//        System.out.println("3. Tìm kiếm thành viên theo tên hoặc email");
//        System.out.println("4. Cập nhật thông tin cho thành viên");
//        System.out.println("5. Xóa thành viên");
//        System.out.println("6. Sắp xếp học viên theo điểm trung bình");
//        System.out.println("7. Tìm kếm giảng viên có bao nhiêu trợ giảng");
//        System.out.println("8. Tìm học viên theo id");
//        System.out.println("9. Về menu chính");
//    }
//
//    private static void menuAdd() {
//        System.out.println("===== Màn Hình =====");
//        System.out.println("Thêm thành viên");
//        System.out.println("1. Học viên BE");
//        System.out.println("2. Học viên FS");
//        System.out.println("3. Giảng viên");
//        System.out.println("4. Trợ giảng");
//        System.out.println("5. Thoát...");
//    }
//
//    private static void processAdd() {
//        int choice;
//
//        while (true) {
//            menuAdd();
//            System.out.print("Bạn muốn thêm thành viên nào: ");
//            choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    StudentBE newStudentBE = new StudentBE();
//                    addNewPerson(newStudentBE);
//                    break;
//                case 2:
//                    StudentFS newStudentFS = new StudentFS();
//                    addNewPerson(newStudentFS);
//                    break;
//                case 3:
//                    Lecturer newLecturer = new Lecturer();
//                    addNewPerson(newLecturer);
//                    break;
//                case 4:
//                    TeachingAssistant newTeachingAssistant = new TeachingAssistant();
//                    addNewPerson(newTeachingAssistant);
//                    addLecturerForAssistant(newTeachingAssistant);
//                    break;
//                case 5:
//                    return;
//                case 6:
//                    System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
//            }
//        }
//    }
//
//    private static String getRandomIdentify() {
//        int number = (int) (Math.random() * 1000);
//        return String.format("%03d", number);
//    }
//
//    private static boolean checkIdentify(String id) {
//        for (Person person : persons) {
//            if (person.getId().equals(id)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static <T extends Person> void addNewPerson(T person) {
//        do {
//            person.setId(getRandomIdentify());
//        } while (!checkIdentify(person.getId()));
//        person.input();
//        persons.add(person);
//        System.out.println("Thêm thành viên mới thành công!\n");
//    }
//
//    private static void addLecturerForAssistant(TeachingAssistant teachingAssistant) {
//        ArrayList<Lecturer> lecturers = getList(Lecturer.class);
//
//        if (lecturers.isEmpty()) {
//            System.out.println("Hiện tại chưa có giảng viên!\n");
//            return;
//        }
//
//        while (!lecturers.isEmpty()) {
//            System.out.println("Giảng viện hổ trợ: ");
//            for (int i = 0; i < lecturers.size(); i++) {
//                Lecturer lecturer = lecturers.get(i);
//                System.out.println((i + 1) + ". " + lecturer.getId() + ": " + lecturer.getFullName());
//            }
//            System.out.println((lecturers.size() + 1) + ". " + "Dừng chọn.");
//
//            System.out.println("Chọn GV: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            if (choice == lecturers.size() + 1) {
//                break;
//            }
//
//            if (choice < 1 || choice > lecturers.size() + 1) {
//                System.out.println("Lựa chọn không hợp lệ!\n");
//                continue;
//            }
//
//            teachingAssistant.addLecture(lecturers.get(choice - 1));
//            lecturers.removeSchedule(choice - 1);
//        }
//    }
//
//    private static void menuShowPerson() {
//        System.out.println("===== Màn Hình =====");
//        System.out.println("Hiển thị thành viên");
//        System.out.println("1. Học viên BE");
//        System.out.println("2. Học viên FS");
//        System.out.println("3. Giảng viên");
//        System.out.println("4. Trợ giảng");
//        System.out.println("5. Tất cả");
//        System.out.println("6. Thoát...");
//    }
//
//    private static void processShowPerson() {
//        int choice;
//
//        while (true) {
//            menuShowPerson();
//
//            System.out.print("Lựa chọn của bạn: ");
//            choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1 -> displayList(getList(StudentBE.class));
//                case 2 -> displayList(getList(StudentFS.class));
//                case 3 -> displayList(getList(Lecturer.class));
//                case 4 -> displayList(getList(TeachingAssistant.class));
//                case 5 -> displayList(persons);
//                case 6 -> {
//                    return;
//                }
//                default -> System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
//            }
//        }
//    }
//
//    private static <T extends Person> ArrayList<T> getList(Class<T> type) {
//        ArrayList<T> list = new ArrayList<>();
//
//        for (Person person : persons) {
//            if (type.isInstance(person)) {
//                list.add(type.cast(person));
//            }
//        }
//
//        return list;
//    }
//
//    private static <T extends Person> void displayList(ArrayList<T> list) {
//        if (list.isEmpty()) {
//            System.out.println("Danh sách trống!");
//            return;
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Thông tin người thứ " + (i + 1));
//            System.out.println(list.get(i));
//        }
//    }
//
//    public static void findPerson() {
//        if (persons.isEmpty()) {
//            System.out.println("Hiện tại chưa có thành viên nào!");
//            return;
//        }
//
//        System.out.print("Nhập từ khóa cần tìm (họ tên hoặc email): ");
//        String keyword = sc.nextLine().trim().toLowerCase();
//
//        ArrayList<Person> ketQua = new ArrayList<>();
//
//        for (Person person : persons) {
//            if (person.getFullName().toLowerCase().contains(keyword) || person.getEmail().toLowerCase().contains(keyword)) {
//                ketQua.add(person);
//            }
//        }
//
//        if (ketQua.isEmpty()) {
//            System.out.println("Không tìm thấy thành viên nào với keyword: " + keyword);
//        } else {
//            System.out.println("Kết quả tìm kiếm với keyword : " + keyword);
//            displayList(ketQua);
//        }
//    }
//
//    private static void menuDelete() {
//        System.out.println("===== Màn Hình 2 =====\nXÓA THÔNG TIN THÀNH VIÊN");
//        System.out.print("Nhập vào ID muốn xóa: ");
//        String id = sc.nextLine().trim();
//
//        Person personToDelete = null;
//
//        for (Person person : persons) {
//            if (person.getId().equalsIgnoreCase(id)) {
//                personToDelete = person;
//                break;
//            }
//        }
//
//        if (personToDelete == null) {
//            System.out.println("Không tìm thấy ID.");
//            return;
//        }
//
//        if (personToDelete instanceof Lecturer) {
//            for (Person p : persons) {
//                if (p instanceof TeachingAssistant ta) {
//                    ta.removeLecture((Lecturer) personToDelete);
//                }
//            }
//        }
//        persons.removeSchedule(personToDelete);
//
//        System.out.println("Đã xóa thành viên thành công.");
//    }
//
//    private static void menuUpdate() {
//        if (persons.isEmpty()) {
//            System.out.println("Hiện tại chưa có thành viên nào!");
//            return;
//        }
//
//        System.out.println("===== Màn Hình 2 =====");
//        System.out.print("Nhập vào ID muốn cập nhật thông tin: ");
//        String id = sc.nextLine().trim();
//
//        boolean isFound = false;
//
//        for (Person person : persons) {
//            if (person.getId().equalsIgnoreCase(id)) {
//                isFound = true;
//
//                while (true) {
//                    System.out.print("Nhập tên: ");
//                    person.setFullName(sc.nextLine().trim());
//                    if (person.getFullName().matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
//                        break;
//                    } else {
//                        System.out.println("Tên không hợp lệ! Không chứa số hoặc ký tự đặc biệt.\n");
//                    }
//                }
//
//                while (true) {
//                    System.out.print("Nhập tuổi: ");
//                    if (sc.hasNextInt()) {
//                        person.setAge(sc.nextInt());
//                        if (person.getAge() < 0) {
//                            System.out.println("Tuổi không hợp lệ! Phải >= 0.\n");
//                            continue;
//                        }
//                        sc.nextLine();
//                        break;
//                    } else {
//                        System.out.println("Tuổi không hợp lệ! Nhập số nguyên.\n");
//                        sc.nextLine();
//                    }
//                }
//
//                while (true) {
//                    System.out.print("Nhập email: ");
//                    person.setEmail(sc.nextLine().trim());
//                    if (person.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
//                        break;
//                    } else {
//                        System.out.println("Email không hợp lệ! Vui lòng nhập đúng định dạng (vd: ten@gmail.com).\n");
//                    }
//                }
//                break;
//            }
//        }
//
//        if (!isFound) {
//            System.out.println("Không tìm thấy ID muốn cập nhật!");
//        }
//    }
//
//    private static void menuSortByAVG() {
//        int choose;
//        while (true) {
//            do {
//                System.out.println("===== Màn Hình 4 =====\nSẮP XẾP THEO ĐIỂM TRUNG BÌNH");
//                System.out.println("1. Học viên backend");
//                System.out.println("2. Học viên fullstack");
//                System.out.println("3. Trở về menu chính");
//
//                System.out.print("Mời bạn lựa chọn: ");
//                choose = Integer.parseInt(sc.nextLine());
//
//                switch (choose) {
//                    case 1 -> sortStudents(StudentBE.class);
//                    case 2 -> sortStudents(StudentFS.class);
//                    case 3 -> {
//                        return;
//                    }
//                    default -> System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
//                }
//            } while (choose < 1 || choose > 3);
//        }
//    }
//
//    private static <T extends Student> void sortStudents(Class<T> type) {
//        if (persons.isEmpty()) {
//            System.out.println("Hiện tại chưa có thành viên nào!");
//            return;
//        }
//
//        ArrayList<T> filteredList = getList(type);
//        if (filteredList.isEmpty()) {
//            System.out.println("Không có học viên nào !");
//            return;
//        }
//
//        System.out.println("1. Tăng dần theo điểm trung bình");
//        System.out.println("2. Giảm dần theo điểm trung bình");
//        System.out.print("Chọn cách sắp xếp: ");
//        int choose = Integer.parseInt(sc.nextLine());
//
//        if (choose == 1) {
//            Collections.sort(filteredList);
//        } else if (choose == 2) {
//            filteredList.sort(Collections.reverseOrder());
//        } else {
//            System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
//            return;
//        }
//
//        System.out.println("----- Danh sách sau khi sắp xếp theo điểm trung bình -----");
//        int count = 1;
//        for (T student : filteredList) {
//            System.out.println("Học viên thứ " + count++);
//
//            System.out.println("ID: " + student.getId());
//            System.out.println("Tên: " + student.getFullName());
//            System.out.println("Email: " + student.getEmail());
//            System.out.println("Điểm trung bình: " + student.getAvgScore());
//            System.out.println("Xếp loại: " + student.getClassify());
//            System.out.println("----------------------------");
//        }
//    }
//
//    private static void findSupportsOfTeacher() {
//        System.out.print("Nhập id giảng viên cần tra cứu: ");
//        String id = sc.nextLine().trim();
//
//        Lecturer foundLecturer = null;
//
//        for (Person p : persons) {
//            if (p instanceof Lecturer && id.equals(p.getId())) {
//                foundLecturer = (Lecturer) p;
//                break;
//            }
//        }
//
//        if (foundLecturer == null) {
//            System.out.println("Không tìm thấy giảng viên với ID: " + id);
//            return;
//        }
//
//        ArrayList<TeachingAssistant> teachingAssistants = new ArrayList<>();
//        for (Person p : persons) {
//            if (p instanceof TeachingAssistant ta) {
//                for (Lecturer supported : ta.getLecturers()) {
//                    if (supported.equals(foundLecturer)) {
//                        teachingAssistants.add(ta);
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println("Giảng viên: \n" + foundLecturer);
//        System.out.println("Số lượng trợ giảng hỗ trợ: " + teachingAssistants.size());
//
//        if (teachingAssistants.isEmpty()) {
//            System.out.println("Không có trợ giảng nào hỗ trợ giảng viên này.");
//        } else {
//            System.out.println("Danh sách trợ giảng:");
//            for (TeachingAssistant ta : teachingAssistants) {
//                System.out.println(" - " + ta);
//            }
//        }
//    }
//
//    private static void getStudentById() {
//        ArrayList<Student> students = getList(Student.class);
//        if (students.isEmpty()) {
//            System.out.println("Hiện tại chưa có học viên nào!");
//            return;
//        }
//
//        HashMap<String, Student> studentsMap = new HashMap<>();
//        for (Person p : persons) {
//            if (p instanceof Student) {
//                studentsMap.put(p.getId(), (Student) p);
//            }
//        }
//
//        System.out.print("Nhập id cần tìm: ");
//        String id = sc.nextLine().trim();
//
//        Student student = studentsMap.get(id);
//
//        if (student == null) {
//            System.out.println("Không tìm thấy học viên!");
//            return;
//        }
//
//        System.out.println("Học viên cần tìm");
//        System.out.println(student);
//    }
//
//    private static void menuCourseScheduleManager() {
//        System.out.println("===== Màn Hình =====");
//        System.out.println("Hệ Thống Quản Lý Academy");
//        System.out.println("1. Thêm lớp học");
//        System.out.println("2. Thêm lịch dạy");
//        System.out.println("3. Hiển thị lớp học");
//        System.out.println("4. Hiển thị lịch dạy");
//        System.out.println("5. Thêm học viên vào lớp học");
//        System.out.println("6. Chọn giảng viên cho lịch dạy");
//        System.out.println("7. Xóa lịch dạy theo ngày");
//        System.out.println("8. Tìm lớp học theo mã lớp");
//        System.out.println("9. Về menu chính");
//    }
//
//    private static void addNewCourse() {
//        Course newCourse = new Course();
//        do {
//            newCourse.setId(getRandomIdentify());
//        } while (!checkIdentify(newCourse.getId()));
//        newCourse.input();
//        courses.add(newCourse);
//        System.out.println("Thêm mới lớp học thành công!");
//    }
//
//    private static void addSchedule() {
//        Schedule newSchedule = new Schedule();
//        System.out.println("=== Thêm buổi giảng mới ===");
//        newSchedule.input();
//        schedules.add(newSchedule);
//    }
//
//    private static void showCourses() {
//        if (courses.isEmpty()) {
//            System.out.println("Hiện tại chưa có lớp học nào!");
//            return;
//        }
//
//        System.out.println("Danh sách lớp học");
//        for (Course c : courses) {
//            System.out.println(c);
//        }
//    }
//
//    private static void showSchedule() {
//        if (schedules.isEmpty()) {
//            System.out.println("Hiện tại chưa có lịch dạy!");
//            return;
//        }
//
//        System.out.println("Danh sách lịch dạy: ");
//        for (Schedule schedule : schedules) {
//            System.out.println(schedule);
//        }
//    }
//
//    public static void addStudentToClass() {
//        ArrayList<Student> students = getList(Student.class);
//        if (courses.isEmpty()) {
//            System.out.println("Hiện chưa có lớp học nào.");
//            return;
//        }
//
//        System.out.println("=== DANH SÁCH LỚP HỌC ===");
//        for (int i = 0; i < courses.size(); i++) {
//            System.out.printf("%d. %s - %s\n", i + 1, courses.get(i).getId(), courses.get(i).getName());
//        }
//
//        int choice;
//        while (true) {
//            try {
//                System.out.print("Chọn lớp học để thêm học viên: ");
//                choice = Integer.parseInt(sc.nextLine());
//
//                if (choice < 1 || choice > courses.size()) {
//                    System.out.println("Lựa chọn không hợp lệ!");
//                    continue;
//                }
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập số hợp lệ!");
//            }
//        }
//        Course selectedCourse = courses.get(choice - 1);
//
//        // học viên chưa có lớp
//        ArrayList<Student> studentInAllClasses = new ArrayList<>(selectedCourse.getStudents());
//        // studentInAllClasses.addAll(selectedCourse.getStudents());
//
//        ArrayList<Student> studentsNotInClass = new ArrayList<>();
//        for (Student s : students) {
//            if (!studentInAllClasses.contains(s)) {
//                studentsNotInClass.add(s);
//            }
//        }
//
//        if (studentsNotInClass.isEmpty()) {
//            System.out.println("Tất cả học viên đã có lớp.");
//            return;
//        }
//
//        while (true) {
//            System.out.println("=== DANH SÁCH HỌC VIÊN CHƯA VÀO LỚP ===");
//            for (int i = 0; i < studentsNotInClass.size(); i++) {
//                System.out.printf("%d. %s - %s\n", i + 1, studentsNotInClass.get(i).getId(), studentsNotInClass.get(i).getFullName());
//            }
//
//            System.out.print("Chọn học viên để thêm: ");
//            int studentChoice = Integer.parseInt(sc.nextLine());
//            if (studentChoice < 1 || studentChoice > studentsNotInClass.size()) {
//                System.out.println("Lựa chọn không hợp lệ!");
//                continue;
//            }
//
//            Student selectedStudent = studentsNotInClass.get(studentChoice - 1);
//            selectedCourse.addStudents(selectedStudent);
//            studentsNotInClass.removeSchedule(selectedStudent);
//            System.out.printf("Đã thêm học viên %s vào lớp %s.\n", selectedStudent.getFullName(), selectedCourse.getName());
//            System.out.println("Muốn tiếp tục chọn hay không ? (Y/N)");
//            String choose = sc.nextLine();
//            if (choose.equalsIgnoreCase("Y")) {
//                continue;
//            }
//            System.out.println("Hoàn thành thêm học viên.");
//            break;
//        }
//    }
//
//    private static void deleteSchedule() {
//        LocalDate dateToDelete = null;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String keyword;
//
//        while (true) {
//            System.out.println("Nhập ngày-tháng-năm cần xóa (dd/MM/yyyy):");
//            keyword = sc.nextLine().trim();
//            try {
//                dateToDelete = LocalDate.parse(keyword, formatter);
//                break;
//            } catch (DateTimeParseException e) {
//                System.out.println("Ngày nhập không hợp lệ! Vui lòng nhập lại.\n");
//            }
//        }
//
//        Iterator<Schedule> i = schedules.iterator();
//        boolean found = false;
//
//        while (i.hasNext()) {
//            Schedule s = i.next();
//            if (s.getDay() != null && s.getDay().equals(dateToDelete)) {
//                i.removeSchedule();
//                found = true;
//            }
//        }
//
//        if (found) {
//            System.out.println("Đã xóa lịch có ngày " + keyword);
//        } else {
//            System.out.println("Không tìm thấy lịch có ngày " + keyword);
//        }
//    }
//
//    private static void displaySchedule() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        if (schedules.isEmpty()) {
//            System.out.println("Danh sách buổi giảng trống.");
//            return;
//        }
//        int count = 0;
//        for (Schedule s : schedules) {
//            System.out.println("Lịch học thứ: " + (++count));
//
//            String dayFormatted = (s.getDay() != null) ? s.getDay().format(formatter) : "Chưa có ngày";
//            String content = (s.getContent() != null && !s.getContent().isEmpty()) ? s.getContent() : "Chưa có nội dung";
/// /            String lecturer = (s.getLecturer() != null) ? s.getLecturer().getFullName() : "Chưa có giảng viên";
//
//            System.out.println("Ngày: " + dayFormatted);
//            System.out.println("Nội dung: " + content);
/// /            System.out.println("Giảng viên đảm nhận: " + lecturer);
//            System.out.println("---------------------------\n");
//        }
//    }
//
//    private static void addLecturerToSchedule() {
//        ArrayList<Lecturer> lecturers = getList(Lecturer.class);
//
//        if (schedules.isEmpty()) {
//            System.out.println("Hiện tại chưa có lịch dạy nào!");
//            return;
//        }
//
//        if (lecturers.isEmpty()) {
//            System.out.println("Hiện tại chưa có giảng viên");
//            return;
//        }
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        ArrayList<Schedule> scheduleNotAssign = new ArrayList<>();
//
//        for (Schedule s : schedules) {
/// /            if (s.getLecturer() == null) {
//                scheduleNotAssign.add(s);
//            }
//        }
//
//        Schedule selectedSchedule;
//        while (true) {
//            try {
//                System.out.println("===== Danh sách lịch dạy không có giảng viên =========");
//                for (int i = 0; i < scheduleNotAssign.size(); i++) {
//                    System.out.println((i + 1) + ". " + scheduleNotAssign.get(i).getContent()
//                            + String.format(" (%s)", scheduleNotAssign.get(i).getDay().format(formatter)));
//                }
//                System.out.print("Lựa chọn: ");
//                int choice = Integer.parseInt(sc.nextLine());
//
//                if (choice < 1 || choice > scheduleNotAssign.size()) {
//                    System.out.println("Lựa chọn không hợp lệ!");
//                    continue;
//                }
//
//                selectedSchedule = scheduleNotAssign.get(choice - 1);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập số nguyên dương!");
//            }
//        }
//
//        while (true) {
//            Lecturer selectedLecturer;
//
//            while (true) {
//                try {
//                    System.out.println("===== Chọn giảng viên =======");
//                    for (int i = 0; i < lecturers.size(); i++) {
//                        System.out.println((i + 1) + ". " + lecturers.get(i).getId() + " - "
//                                + lecturers.get(i).getFullName());
//                    }
//                    System.out.print("Lựa chọn: ");
//                    int choice = Integer.parseInt(sc.nextLine());
//
//                    if (choice < 1 || choice > lecturers.size()) {
//                        System.out.println("Lựa chọn không hợp lệ!");
//                        continue;
//                    }
//                    selectedLecturer = lecturers.get(choice - 1);
//                    break;
//                } catch (NumberFormatException e) {
//                    System.out.println("Vui lòng nhập số nguyên dương!");
//                }
//            }
//
//            HashMap<String, String> scheduleOfLecturer = new HashMap<>();
//            for (Schedule s : schedules) {
//                if (s.getLecturer() != null && s.getLecturer().equals(selectedLecturer)) {
//                    scheduleOfLecturer.put(s.getDay().format(formatter), s.getContent());
//                }
//            }
//
//            if (scheduleOfLecturer.containsKey(selectedSchedule.getDay().format(formatter))) {
//                System.out.println("Giảng viên bạn chọn đã bận lịch!");
//                continue;
//            }
//            selectedSchedule.setLecturer(selectedLecturer);
//            break;
//        }
//    }
//
//    private static void getCourseById() {
//        if (courses.isEmpty()) {
//            System.out.println("Hiện tại chưa có lớp học nào!");
//            return;
//        }
//
//        HashMap<String, Course> coursesMap = new HashMap<>();
//        for (Course c : courses) {
//            coursesMap.put(c.getId(), c);
//        }
//
//        System.out.print("Nhập mã lớp: ");
//        String id = sc.nextLine().trim();
//
//        Course course = coursesMap.get(id);
//
//        if (course == null) {
//            System.out.println("Không tìm thấy lớp học.");
//            return;
//        }
//
//        System.out.println("Lớp học cần tìm.");
//        System.out.println(course);
//
//    }
//
//    private static void courseScheduleManager() {
//        while (true) {
//            try {
//                menuCourseScheduleManager();
//                System.out.print("Lựa chọn của bạn: ");
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1 -> addNewCourse();
//                    case 2 -> addSchedule();
//                    case 3 -> showCourses();
//                    case 4 -> displaySchedule();
//                    case 5 -> addStudentToClass();
//                    case 6 -> addLecturerToSchedule();
//                    case 7 -> deleteSchedule();
//                    case 8 -> getCourseById();
//                    case 9 -> {
//                        return;
//                    }
//                    default -> System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập số nguyên dương!");
//            }
//        }
//    }
//
//
//    private static void memberManager() {
//        while (true) {
//            try {
//                menuMemberManager();
//                System.out.print("Lựa chọn của bạn: ");
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1 -> processAdd();
//                    case 2 -> processShowPerson();
//                    case 3 -> findPerson();
//                    case 4 -> menuUpdate();
//                    case 5 -> menuDelete();
//                    case 6 -> menuSortByAVG();
//                    case 7 -> findSupportsOfTeacher();
//                    case 8 -> getStudentById();
//                    case 9 -> {
//                        return;
//                    }
//                    default -> System.out.println("Lựa chọn không hợp lệ xin chọn lại!\n");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập số nguyên dương!");
//            }
//        }
//    }
//
////    private static void getScheduleByLecturer() {
////        if (schedules.isEmpty()) {
////            System.out.println("Hiện tại chưa có lịch dạy!");
////            return;
////        }
////
////        ArrayList<Lecturer> lecturers = getList(Lecturer.class);
////        if (lecturers.isEmpty()) {
////            System.out.println("Hiện tại chưa có giảng viên!");
////            return;
////        }
////
////        while (true) {
////            try {
////                System.out.println("==== Danh sách giảng viên ====");
////                for (int i = 0; i < lecturers.size(); i++) {
////                    System.out.println((i + 1) + ". " + lecturers.get(i).getId() + " - "
////                            + lecturers.get(i).getFullName());
////                }
////                System.out.print("Lựa chọn: ");
////                int choice = Integer.parseInt(sc.nextLine());
////
////                if (choice < 1 || choice > lecturers.size()) {
////                    System.out.println("Lựa chọn không hợp lệ!");
////                    continue;
////                }
////
////
////            } catch (NumberFormatException e) {
////                System.out.println("Vui lòng chọn số nguyên dương!");
////            }
////        }
////    }
//
//    public static void main(String[] args) {
////        initializeSampleData();
//        while (true) {
//            try {
//                mainMenu();
//                System.out.print("Lựa chọn của bạn: ");
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1 -> memberManager();
//                    case 2 -> courseScheduleManager();
//                    case 3 -> {
//                        return;
//                    }
//                    default -> System.out.println("Lựa chọn không hợp lệ!");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng nhập số nguyên dương!");
//            }
//        }
//    }
//}
