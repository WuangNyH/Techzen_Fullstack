package buoi_1.chieu.Fraction;

import java.util.Scanner;

public class Fraction {
    public int numerator;
    public int denominator;

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public void input(Scanner sc) {
        while (true) {
            System.out.print("Enter numerator: ");
            if (sc.hasNextInt()) {
                this.numerator = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid numerator. Please enter an integer!");
                sc.next(); // clear invalid input
            }
        }

        while (true) {
            System.out.print("Enter denominator: ");
            if (sc.hasNextInt()) {
                this.denominator = sc.nextInt();

                if (this.denominator == 0) {
                    System.out.println("Invalid denominator. Please enter an integer and different zero!");
                    continue;
                }
                break;
            } else {
                System.out.println("Invalid denominator. Please enter an integer!");
                sc.next();
            }
        }
    }

    public Fraction reduce() {
        Fraction reduced = new Fraction();
        int GCD = GCD(this.numerator, this.denominator);
        reduced.numerator = this.numerator / GCD;
        reduced.denominator = this.denominator / GCD;

        if (reduced.denominator < 0) {
            reduced.numerator = -reduced.numerator;
            reduced.denominator = -reduced.denominator;
        }

        return reduced;
    }

    public Fraction sum(Fraction f2) {
        Fraction sum = new Fraction();
        sum.numerator = (this.numerator * f2.denominator) + (f2.numerator * this.denominator);
        sum.denominator = this.denominator * f2.denominator;
        return sum;
    }

    public Fraction sub(Fraction f2) {
        Fraction sub = new Fraction();
        sub.numerator = (this.numerator * f2.denominator) - (f2.numerator * this.denominator);
        sub.denominator = this.denominator * f2.denominator;
        return sub;
    }

    public Fraction mul(Fraction f2) {
        Fraction mul = new Fraction();
        mul.numerator = this.numerator * f2.numerator;
        mul.denominator = this.denominator * f2.denominator;
        return mul;
    }

    public Fraction div(Fraction f2) {
        if (f2.numerator == 0) {
            return null;
        }

        Fraction reversed = new Fraction();
        reversed.numerator = f2.denominator;
        reversed.denominator = f2.numerator;

        return this.mul(reversed);
    }

    public int checkSign() {
        if (this.numerator == 0) {
            return 0;
        }
        return (numerator > 0) == (denominator > 0) ? 1 : -1;
    }

    @Override
    public String toString() {
        Fraction reduced = this.reduce();

        if (reduced.numerator % reduced.denominator == 0) {
            return Integer.toString(reduced.numerator / reduced.denominator);
        }
        return reduced.numerator + "/" + reduced.denominator;
    }
}
