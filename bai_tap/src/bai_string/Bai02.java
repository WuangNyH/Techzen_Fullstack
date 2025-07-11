package bai_string;

public class Bai02 {
    public static void main(String[] args) {
        String str = "2003";

        // Câu a
        int integer = Integer.parseInt(str);
        System.out.println("Câu a: " + integer + " (int)");

        // Câu b
        String output = String.valueOf(integer);
        System.out.println("Câu b: " + output + " (String)");

        // Câu c
        long longNumber = Long.parseLong(str);
        System.out.println("Câu c: " + longNumber + " (long)");

        // Câu d
        output = String.valueOf(longNumber);
        System.out.println("Câu d: " + output + " (String)");

        // Câu e
        float floatNumber = Float.parseFloat(str);
        System.out.println("Câu e: " + floatNumber + " (float)");

        // Câu f
        output = String.valueOf(floatNumber);
        System.out.println("Câu f: " + output + " (String)");

        // Câu g
        double doubleNumber = Double.parseDouble(str);
        System.out.println("Câu e: " + doubleNumber + " (double)");

        // Câu h
        output = String.valueOf(doubleNumber);
        System.out.println("Câu h: " + output + " (String)");

        // Câu i
        short shortNumber = Short.parseShort(str);
        System.out.println("Câu i: " + shortNumber + " (short)");

        // Câu k
        output = String.valueOf(shortNumber);
        System.out.println("Câu k: " + output + " (String)");
    }
}
