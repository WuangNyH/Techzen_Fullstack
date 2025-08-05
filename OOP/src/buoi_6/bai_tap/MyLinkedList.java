package buoi_6.bai_tap;

public class MyLinkedList {
    private static class Node {
        private int value;
        private Node next;
        private Node prev;

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

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Lỗi: Hiện tại mảng đang rỗng!");
        }
    }

    private float getMiddle() {
        return (float) size / 2;
    }

    private Node getNode(int index) {
        Node temp;
        if (index < getMiddle()) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
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
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        if (index == size) {
            addLast(value);
            return;
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node temp = getNode(index);

        Node newNode = new Node(value);
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
    }

    public void removeFirst() {
        checkEmpty();

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        checkEmpty();

        if (size == 1) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        size--;
    }

    public void remove(int index) {
        checkEmpty();
        checkIndex(index);

        if (index == size - 1) {
            removeLast();
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node temp = getNode(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    public int getFirst() {
        checkEmpty();
        return head.value;
    }

    public int getLast() {
        checkEmpty();
        return tail.value;
    }

    public int get(int index) {
        checkEmpty();
        checkIndex(index);

        if (index == 0) {
            return head.value;
        }

        if (index == size) {
            return tail.value;
        }

        return getNode(index).value;
    }

    public void set(int index, int value) {
        checkEmpty();
        checkIndex(index);

        Node node = getNode(index);
        node.value = value;
    }

    public int indexOf(int element) {
        if (isEmpty()) {
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                return i;
            }
            temp = temp.next;
        }

        return -1;
    }

    public int lastIndexOf(int element) {
        if (head == null) {
            return -1;
        }
        Node temp = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (temp.value == element) {
                return i;
            }
            temp = temp.prev;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node temp = head;

        while (temp != null) {
            stringBuilder.append(temp.value);
            if (temp.next != null) {
                stringBuilder.append(", ");
            }
            temp = temp.next;
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
