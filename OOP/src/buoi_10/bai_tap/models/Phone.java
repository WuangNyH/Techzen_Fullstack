package buoi_10.bai_tap.models;

import buoi_10.bai_tap.constants.OSType;
import buoi_10.bai_tap.constants.Status;
import buoi_10.bai_tap.exceptions.InvalidPositiveNumberException;
import buoi_10.bai_tap.exceptions.InvalidStringException;
import buoi_10.bai_tap.exceptions.NullOrEmptyException;

import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;

public abstract class Phone implements Comparable<Phone> {
    private String id;
    private String name;
    private double price;
    private int warrantyPeriod;
    private OSType OS;
    private String manufacturer;
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) throws NullOrEmptyException {
        if (id == null || id.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Id không được rỗng!");
        }

        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws NullOrEmptyException, InvalidStringException {
        if (name.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Tên sản phẩm không được để trống!");
        }

        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            throw new InvalidStringException(">>> Error: Tên sản phẩm không được chứa ký tự đặt biệt!");
        }

        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) throws InvalidPositiveNumberException {
        if (price <= 0) {
            throw new InvalidPositiveNumberException(">>> Error: Giá sản phẩm phải lớn hơn 0!");
        }

        this.price = price;
    }

    public int getWarrantyPeriod() {
        return this.warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) throws InvalidPositiveNumberException {
        if (warrantyPeriod <= 0) {
            throw new InvalidPositiveNumberException(">>> Error: Thời gian bảo hành phải lớn hơn 0!");
        }

        this.warrantyPeriod = warrantyPeriod;
    }

    public String getOS() {
        return this.OS.getDisplayName();
    }

    public void setOS(OSType OS) throws NullOrEmptyException {
        if (OS == null) {
            throw new NullOrEmptyException(">>> Error: Hệ điều hành không được để trống!");
        }

        this.OS = OS;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) throws InvalidStringException, NullOrEmptyException {
        if (manufacturer.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Hãng sản xuất không được để trống!");
        }

        if (!manufacturer.matches("[a-zA-Z0-9\\s]+")) {
            throw new InvalidStringException(">>> Error: Hãng sản xuất không được chứa ký tự đặt biệt!");
        }

        this.manufacturer = manufacturer;
    }

    public String getStatus() {
        return status.getDisplayName();
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    public void input() {
        while (true) {
            try {
                System.out.print("Nhập tên điện thoại: ");
                setName(sc.nextLine().trim());
                break;
            } catch (NullOrEmptyException | InvalidStringException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            }
        }

        while (true) {
            try {
                System.out.print("Nhập giá bán: ");
                setPrice(Double.parseDouble(sc.nextLine()));
                break;
            } catch (InvalidPositiveNumberException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số thực!"));
            }
        }

        while (true) {
            try {
                System.out.print("Nhập thời gian bảo hành: ");
                setWarrantyPeriod(Integer.parseInt(sc.nextLine()));
                break;
            } catch (InvalidPositiveNumberException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số nguyên!"));
            }
        }

        while (true) {
            try {
                System.out.println("Chọn hệ điều hành:");
                for (int i = 0; i < OSType.values().length; i++) {
                    System.out.println((i + 1) + ". " + OSType.values()[i].getDisplayName());
                }

                System.out.print("Lựa chọn OS: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > OSType.values().length) {
                    System.out.println(makeWarningMessage(">>> Error: Lựa chọn không hợp lệ!"));
                    continue;
                }
                setOS(OSType.values()[choice - 1]);
                break;
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Lựa chọn phải là số nguyên dương!"));
            } catch (NullOrEmptyException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            }
        }

        while (true) {
            try {
                System.out.print("Nhập hãng sản xuất: ");
                setManufacturer(sc.nextLine().trim());
                break;
            } catch (NullOrEmptyException | InvalidStringException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            }
        }
    }

    @Override
    public String toString() {
        return "Mã SP: " + getId() + "\n"
                + "Tên: " + getName() + "\n"
                + "Giá: " + String.format("%,.2fVND", getPrice()) + "\n"
                + "Thời gian bảo hành: " + getWarrantyPeriod() + "\n"
                + "Hệ điều hành: " + getOS() + "\n"
                + "Nhà sản xuất: " + getManufacturer() + "\n"
                + "Tình trạng: " + getStatus() + "\n";
    }

    public String toCSV() {
        return String.join(",",
                this.id,
                this.name,
                String.valueOf(this.price),
                String.valueOf(this.warrantyPeriod),
                this.OS.name(),
                this.manufacturer,
                this.status.name());
    }

    @Override
    public int compareTo(Phone phone) {
        return Double.compare(this.price, phone.price);
    }
}
