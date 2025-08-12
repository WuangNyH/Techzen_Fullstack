package buoi_5.bai_tap_ve_nha;

import buoi_5.bai_tap_ve_nha.exceptions.InvalidPositiveNumberException;
import buoi_5.bai_tap_ve_nha.exceptions.InvalidStatusBatteryException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OldPhone extends Phone implements Promotion {
    private int statusBattery;
    private static int autoId = 0;

    public OldPhone() {
        super.setStatus(Status.OLD);
    }

    public OldPhone(String id, String name, double price, int warrantyPeriod, OSType operatingSystem, String manufacturer, int statusBattery) {
        super(id, name, price, warrantyPeriod, operatingSystem, manufacturer);
        this.statusBattery = statusBattery;
        super.setStatus(Status.OLD);
    }

    public int getStatusBattery() {
        return statusBattery;
    }

    public void setStatusBattery(int statusBattery) throws InvalidStatusBatteryException {
        if (statusBattery < 0 || statusBattery > 100) {
            throw new InvalidStatusBatteryException(">> Error: Tình trạng pin phải từ 0-100!");
        }

        this.statusBattery = statusBattery;
    }

    @Override
    public void setId(String id) {
        super.setId("DTC" + id);
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tình trạng pin: ");
            try {
                setStatusBattery(Integer.parseInt(sc.nextLine()));
                break;
            } catch (InvalidStatusBatteryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(">> Error: Tình trạng pin phải là một số nguyên!");
            }
        }

        setId(String.format("%03d", autoId++));
    }

    @Override
    public String toString() {
        return super.toString() + "Tình trạng pin: " + this.getStatusBattery() + "%\n";
    }

    @Override
    public double totalPrice() {
        return (double) this.statusBattery / 100 * this.getPrice();
    }

    @Override
    public void promotion(int ratePromote) throws InvalidPositiveNumberException {
        this.setPrice(this.getPrice() * (1 - (double) ratePromote / 100));
    }
}
