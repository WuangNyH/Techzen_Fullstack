package buoi_1.chieu;

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
            sc.nextLine();
            if (!sc.hasNextInt()) {
                System.out.println("Invalid numerator. Please try again. (Integer)!");
                continue;
            }

            this.numerator = sc.nextInt();
            break;
        }

        while (true) {
            System.out.print("Enter denominator: ");
            sc.nextLine();
            if (!sc.hasNextInt()) {
                System.out.println("Invalid denominator. Please try again. (Integer and different zero)!");
                continue;
            }

            this.denominator = sc.nextInt();
            if (this.denominator == 0) {
                System.out.println("Invalid denominator. Please try again. (Integer and different zero)!");
                continue;
            }
            break;
        }
    }

    public Fraction reduce() {
        Fraction reduced = new Fraction();
        int GCD = GCD(this.numerator, this.denominator);
        reduced.numerator = this.numerator / GCD;
        reduced.denominator = this.denominator / GCD;
        return reduced;
    }

    public void output() {
        Fraction reduced = this.reduce();

        if (reduced.numerator == this.numerator && reduced.denominator == this.denominator) {
            System.out.println("Fraction is simplify!");
            return;
        }

        if (reduced.numerator % reduced.denominator == 0) {
            System.out.printf("%d/%d = %d\n", this.numerator, this.denominator, reduced.numerator / reduced.denominator);
        } else {
            System.out.printf("%d/%d = %d/%d\n", this.numerator, this.denominator, reduced.numerator, reduced.denominator);
        }
    }

    public Fraction sum(Fraction f2) {
        Fraction sum = new Fraction();
        if (this.denominator == f2.denominator) {
            sum.numerator = this.numerator + f2.numerator;
            sum.denominator = this.denominator;
        } else {
            sum.numerator = (this.numerator * f2.denominator) + (f2.numerator * this.denominator);
            sum.denominator = this.denominator * f2.denominator;
        }
        return sum;
    }

    public Fraction sub(Fraction f2) {
        Fraction sub = new Fraction();
        if (this.denominator == f2.denominator) {
            sub.numerator = this.numerator - f2.numerator;
            sub.denominator = this.denominator;
        } else {
            sub.numerator = (this.numerator * f2.denominator) - (f2.numerator * this.denominator);
            sub.denominator = this.denominator * f2.denominator;
        }
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
