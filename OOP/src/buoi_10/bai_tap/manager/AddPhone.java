package buoi_10.bai_tap.manager;

import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.NewPhone;
import buoi_10.bai_tap.models.OldPhone;
import buoi_10.bai_tap.models.Phone;

import java.util.HashMap;

import static buoi_10.bai_tap.menu.AddMenu.addMenu;
import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.makeSuccessMessage;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;
import static buoi_10.bai_tap.utils.PhoneFileHelper.writeFile;

public class AddPhone {
    public static void addPhone(HashMap<String, Phone> phones) {
        while (true) {
            try {
                addMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        NewPhone newPhone = new NewPhone();
                        addNewPhone(newPhone, phones);
                    }
                    case 2 -> {
                        OldPhone oldPhone = new OldPhone();
                        addNewPhone(oldPhone, phones);
                    }
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println(makeWarningMessage(">>> Error: Lựa chọn không hợp lệ!"));
                }
            } catch (NumberFormatException e) {
                System.out.println(makeWarningMessage(">>> Error: Vui lòng nhập số nguyên dương!"));
            }
        }
    }

    public static String getRandomIdentify() {
        int number = (int) (Math.random() * 1000);
        return String.format("%03d", number);
    }

    public static void addNewPhone(Phone phone, HashMap<String, Phone> phones) {
        do {
            try {
                if (phone instanceof NewPhone) {
                    phone.setId("DTM" + getRandomIdentify());
                } else if (phone instanceof OldPhone) {
                    phone.setId("DTC" + getRandomIdentify());
                }
            } catch (NullOrEmptyException e) {
                System.out.println(makeWarningMessage(e.getMessage()));
            }
        } while (phones.containsKey(phone.getId()));
        phone.input();
        phones.put(phone.getId(), phone);
        writeFile(phones);
        System.out.println(makeSuccessMessage("Thêm điện thoại thành công!"));
    }
}
