package buoi_5.bai_tap_ve_nha;

import buoi_5.bai_tap_ve_nha.exceptions.InvalidPositiveNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;
    private static int autoId = 0;

    public NewPhone() {
        super.setStatus(Status.NEW);
    }

    public NewPhone(String id, String name, double price, int warrantyPeriod, OSType operatingSystem, String manufacturer, int quantity) {
        super(id, name, price, warrantyPeriod, operatingSystem, manufacturer);
        this.quantity = quantity;
        super.setStatus(Status.NEW);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws InvalidPositiveNumberException {
        if (quantity <= 0) {
            throw new InvalidPositiveNumberException(">> Error: Số lượng phải lớn hơn không!");
        }

        this.quantity = quantity;
    }

    @Override
    public void setId(String id) {
        super.setId("DTM" + id);
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập số lượng: ");
            try {
                setQuantity(Integer.parseInt(sc.nextLine()));
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (InvalidPositiveNumberException e) {
                System.out.println(">> Error: Số lượng phải là một số nguyên!");
            }
        }

        setId(String.format("%03d", autoId++));
    }

    @Override
    public String toString() {
        return super.toString() + "Số lượng: " + getQuantity() + "\n";
    }

    @Override
    public double totalPrice() {
        return this.quantity * this.getPrice();
    }
}
