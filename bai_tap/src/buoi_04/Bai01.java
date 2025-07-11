package buoi_04;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đoạn văn ");
        String p = sc.nextLine();

        p = p.replaceAll(" ", "").trim();

        int cauHoi = 0;
        int camThan = 0;
        int tuongThuat = 0;

        for (int  i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '?') {
                cauHoi++;
            } else if (p.charAt(i) == '!') {
                camThan++;
            }  else if (p.charAt(i) == '.') {
                tuongThuat++;
            }
        }

        int tongSoCau = cauHoi + camThan + tuongThuat;

        System.out.println("Tổng số câu: " + tongSoCau);
        System.out.println("Câu hỏi (?): " + cauHoi);
        System.out.println("Câu cảm thán (!): " + camThan);
        System.out.println("Câu trần thuật (.): " + tuongThuat);
    }
}
