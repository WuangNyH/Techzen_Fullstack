package buoi_10.bai_tap.constants;

public enum Status {
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
