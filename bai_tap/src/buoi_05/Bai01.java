package buoi_05;

import java.util.Scanner;

public class Bai01 {
    public static void printListEmployee(String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        System.out.println("==== Danh sách nhân viên ====");
        for (int i = 1; i <= fullNames.length; i++) {
            System.out.printf("==== Nhân viên %d ====\n", i);
            getEmployee(i, fullNames, ages, genders, salaries, gpas);
        }
    }

    public static void getEmployee(int id, String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        if (id - 1 >= fullNames.length || id - 1 < 0) {
            System.out.println("ID không hợp lệ!");
            return;
        }

        System.out.println("ID: " + (id));
        System.out.println("Fullname: " + fullNames[id - 1]);
        System.out.println("Age: " + ages[id - 1]);
        System.out.println("Gender: " + genders[id - 1]);
        System.out.println("Salary: " + String.format("%,.0f", salaries[id - 1]));
        System.out.println("GPA: " + String.format("%.1f", gpas[id - 1]));
    }

    public static void sapXepTheoTuoi(String[] fullNames, int[] ages, String[] genders, double[] salaries, double[] gpas) {
        int temp;
        String tempString;
        double tempDouble;

        for (int i = 0 ; i < ages.length - 1; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (ages[i] > ages[j]) {
                    // Swap fullName
                    tempString = fullNames[j];
                    fullNames[j] = fullNames[i];
                    fullNames[i] = tempString;

                    // Swap age
                    temp = ages[j];
                    ages[j] = ages[i];
                    ages[i] = temp;

                    // Swap gender
                    tempString = genders[j];
                    genders[j] = genders[i];
                    genders[i] = tempString;

                    // Swap salary
                    tempDouble = salaries[j];
                    salaries[j] = salaries[i];
                    salaries[i] = tempDouble;

                    // Swap GPA
                    tempDouble = gpas[j];
                    gpas[j] = gpas[i];
                    gpas[i] = tempDouble;
                }
            }
        }

        printListEmployee(fullNames, ages, genders, salaries, gpas);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Số nhân viên cần nhập: ");
        int soNhanVien = Integer.parseInt(sc.nextLine());

        String[] fullNames = new String[soNhanVien];
        int[] ages = new int[soNhanVien];
        String[] genders = new String[soNhanVien];
        double[] salaries = new double[soNhanVien];
        double[] gpas = new double[soNhanVien];

        for (int i = 0; i < soNhanVien; i++) {
            System.out.println("================================");
            System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
            fullNames[i] = sc.nextLine();

            System.out.print("Nhập tuổi nhân viên thứ " + (i + 1) + ": ");
            ages[i] = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập giới tính nhân viên thứ " + (i + 1) + " (Nam/Nữ): ");
            genders[i] = sc.nextLine();

            System.out.print("Nhập lương nhân viên thứ " + (i + 1) + " (lớn hơn 0): ");
            salaries[i] = Double.parseDouble(sc.nextLine());

            System.out.print("Nhập GPA nhân viên thứ " + (i + 1) + " (0-4): ");
            gpas[i] = Double.parseDouble(sc.nextLine());
        }

        System.out.print("Nhập id nhân viên muốn tìm kiếm: ");
        int inputId = Integer.parseInt(sc.nextLine());

        getEmployee(inputId, fullNames, ages, genders, salaries, gpas);

        sapXepTheoTuoi(fullNames, ages, genders, salaries, gpas);
    }
}
