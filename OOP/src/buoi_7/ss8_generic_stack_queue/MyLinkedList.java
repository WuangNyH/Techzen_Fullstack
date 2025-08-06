package buoi_7.ss8_generic_stack_queue;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node<E> head;
    private Node<E> tail;
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

    private Node<E> getNode(int index) {
        Node<E> temp;
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

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
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

    public void addLast(E value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int index, E value) {
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

        Node<E> temp = getNode(index);

        Node<E> newNode = new Node<>(value);
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
            Node<E> oldHead = head;
            head = head.next;
            head.prev = null;
            oldHead.next = null;
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

        Node<E> oldTail = tail;
        tail = tail.prev;
        tail.next = null;

        oldTail.prev = null;
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

        Node<E> temp = getNode(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        size--;
    }

    public E getFirst() {
        checkEmpty();
        return head.value;
    }

    public E getLast() {
        checkEmpty();
        return tail.value;
    }

    public E get(int index) {
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

    public void set(int index, E value) {
        checkEmpty();
        checkIndex(index);

        Node<E> node = getNode(index);
        node.value = value;
    }

    public int indexOf(E element) {
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

    public int lastIndexOf(E element) {
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
