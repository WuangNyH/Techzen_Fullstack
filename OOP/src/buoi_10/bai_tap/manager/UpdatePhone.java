package buoi_10.bai_tap.manager;

import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.Phone;

import java.util.HashMap;

import static buoi_10.bai_tap.manager.GetPhone.getPhoneById;
import static buoi_10.bai_tap.utils.InputHelper.sc;
import static buoi_10.bai_tap.utils.MessageHelper.*;
import static buoi_10.bai_tap.utils.PhoneFileHelper.writeFile;

public class UpdatePhone {
    public static void updatePhoneById(HashMap<String, Phone> phones) {
        try {
            System.out.print("Nhập id cần cập nhật: ");
            String id = sc.nextLine().trim();

            Phone phone = getPhoneById(id, phones);

            if (phone == null) {
                System.out.println(makeWarningMessage(">>> Error: ID không hợp lệ!"));
                return;
            }

            phone.input();
            writeFile(phones);
            System.out.println(makeSuccessMessage("Cập nhật thành công!"));
        } catch (NullOrEmptyException e) {
            System.out.println(makeErrorMessage(e.getMessage()));
        }
    }
}
