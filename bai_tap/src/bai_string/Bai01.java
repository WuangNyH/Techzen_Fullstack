package bai_string;

import java.util.Scanner;

public class Bai01 {
    public static void main(String[] args) {
        String str = "Hello World";

        // Câu a
        System.out.println("Câu a: " + str.substring(6));

        // Câu b
        System.out.println("Câu b: " + str.replace("o", "f"));

        // Câu c
        // Cách 1
        char[] arr = str.toCharArray();
        int count = 0;
        for (Character c : arr) {
            if (c.equals('l')) {
                count++;
            }
        }
        System.out.printf("Câu c: Có %d chữ l\n", count);

        // Cách 2
        System.out.printf("Câu c: Có %d chữ l\n", str.length()  - str.replace("l", "").length());

        // Câu d
        System.out.printf("Câu d: Chữ l đầu tiên nằm ở vị trí %d và l cuối cùng nằm ở vị trí %d\n", str.indexOf('l'), str.lastIndexOf('l'));

        // Câu e
        System.out.println("Câu e: " + str.trim().replaceAll(" ", ""));

        // Câu f
        System.out.println("Câu f: " + str.trim());

        // Câu g
        String output = "";
        for (Character c : arr) {
            output = c + output;
        }
        System.out.println("Câu g: " + output);

        // Câu h
        String str2 = "SQC ";
        System.out.println("Câu h: " + String.join(" ", str2, str));

        // Câu i
        String S = "hello world";
        S = S.toUpperCase();
        System.out.println("Câu i: "+ S);

        // Câu k
        S = S.toLowerCase();
        System.out.println("Câu k: "+ S);

        // Câu l
        Scanner sc = new Scanner(System.in);
        System.out.print("Start: ");
        int start = sc.nextInt();

        System.out.print("End: ");
        int end = sc.nextInt();
        System.out.println("Câu l: "+ S.substring(start, end));
    }
}
