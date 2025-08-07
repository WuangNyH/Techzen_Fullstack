package buoi_7.bai_tap;

import buoi_7.bai_tap.Task;
import buoi_7.bai_tap.TaskManager;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static TaskManager<Task> taskManager = new TaskManager<>();
    static Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println(">> LỰA CHỌN DANH SÁCH <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Danh sách task trong stacks");
        System.out.printf("| 2. %-40s |\n", "Danh sách task trong queue");
        System.out.printf("| 3. %-40s |\n", "Thoát chương trình");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void menuStack() {
        System.out.println(">> LỰA CHỌN CHỨC NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Thêm công việc");
        System.out.printf("| 2. %-40s |\n", "Xem công việc công việc mới nhất");
        System.out.printf("| 3. %-40s |\n", "Xóa công việc mới nhất");
        System.out.printf("| 4. %-40s |\n", "Hoàn tác công việc đã xóa gần nhất");
        System.out.printf("| 5. %-40s |\n", "Thoát chương trình");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void processStack() {
        while (true) {
            try {
                menuStack();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addTask(true);
                    case 2 -> getTask(true);
                    case 3 -> removeTask(true);
                    case 4 -> redoTask();
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static void menuQueue() {
        System.out.println(">> LỰA CHỌN CHỨC NĂNG <<");
        System.out.println("++ ----------------------------------------- ++");
        System.out.printf("| 1. %-40s |\n", "Thêm công việc");
        System.out.printf("| 2. %-40s |\n", "Xem công việc công việc đầu tiên");
        System.out.printf("| 3. %-40s |\n", "Xóa công việc đầu tiền");
        System.out.printf("| 4. %-40s |\n", "Xem công việc có độ ưu tiên cao nhất");
        System.out.printf("| 5. %-40s |\n", "Thoát chương trình");
        System.out.println("++ ----------------------------------------- ++");
    }

    public static void processQueue() {
        while (true) {
            try {
                menuQueue();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addTask(false);
                    case 2 -> getTask(false);
                    case 3 -> removeTask(false);
                    case 4 -> {
                        try {
                            System.out.println(highestPriority());
                        } catch (NullPointerException e) {
                            System.out.println("Hiện tại danh sách rỗng!");
                        }
                    }
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                mainMenu();
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> processStack();
                    case 2 -> processQueue();
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương!");
            }
        }
    }

    public static Task createTask() {
        String name;
        Task.Priority priority;

        while (true) {
            System.out.print("Nhập tên công việc: ");
            name = sc.nextLine().trim();

            if (!name.matches("[a-zA-ZÀ-Ỹà-ỹ0-9\\s]+")) {
                System.out.println("Tên không hợp lệ! Không được chứa ký tự đặt biệt.");
                continue;
            }
            break;
        }

        while (true) {
            try {
                System.out.println(">> LỰA CHỌN ĐỘ ƯU TIÊN <<");
                System.out.println("++ ----------------------------------------- ++");
                for (Task.Priority p : Task.Priority.values()) {
                    System.out.printf("| %d. %-40s |\n", p.getValue(), p.name());
                }
                System.out.println("++ ----------------------------------------- ++");

                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < 1 || choice > Task.Priority.values().length) {
                    System.out.println("Lựa chọn không hợp lệ");
                    continue;
                }

                priority = Task.Priority.values()[choice - 1];
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương!");
            }
        }

        return new Task(name, priority);
    }

    public static void addTask(boolean stack) {
        Task task = createTask();
        if (stack) {
            taskManager.pushToStack(task);
        } else {
            taskManager.addToQueue(task);
        }
    }

    public static void getTask(boolean stack) {
        if (stack) {
            try {
                Task task = taskManager.peekFromStack();
                System.out.println("Công việc thêm vào gần nhất");
                System.out.println(task);
            } catch (EmptyStackException e) {
                System.out.println("Hiện tại danh sách công việc rỗng!");
            }
        } else {
            Task task = taskManager.peekFromQueue();
            if (task == null) {
                System.out.println("Hiện tại danh sách công việc rỗng!");
                return;
            }
            System.out.println("Công việc thêm vào đầu tiên!");
            System.out.println(task);
        }
    }

    public static void removeTask(boolean stack) {
        Task task = null;
        if (stack) {
            try {
                task = taskManager.popFromStack();
            } catch (EmptyStackException e) {
                System.out.println("Hiện tại danh sách công việc rỗng!");
            }
        } else {
            task = taskManager.popFromQueue();
            if (task == null) {
                System.out.println("Hiện tại danh sách công việc rỗng!");
                return;
            }
        }
        System.out.println("Đã xóa thành công công việc!");
        System.out.println(task);
    }

    public static void redoTask() {
        try {
            taskManager.redoElementStack();
        } catch (EmptyStackException e) {
            System.out.println("Hiện tại không có công việc để redo!");
        }
    }


    public static Task highestPriority() {
        int priority = taskManager.peekFromQueue().getPriority().getValue();
        Task task = taskManager.peekFromQueue();

        for (Task element : taskManager.getQueue()) {
            if (element.getPriority().getValue() < priority) {
                task = element;
                priority = task.getPriority().getValue();
            }
        }

        return task;
    }
}
