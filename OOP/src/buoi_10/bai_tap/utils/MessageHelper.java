package buoi_10.bai_tap.utils;

public class MessageHelper {
    public static String makeErrorMessage(String message) {
        return "\u001B[31m" + message + "\u001B[0m";
    }

    public static String makeWarningMessage(String message) {
        return "\u001B[33m" + message + "\u001B[0m";
    }

    public static String makeInfoMessage(String message) {
        return "\u001B[36m" + message + "\u001B[0m";
    }

    public static String makeSuccessMessage(String message) {
        return "\u001B[32m" + message + "\u001B[0m";
    }
}
