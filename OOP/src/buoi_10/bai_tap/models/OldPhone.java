package buoi_10.bai_tap.models;

import buoi_10.bai_tap.constants.Status;
import buoi_10.bai_tap.exceptions.BatteryStatusException;
import buoi_10.bai_tap.exceptions.InvalidPositiveNumberException;

import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;

public class OldPhone extends Phone {
    private int batteryStatus;

    public OldPhone() {
        this.setStatus(Status.OLD);
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) throws BatteryStatusException {
        if (batteryStatus < 1 || batteryStatus > 100) {
            throw new BatteryStatusException(">>> Error: Tình trạng pin phải từ 1 đến 100!");
        }

        this.batteryStatus = batteryStatus;
    }

    @Override
    public void input() {
        super.input();

        while (true) {
            try {
                System.out.print("Nhập tình trạng pin: ");
                setBatteryStatus(Integer.parseInt(sc.nextLine()));
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
        return super.toString() + "Tình trạng pin: " + this.batteryStatus + "%" + "\n";
    }

    @Override
    public String toCSV() {
        return String.join(",", super.toCSV(), "", String.valueOf(this.batteryStatus));
    }
}
