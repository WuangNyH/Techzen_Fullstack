package buoi_01;

import java.util.Scanner;

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input product name: ");
        String product = sc.nextLine();

        System.out.print("Input quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Input price: ");
        double price = sc.nextDouble();

        double total = price * quantity;
        double VAT = total * 0.1;

        System.out.println("Your product is: " + product);
        System.out.println("Your total price is: " + total);
        System.out.println("Your VAT is: " + VAT);

        sc.close();
    }
}
