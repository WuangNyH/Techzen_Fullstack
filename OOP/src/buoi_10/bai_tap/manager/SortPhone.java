package buoi_10.bai_tap.manager;

import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static buoi_10.bai_tap.manager.ShowListPhone.displayListPhone;
import static buoi_10.bai_tap.menu.SortMenu.sortMenu;
import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeErrorMessage;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;

public class SortPhone {
    public static void sortPhones(HashMap<String, Phone> phones) {
        while (true) {
            try {
                sortMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> sortByCollections(phones, true);
                    case 2 -> sortByCollections(phones, false);
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println(makeWarningMessage(">>> Error: Lựa chọn không hợp lệ!"));
                }
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số nguyên dương!"));
            } catch (NullOrEmptyException e) {
                System.out.println(makeErrorMessage(e.getMessage()));
            }
        }
    }

    public static void sortByCollections(HashMap<String, Phone> phones, boolean ascending) throws NullOrEmptyException {
        if (phones == null || phones.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Hiện tại chưa có điện thoại nào!");
        }

        ArrayList<Phone> sortedPhones = new ArrayList<>(phones.values());

        if (ascending) {
            Collections.sort(sortedPhones);
        } else {
            sortedPhones.sort(Collections.reverseOrder());
        }

        displayListPhone(sortedPhones);
    }
}
