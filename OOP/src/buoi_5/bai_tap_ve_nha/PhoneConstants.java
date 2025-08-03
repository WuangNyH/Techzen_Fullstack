package buoi_5.bai_tap_ve_nha;

public interface PhoneConstants {
    enum OSType {
        ANDROID("Android"),
        IOS("iOS"),
        WINDOWS_PHONE("Windows Phone"),
        SYMBIAN("Symbian"),
        BLACKBERRY_OS("BlackBerry OS");

        private final String displayName;

        OSType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    enum Status {
        NEW("Mới"),
        OLD("Cũ");

        private final String displayName;

        Status(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}
