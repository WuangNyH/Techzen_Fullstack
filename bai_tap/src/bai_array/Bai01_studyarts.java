package bai_array;

import static bai_06.bai_tap_method.Bai02.isPrimeNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Bai01_studyarts {
    public static int[] nhapMang(int soPhanThu, Scanner sc) {
        int[] arr = new int[soPhanThu];

        for (int i = 1; i <= arr.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i - 1] = sc.nextInt();
        }

        return arr;
    }

    public static void xuatMang(int[] arr) {
        StringBuilder output = new StringBuilder();
        for (int num : arr) {
            output.append(num).append(" ");
        }
        System.out.println(output);
    }

    public static boolean toanChan(int[] arr) {
        for (int num : arr) {
            if (num % 2 != 0) return false;
        }
        return true;
    }

    public static boolean toanSoNguyenTo(int[] arr) {
        for (int num : arr) {
            if (!isPrimeNumber(num)) return false;
        }
        return true;
    }

    public static boolean checkTangDan(int[] arr) {
        int[] originArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(originArr);
        return Arrays.equals(originArr, arr);
    }

    public static int demLe(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) count++;
        }
        return count;
    }

    public static int tongDuongLe(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0 && num > 0) sum += num;
        }
        return sum;
    }

    public static int chiaHet4KhongChiaHet5(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 4 == 0 && num % 5 != 0) count++;
        }
        return count;
    }

    public static int tongNguyenTo(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (isPrimeNumber(num)) sum += num;
        }
        return sum;
    }

    public static void viTriCuoiCung(int[] arr, int target) {
        int output = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) output = i;
        }

        if (output == -1) {
            System.out.printf("Không tìm thấy %d trong mảng\n", target);
            return;
        };

        System.out.printf("Vị trí cuối cùng của %d trong mảng ở vị trí %d\n", target, output);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử trong mảng: ");
        int soPhanTu = sc.nextInt();

        int[] arr = nhapMang(soPhanTu, sc);
        xuatMang(arr);

        if (toanChan(arr)) {
            System.out.println("Mảng toàn số chẵn");
        }

        if (toanSoNguyenTo(arr)) {
            System.out.println("Mảng toàn số nguyên tố");
        }

        if (checkTangDan(arr)) {
            System.out.println("Mảng tăng dần");
        }

        System.out.println("Số phần tử lẻ trong mảng là: " + demLe(arr));
        System.out.println("Tổng số dương lẻ trong mảng là: " + tongDuongLe(arr));
        System.out.println("Số phần tử chia hết cho 4 nhưng không chia hết cho 5: " + chiaHet4KhongChiaHet5(arr));
        System.out.println("Tổng số nguyên tố trong mảng: " + tongNguyenTo(arr));
        viTriCuoiCung(arr, 5);
    }

}
