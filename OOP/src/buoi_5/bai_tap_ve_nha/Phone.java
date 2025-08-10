package buoi_5.bai_tap_ve_nha;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Phone implements PhoneConstants, Comparable<Phone> {
    private String id;
    private String name;
    private double price;
    private int warrantyPeriod;
    private OSType operatingSystem;
    private String manufacturer;
    private Status status;

    public Phone() {
    }

    public Phone(String id, String name, double price, int warrantyPeriod, OSType operatingSystem, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
        this.operatingSystem = operatingSystem;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.matches("[a-zA-Z0-9\\s]+")) {
            throw new InputMismatchException(">>Error: Tên không được chứa ký tự đặt biệt!");
        }

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new InputMismatchException(">>Error: Giá phải lớn hơn không!");
        }

        this.price = price;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod <= 0) {
            throw new InputMismatchException(">>Error: Thời gian bảo hành phải lớn hơn không!");
        }

        this.warrantyPeriod = warrantyPeriod;
    }

    public OSType getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OSType operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setManufacturer(String manufacturer) {
        if (!manufacturer.matches("[a-zA-Z]+")) {
            throw new InputMismatchException(">>Error: Hãng SX không được chứa ký tự đặt biệt và chữ số!");
        }

        this.manufacturer = manufacturer;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập tên điện thoại: ");
            try {
                setName(sc.nextLine().trim());
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá: ");
            try {
                setPrice(Double.parseDouble(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Giá phải là một số thực!");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập thời gian bảo hàng (tháng): ");
            try {
                setWarrantyPeriod(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Thời gian bảo hành phải là một số nguyên!");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Chọn hệ điều hành: ");
            try {
                int count = 1;
                for (OSType os : OSType.values()) {
                    System.out.println(count++ + ". " + os.getDisplayName());
                }

                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > OSType.values().length) {
                    System.out.println(">>Error: Lựa chọn không hợp lệ!");
                    continue;
                }

                setOperatingSystem(OSType.values()[choice - 1]);
                break;
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Lựa chọn phải làm số nguyên dương!");
            }
        }

        while (true) {
            System.out.print("Nhập hãng sản xuất: ");
            try {
                setManufacturer(sc.nextLine().trim());
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public int compareTo(Phone phone) {
        return Double.compare(this.price, phone.getPrice());
    }

    @Override
    public String toString() {
        return "Mã SP: " + getId() + "\n"
                + "Tên: " + getName() + "\n"
                + "Giá: " + String.format("%,.2fVND", getPrice()) + "\n"
                + "Thời gian bảo hành: " + getWarrantyPeriod() + "\n"
                + "Hệ điều hành: " + getOperatingSystem().getDisplayName() + "\n"
                + "Nhà sản xuất: " + getManufacturer() + "\n"
                + "Tình trạng: " + getStatus().getDisplayName() + "\n";
    }

    public abstract double totalPrice();
}


