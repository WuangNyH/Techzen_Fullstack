package buoi_7.bai_tap;

public class Task {
    public enum Priority {
        HIGH(1),
        MEDIUM(2),
        LOW(3);

        private final int value;

        Priority(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private String name;
    private Priority priority;

    public Task() {
    }

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority.name() + "}";
    }
}
