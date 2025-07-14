package buoi_05;

import java.util.Arrays;
import java.util.Comparator;

import static bai_06.bai_tap_method.Bai02.isPrimeNumber;

public class Hinh01 {
    public static int[] tachSoNguyenTo(int[] arr) {
        int countPrime = 0;
        int newIndex = 0;
        for (int num : arr) {
            if (isPrimeNumber(num)) countPrime++;
        }

        int[] newArr = new int[countPrime];

        for (int number : arr) {
            if (isPrimeNumber(number)) newArr[newIndex++] = number;
        }

        return newArr;
    }

    public static void tachPhanTuDuong(int[] arr) {
        int soDuong = 0;
        int indexDuong = 0;
        int indexConLai = 0;

        for (int num : arr) {
            if (num > 0) soDuong++;
        }

        int[] arrDuong = new int[soDuong];
        int[] arrConLai = new int[arr.length - soDuong];

        for (int num : arr) {
            if (num > 0) {
                arrDuong[indexDuong++] = num;
            } else {
                arrConLai[indexConLai++] = num;
            }
        }

        System.out.println("Mảng dương: " + Arrays.toString(arrDuong));
        System.out.println("Mảng còn lại: " + Arrays.toString(arrConLai));
    }

    public static int[] sapXepGiamDan(int[] arr) {
        int temp;

        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }


        return arr;
    }

    // Sắp xếp mảng
    // - số dương đầu tiên theo thứ tự giảm dần
    // - tiếp theo số âm theo thứ tự tăng dần
    // - đế số 0

    // Solution
    // - Tách ra 2 mảng một mảng dương và mảng các số còn lại (giống câu b)
    // - Sắp xếp mảng dương theo thứ tự giảm dần
    // - Sắp xếp mảng còn lại theo thứ tự tăng dần
    // - Gộp mảng
    public static int[] cauD(int[] arr) {
        int soDuong = 0;
        int indexDuong = 0;
        int indexConLai = 0;
        int newIndex = 0;

        for (int num : arr) {
            if (num > 0) soDuong++;
        }

        Integer[] arrDuong = new Integer[soDuong];
        int[] arrConLai = new int[arr.length - soDuong];

        for (int num : arr) {
            if (num > 0) {
                arrDuong[indexDuong++] = num;
            } else {
                arrConLai[indexConLai++] = num;
            }
        }

        Arrays.sort(arrDuong, Comparator.reverseOrder());
        Arrays.sort(arrConLai);

        for (int num : arrDuong) {
            arr[newIndex++] = num;
        }

        for (int num : arrConLai) {
            arr[newIndex++] = num;
        }

        return arr;
    }

    public static int[] daoMang(int[] arr) {
        int[] newArr = new int[arr.length];
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            newArr[idx++] = arr[i];
        }
        return newArr;
    }

    public static boolean laMangDoiXuong(int[] arr) {
        int[] newArr = daoMang(arr);
        return Arrays.equals(newArr, arr);
    }

    public static int soCapDoiXung(int[] arr) {
        int count = 0;
        int[] newArr = daoMang(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            if (newArr[i] == arr[i]) count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Câu a
        int[] arrA = {1, 2, 3, 4, 5};
        int[] arrPrime = tachSoNguyenTo(arrA);
        System.out.println(Arrays.toString(arrPrime));

        // Câu b
        int[] arrB = {-1, 2, -3, -4, 5};
        tachPhanTuDuong(arrB);

        // Câu c
        int[] arrC = {5, 6, 8, 9, 2};
        int[] mangGiamDan = sapXepGiamDan(arrC);
        System.out.println(Arrays.toString(mangGiamDan));

        // Câu d
        int[] arrD = {5, -6, 8, 9, 2, -10, -9, 0, 9, -2, 0};
        System.out.println(Arrays.toString(cauD(arrD)));

        // Câu e
        int[] arrE = {2, 4, 5, 6, 7};
        System.out.println(Arrays.toString(daoMang(arrE)));

        // Câu f
        int[] arrF = {2, 1, 0, 1, 2};
        if (laMangDoiXuong(arrF)) {
            System.out.println("Là mảng đối xứng!");
        } else {
            System.out.println("Không phải mảng đối xứng");
        }

        // Câu g
        int[] arrG = {1, 2, 8, 7, 3, 7, 4, 2, 1};
        System.out.println("Số cặp đố xứng trong mảng là: " + soCapDoiXung(arrG));
    }
}
