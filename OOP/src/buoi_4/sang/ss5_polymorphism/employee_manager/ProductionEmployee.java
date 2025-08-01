package buoi_4.sang.ss5_polymorphism.employee_manager;

import java.util.Scanner;

public class ProductionEmployee extends Employee {
    private double numberProducts;

    public ProductionEmployee() {
    }

    public ProductionEmployee(String id, String fullName, String dayOfBirth, String address, double numberProducts) {
        super(id, fullName, dayOfBirth, address);
        this.numberProducts = numberProducts;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();

        System.out.print("Nhập vào số sản phẩm: ");
        this.numberProducts = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Số sản phẩm: " + this.numberProducts);
    }

    @Override
    public double getSalary() {
        return numberProducts * 100;
    }

    @Override
    public void setId(int id) {
        this.setId(String.format("SX%03d", id));
    }

    public double getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(double numberProducts) {
        this.numberProducts = numberProducts;
    }
}
