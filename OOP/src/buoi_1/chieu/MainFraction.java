package buoi_1.chieu;

import java.util.Scanner;

public class MainFraction {
    static Scanner sc = new Scanner(System.in);


    public static void displayMenu() {
        System.out.println(">> LỰA CHỌN TÍNH NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Thao tác với 1 phân số                   |");
        System.out.println("| 2. Tính 2 phân số                           |");
        System.out.println("| 3. Kết thúc                                 |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void displayMenu1() {
        System.out.println(">> LỰA CHỌN TÍNH NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Rút gọn                                  |");
        System.out.println("| 2. KIểm tra âm, dương hoặc bằng 0           |");
        System.out.println("| 3. Kết thúc                                 |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void displayMenu2() {
        System.out.println(">> LỰA CHỌN TÍNH NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.println("| 1. Cộng                                     |");
        System.out.println("| 2. Trừ                                      |");
        System.out.println("| 3. Nhân                                     |");
        System.out.println("| 4. Chia                                     |");
        System.out.println("| 5. Kết thúc                                 |");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void processMenu1(Fraction fraction) {
        while (true) {
            displayMenu1();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    fraction.output();
                    break;
                case 2:
                    if (fraction.checkSign() == 0) {
                        System.out.println("Fraction is zero");
                    } else if (fraction.checkSign() > 0) {
                        System.out.println("Fraction is positive");
                    } else {
                        System.out.println("Fraction is negative");
                    }
                    break;
                default:
                    sc.nextLine();
                    System.out.print("Are u sure return main menu (Y/N): ");
                    String exit = sc.nextLine();
                    if (exit.equalsIgnoreCase("y")) {
                        return;
                    }
                    break;
            }
        }
    }

    public static void processMenu2(Fraction f1, Fraction f2) {
        while (true) {
            displayMenu2();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Fraction sum = f1.sum(f2);
                    System.out.println(f1 + " + " + f2 + " = " + sum);
                    break;
                case 2:
                    Fraction sub = f1.sub(f2);
                    System.out.println(f1 + " - " + f2 + " = " + sub);
                    break;
                case 3:
                    Fraction mul = f1.mul(f2);
                    System.out.println(f1 + " * " + f2 + " = " + mul);
                    break;
                case 4:
                    Fraction div = f1.div(f2);

                    if (div == null) {
                        System.out.println("Cannot divide by zero.");
                        break;
                    }

                    System.out.println(f1 + " : " + f2 + " = " + div);
                    break;
                default:
                    sc.nextLine();
                    System.out.print("Are u sure return main menu (Y/N): ");
                    String exit = sc.nextLine();
                    if (exit.equalsIgnoreCase("y")) {
                        return;
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Fraction fraction = new Fraction();
                    fraction.input(sc);
                    processMenu1(fraction);
                    break;
                case 2:
                    Fraction fraction1 = new Fraction();
                    System.out.println("Enter fraction #1");
                    fraction1.input(sc);

                    Fraction fraction2 = new Fraction();
                    System.out.println("Enter fraction #2");
                    fraction2.input(sc);

                    processMenu2(fraction1, fraction2);
                    break;
                default:
                    sc.nextLine();
                    System.out.print("Are u sure exit program (Y/N): ");
                    String exit = sc.nextLine();
                    if (exit.equalsIgnoreCase("y")) {
                        return;
                    }
                    break;
            }
        }
    }
}
