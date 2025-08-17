package buoi_10.bai_tap;

import buoi_10.bai_tap.models.Phone;

import java.util.HashMap;

import static buoi_10.bai_tap.manager.AddPhone.addPhone;
import static buoi_10.bai_tap.manager.DeletePhone.deletePhoneById;
import static buoi_10.bai_tap.manager.ShowListPhone.showListPhone;
import static buoi_10.bai_tap.manager.SortPhone.sortPhones;
import static buoi_10.bai_tap.manager.UpdatePhone.updatePhoneById;
import static buoi_10.bai_tap.menu.MainMenu.mainMenu;
import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;
import static buoi_10.bai_tap.utils.PhoneFileHelper.readFile;

public class Main {
    public static final HashMap<String, Phone> phones = readFile();

    public static void main(String[] args) {
        while (true) {
            try {
                mainMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> showListPhone(phones);
                    case 2 -> addPhone(phones);
                    case 3 -> updatePhoneById(phones);
                    case 4 -> deletePhoneById(phones);
                    case 5 -> sortPhones(phones);
//                    case 6 -> ;
//                    case 7 -> ;
//                    case 8 -> ;
                    case 9 -> {
                        return;
                    }
                    default -> System.out.println(makeWarningMessage(">>> Error: Lựa chọn không hợp lệ!"));
                }
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số nguyên dương!"));
            }
        }
    }
}
