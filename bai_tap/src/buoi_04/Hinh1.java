package buoi_04;

public class Hinh1 {
    public static void main(String[] args) {
        // Câu a
        System.out.println("Câu a: ");
        StringBuffer strBuffer = new StringBuffer("Hello World");
        String output = strBuffer.substring(6);
        System.out.println(output);

        StringBuilder strBuilder = new StringBuilder("Hello World");
        String output2 = strBuilder.substring(6);
        System.out.println(output2);

        // Câu b
        System.out.println("\nCâu b: ");
        for (int i = 0; i < strBuffer.length(); i++) {
            if (strBuffer.charAt(i) == 'o') {
                strBuffer.setCharAt(i, 'f');
            }
        }
        System.out.println(strBuffer);

        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == 'o') {
                strBuilder.setCharAt(i, 'f');
            }
        }
        System.out.println(strBuilder);

        // Câu c
        System.out.println("\nCâu c: ");
        String hello = "Hello";
        String world = "World";
        StringBuilder strBuilderC = new StringBuilder();

        System.out.println(String.join(" ", hello, world));

        strBuilderC.append(hello);
        strBuilderC.append(" ");
        strBuilderC.append(world);
        System.out.println(strBuilderC);

        // Câu d:
        // Tạo ra 4 đối tượng
        // Kết quả hiện thị là: AABAACEFGH

        // Câu e
        System.out.println("\nCâu e: ");
        System.out.println("== String ==");
        String str1 = "Hello";
        String str2 = new String("Hello");

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): "+ str1.equals(str2));

        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("Hello");

        System.out.println("\n== StringBuffer ==");
        System.out.println("sb1 == sb2: " + (sb1 == sb2));
        System.out.println("sb1.equals(sb2): " + sb1.equals(sb2));

        StringBuilder sbld1 = new StringBuilder("Hello");
        StringBuilder sbld2 = new StringBuilder("Hello");

        System.out.println("\n== StringBuilder ==");
        System.out.println("sbld1 == sbld2: " + (sbld1 == sbld2));
        System.out.println("sbld1.equals(sbld2): " + sbld1.equals(sbld2));
    }
}
