package buoi_10.bai_tap.models;

import buoi_10.bai_tap.constants.Status;
import buoi_10.bai_tap.exceptions.InvalidPositiveNumberException;

import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
        this.setStatus(Status.NEW);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws InvalidPositiveNumberException {
        if (quantity <= 0) {
            throw new InvalidPositiveNumberException(">>> Error: Số lượng phải lớn hơn 0!");
        }

        this.quantity = quantity;
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập số lượng: ");
                setQuantity(Integer.parseInt(sc.nextLine()));
                break;
            } catch (InvalidPositiveNumberException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số nguyên dương!"));
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Số lượng: " + getQuantity() + "\n";
    }

    @Override
    public String toCSV() {
        return String.join(",", super.toCSV(), String.valueOf(this.quantity), "");
    }
}
