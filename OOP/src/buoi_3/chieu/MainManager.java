package buoi_3.chieu;

import java.util.ArrayList;
import java.util.Scanner;

public class MainManager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Person> persons = new ArrayList<>();


//    private static String getIdStudentBE2() {
//        int max = 0;
//
//        for (Person p : persons) {
//            if (p instanceof StudentBE) {
//                String idStr = p.getId().substring(3);
//                int id = Integer.parseInt(idStr);
//                if (id > max) {
//                    max = id;
//                }
//            }
//        }
//
//        if (max == 0) {
//            return "SBE00001";
//        }
//
//        return String.format("SBE%05d", max + 1);
//    }


    private static String getIdentityId(Class<?> clazz) {
        int max = 0;
        String prefix = "";

        if (clazz == StudentBE.class) {
            prefix = "SBE";
        } else if (clazz == StudentFT.class) {
            prefix = "SFT";
        } else if (clazz == Teacher.class) {
            prefix = "T";
        }

        for (Person p : persons) {
            if (clazz.isInstance(p)) {
                String idStr = p.getId().substring(prefix.length());
                int id = Integer.parseInt(idStr);
                if (id > max) {
                    max = id;
                }
            }
        }

        int numDigits = 10 - prefix.length();
        return String.format("%s%0" + numDigits + "d", prefix, max + 1);
    }


    private static void menuShowList() {
        int choose;
        while (true) {
            do {
                System.out.println("===== Màn Hình 3 =====\nDANH SÁCH NHÂN VIÊN");
                System.out.println("1. Thêm thành viên (học viên Backend / Fullstack hoặc giảng viên.)");
                System.out.println("2. Hiển thị danh sách thành viên");
                System.out.println("3. Tìm kiếm thành viên theo tên hoặc email");
                System.out.println("4. Thống kê:");
                System.out.println("    Số học viên Backend");
                System.out.println("    Số học viên Fullstack");
                System.out.println("    Số học viên Fullstack có ≥ 3 dự án");
                System.out.println("    Số giảng viên có hơn 30 giờ dạy");
                System.out.println("5. Hiển thị học viên giỏi nhất của từng loại");
                System.out.println("6. Tính tổng lương của toàn bộ giảng viên");
                System.out.println("7. Thoát...");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(sc.nextLine());

                switch (choose) {
                    case 1:
                        for (int i = 0; i < persons.size(); i++) {
                            System.out.println("Thông tin nhân viên thứ " + (i + 1));
//                            persons.get(i).output();
                        }
                        break;
                    case 2:
                        // logic show danh sách nhân viên sản xuất
                        break;
                    case 3:
                        // logic show danh sách cả 2 loại nhân viên
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 7);
        }
    }

    private static void showStudentStatistics() {
        int countStudentBE = 0;
        int countStudentFT = 0;
        int countFTOver3Projects = 0;
        int countTeacherOver30h = 0;

        for (Person p : persons) {
            if (p instanceof StudentBE) {
                countStudentBE++;
            } else if (p instanceof StudentFT) {
                StudentFT ft = (StudentFT) p;
                countStudentFT++;
                if (ft.soDuAnThamGia >= 3) {
                    countFTOver3Projects++;
                }
            } else if (p instanceof Teacher) {
                Teacher t = (Teacher) p;
                if (t.getSoGioDay() > 30) {
                    countTeacherOver30h++;
                }
            }
        }

        System.out.println("Số học viên Backend: " + countStudentBE);
        System.out.println("Số học viên Fullstack: " + countStudentFT);
        System.out.println("Số học viên Fullstack có từ 3 dự án trở lên: " + countFTOver3Projects);
        System.out.println("Số giảng viên có hơn 30 giờ dạy: " + countTeacherOver30h);
    }

    public static void main(String[] args) {
        persons.add(new Teacher("GV001", "Nguyễn Văn A", 35, "a@gmail.com", "Toán", 120.0));
        persons.add(new Teacher("GV002", "Trần Thị B", 40, "b@gmail.com", "Văn", 10.0));
        persons.add(new Teacher("GV003", "Lê Văn C", 45, "c@gmail.com", "Lý", 90.5));

        persons.add(new StudentBE("BE001", "Phạm Minh D", 20, "d@gmail.com", 8.5, "Java"));
        persons.add(new StudentBE("BE002", "Ngô Thị E", 21, "e@gmail.com", 7.0, "C#"));
        persons.add(new StudentBE("BE003", "Đặng Văn F", 22, "f@gmail.com", 5.5, "Python"));

        persons.add(new StudentFT("FT001", "Huỳnh Hữu G", 20, "g@gmail.com", 9.0, 4));
        persons.add(new StudentFT("FT002", "Đỗ Thị H", 21, "h@gmail.com", 7.0, 2));
        persons.add(new StudentFT("FT003", "Trịnh Văn I", 23, "i@gmail.com", 6.0, 1));

        showStudentStatistics();
    }
}
