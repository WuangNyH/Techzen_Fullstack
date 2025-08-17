package buoi_10.bai_tap.utils;

import buoi_10.bai_tap.constants.OSType;
import buoi_10.bai_tap.exceptions.InvalidPositiveNumberException;
import buoi_10.bai_tap.exceptions.InvalidStringException;
import buoi_10.bai_tap.exceptions.NullOrEmptyException;
import buoi_10.bai_tap.models.NewPhone;
import buoi_10.bai_tap.models.OldPhone;
import buoi_10.bai_tap.models.Phone;

import java.io.*;
import java.util.HashMap;

import static buoi_10.bai_tap.utils.MessageHelper.makeErrorMessage;
import static buoi_10.bai_tap.utils.MessageHelper.makeWarningMessage;

public class PhoneFileHelper {
    public static final String PATH_PHONE_FILE = "src/buoi_10/bai_tap/data/phones.csv";

    public static HashMap<String, Phone> readFile() {
        File file = new File(PATH_PHONE_FILE);
        HashMap<String, Phone> phones = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();

            Phone phone;
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                phone = fromCSV(line);
                phones.put(phone.getId(), phone);
            }
        } catch (IOException e) {
            return phones;
        } catch (NullOrEmptyException | InvalidPositiveNumberException | InvalidStringException e) {
            System.out.println(makeWarningMessage(e.getMessage()));
        }

        return phones;
    }

    public static Phone fromCSV(String line) throws NullOrEmptyException, InvalidStringException, InvalidPositiveNumberException {
        String[] data = line.split(",");

        if (!data[7].trim().isEmpty()) {
            NewPhone phone = new NewPhone();
            phone.setId(data[0]);
            phone.setName(data[1]);
            phone.setPrice(Double.parseDouble(data[2]));
            phone.setWarrantyPeriod(Integer.parseInt(data[3]));
            phone.setOS(OSType.valueOf(data[4]));
            phone.setManufacturer(data[5]);
            phone.setQuantity(Integer.parseInt(data[7]));
            return phone;
        } else {
            OldPhone phone = new OldPhone();
            phone.setId(data[0]);
            phone.setName(data[1]);
            phone.setPrice(Double.parseDouble(data[2]));
            phone.setWarrantyPeriod(Integer.parseInt(data[3]));
            phone.setOS(OSType.valueOf(data[4]));
            phone.setManufacturer(data[5]);
            phone.setBatteryStatus(Integer.parseInt(data[8]));
            return phone;
        }
    }

    public static void writeFile(HashMap<String, Phone> phones) {
        StringBuilder stringBuilder = new StringBuilder(String.join(",",
                "ID",
                "Tên điện thoại",
                "Giá bán",
                "Thời gian bảo hành",
                "Hệ điều hành",
                "Hãng sản xuất",
                "Tình trạng",
                "Số lượng",
                "Tình trạng pin"
        ));
        for (Phone phone : phones.values()) {
            stringBuilder.append("\n").append(phone.toCSV());
        }

        File file = new File(PATH_PHONE_FILE);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println(makeErrorMessage(">>> Error: Lỗi khi ghi file"));
        }
    }
}
