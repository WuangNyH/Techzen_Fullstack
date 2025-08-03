package buoi_5.bai_tap_ve_nha.Main;

import buoi_5.bai_tap_ve_nha.NewPhone;
import buoi_5.bai_tap_ve_nha.OldPhone;
import buoi_5.bai_tap_ve_nha.Phone;
import buoi_5.bai_tap_ve_nha.PhoneConstants;

import java.util.InputMismatchException;

import static buoi_5.bai_tap_ve_nha.Main.Main.sc;

public class UpdatePhone {
    public static void menuUpdatePhone() {
        System.out.println(">> MENU CẬP NHẬT ĐIỆN THOẠI <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Tên");
        System.out.printf("| 2. %-40s |\n", "Giá bán");
        System.out.printf("| 3. %-40s |\n", "Thời gian bảo hành");
        System.out.printf("| 4. %-40s |\n", "Hệ điều hành");
        System.out.printf("| 5. %-40s |\n", "Hãng sản xuất");
    }

    public static void menuUpdateNewPhone() {
        menuUpdatePhone();
        System.out.printf("| 6. %-40s |\n", "Số lượng");
        System.out.printf("| 7. %-40s |\n", "Quay lại menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void menuUpdateOldPhone() {
        menuUpdatePhone();
        System.out.printf("| 6. %-40s |\n", "Tình trạng pin");
        System.out.printf("| 7. %-40s |\n", "Quay lại menu chính");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void updatePhone(int choice, Phone phone) {
        switch (choice) {
            case 1:
                while (true) {
                    System.out.print("Nhập tên mới: ");
                    try {
                        phone.setName(sc.nextLine().trim());
                        System.out.println("Cập nhật tên thành công!\n");
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 2:
                while (true) {
                    System.out.print("Nhập giá mới: ");
                    try {
                        phone.setPrice(Double.parseDouble(sc.nextLine()));
                        System.out.println("Cập nhật giá thành công!\n");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(">>Error: Giá phải là một số thực!");
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 3:
                while (true) {
                    System.out.print("Nhập thời gian bảo hàng (tháng) mới: ");
                    try {
                        phone.setWarrantyPeriod(Integer.parseInt(sc.nextLine()));
                        System.out.println("Cập nhật thời gian bảo hành thành công!\n");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(">>Error: Thời gian bảo hành phải là một số nguyên!");
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            case 4:
                while (true) {
                    System.out.println("Chọn hệ điều hành mới: ");
                    try {
                        int count = 1;
                        for (PhoneConstants.OSType os : PhoneConstants.OSType.values()) {
                            System.out.println(count++ + ". " + os.getDisplayName());
                        }

                        System.out.print("Lựa chọn của bạn: ");
                        int choiceOS = Integer.parseInt(sc.nextLine());

                        if (choiceOS < 1 || choiceOS > PhoneConstants.OSType.values().length) {
                            System.out.println(">>Error: Lựa chọn không hợp lệ!");
                            continue;
                        }

                        phone.setOperatingSystem(PhoneConstants.OSType.values()[choiceOS - 1]);
                        System.out.println("Cập nhật hệ điều hành thành công!\n");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(">>Error: Lựa chọn phải làm số nguyên dương!");
                    }
                }
                break;
            case 5:
                while (true) {
                    System.out.print("Nhập hãng sản xuất mới: ");
                    try {
                        phone.setManufacturer(sc.nextLine().trim());
                        System.out.println("Cập nhật hãng SX thành công!\n");
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
        }
    }

    public static void updateNewPhone(Phone phone) {
        NewPhone newPhone = (NewPhone) phone;
        while (true) {
            try {
                menuUpdateNewPhone();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1, 2, 3, 4, 5:
                        updatePhone(choice, newPhone);
                        break;
                    case 6:
                        while (true) {
                            System.out.print("Nhập số lượng mới: ");
                            try {
                                newPhone.setQuantity(Integer.parseInt(sc.nextLine()));
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.out.println(">> Error: Số lượng phải là một số nguyên!");
                            }
                        }
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static void updateOldPhone(Phone phone) {
        OldPhone oldPhone = (OldPhone) phone;
        while (true) {
            try {
                menuUpdateOldPhone();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1, 2, 3, 4, 5:
                        updatePhone(choice, oldPhone);
                        break;
                    case 6:
                        while (true) {
                            System.out.print("Nhập tình trạng pin mới: ");
                            try {
                                oldPhone.setStatusBattery(Integer.parseInt(sc.nextLine()));
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.out.println(">> Error: Tình trạng pin phải là một số nguyên!");
                            }
                        }
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println(">>Error: Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>Error: Vui lòng nhập số nguyên dương!");
            }
        }
    }
}
