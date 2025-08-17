package buoi_10.bai_tap.manager;

import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.Phone;

import java.util.HashMap;

public class GetPhone {
    public static Phone getPhoneById(String id, HashMap<String, Phone> phones) throws NullOrEmptyException {
        if (phones.isEmpty()) {
            throw new NullOrEmptyException(">>> Error: Hiện tại chưa có điện thoại nào!");
        }

        return phones.get(id);
    }
}
