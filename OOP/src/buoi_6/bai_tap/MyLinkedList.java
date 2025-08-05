package buoi_6.bai_tap;

public class MyLinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }
    }

    private void checkNull() {
        if (head == null) {
            throw new NullPointerException("Lỗi: Hiện tại mảng đang rỗng!");
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public boolean add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        if (index == size) {
            addLast(value);
            return false;
        }

        if (index == 0) {
            addFirst(value);
            return false;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return false;
    }

    public void removeFirst() {
        checkNull();

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void removeLast() {
        checkNull();

        if (size == 1) {
            head = null;
            tail = null;
        }

        Node temp = head;
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void remove(int index) {
        checkNull();
        checkIndex(index);

        if (index == size - 1) {
            removeLast();
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public int getFirst() {
        checkNull();
        return head.value;
    }

    public int getLast() {
        checkNull();
        return tail.value;
    }

    public int get(int index) {
        checkNull();
        checkIndex(index);

        if (index == 0) {
            return head.value;
        }

        if (index == size) {
            return tail.value;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    public void set(int index, int value) {
        checkNull();
        checkIndex(index);

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.value = value;
    }

    public int indexOf(int element) {
        int idx = -1;
        if (head == null) {
            return idx;
        }

        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                idx = i;
                break;
            } else {
                temp = temp.next;
            }
        }
        return idx;
    }

    public int lastIndexOf(int element) {
        int idx = -1;
        if (head == null) {
            return idx;
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                idx = i;
            }
            temp = temp.next;
        }
        return idx;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append(", ");
            temp = temp.next;
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]");
        } else {
            stringBuilder.append("]");
        }

        return stringBuilder.toString();
    }
}
