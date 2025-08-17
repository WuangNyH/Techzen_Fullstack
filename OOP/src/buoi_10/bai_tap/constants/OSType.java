package buoi_10.bai_tap.constants;

public enum OSType {
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
