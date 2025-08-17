package buoi_10.bai_tap.manager;

import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.NewPhone;
import buoi_10.bai_tap.models.OldPhone;
import buoi_10.bai_tap.models.Phone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static buoi_10.bai_tap.menu.ShowPhoneMenu.showPhoneMenu;
import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.*;

public class ShowListPhone {
    public static void showListPhone(HashMap<String, Phone> phones) {
        while (true) {
            try {
                showPhoneMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> displayListPhone(phones.values());
                    case 2 -> displayListPhone(getListPhone(NewPhone.class, phones));
                    case 3 -> displayListPhone(getListPhone(OldPhone.class, phones));
                    case 4 -> {
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

    public static void displayListPhone(Collection<? extends Phone> phones) throws NullOrEmptyException {
        if (phones == null || phones.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Danh sách rỗng!");
        }

        int counter = 1;
        for (Phone phone : phones) {
            System.out.println(makeInfoMessage("Thông tin điện thoại thứ: " + counter++));
            System.out.println(phone);
        }
        System.out.printf(makeSuccessMessage("Tìm được %d sản phẩm!\n"), counter - 1);
    }

    public static <T extends Phone> ArrayList<T> getListPhone(Class<T> type, HashMap<String, Phone> phones) {
        ArrayList<T> listPhone = new ArrayList<>();
        for (Phone phone : phones.values()) {
            if (type.isInstance(phone)) {
                listPhone.add(type.cast(phone));
            }
        }
        return listPhone;
    }
}
