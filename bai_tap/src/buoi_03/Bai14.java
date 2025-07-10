package buoi_03;

public class Bai14 {
    public static void main(String[] args) {
        for  (int i = 10; i <= 99; i++) {
            boolean condition = (i % 10) * (i / 10) == (2 * ((i % 10) + (i / 10)));
            if(condition) {
                System.out.print(i + " ");
            }
        }
    }
}
