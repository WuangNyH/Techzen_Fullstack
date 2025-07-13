package buoi_04;

import java.util.Scanner;

public class Bai01 {
    public static void demSoCau(String paragraph) {
        paragraph = paragraph.replaceAll(" ", "").trim();

        int soCauHoi = 0, soCamThan = 0, soTuongThuat = 0;

        for (char c : paragraph.toCharArray()) {
            switch (c) {
                case '?': soCauHoi++; break;
                case '!': soCamThan++; break;
                case '.': soTuongThuat++; break;
                default: break;
            }
        }

        int tongSoCau = soTuongThuat + soCauHoi + soCamThan;

        System.out.println("Tổng số câu: " + tongSoCau);
        System.out.println("Câu hỏi (?): " + soCauHoi);
        System.out.println("Câu cảm thán (!): " + soCamThan);
        System.out.println("Câu trần thuật (.): " + soTuongThuat);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập đoạn văn: ");
        String paragraph = sc.nextLine();

        demSoCau(paragraph);
    }
}
