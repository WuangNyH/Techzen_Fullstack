package buoi_6.bai_tap;

import buoi_6.sang.ss7_list.MyLinkedList;

import java.util.LinkedList;

public class MyArrayList {
    private int size;
    private int capacity;
    private int[] arr;

    public void add(int element) {
        if (arr == null) {
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }

        if (this.size == this.capacity) {
            this.capacity *= 1.5;
            if (this.capacity == this.size) {
                this.capacity++;
            }

            int[] newArr = new int[this.capacity];

            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            newArr[size] = element;
            arr = newArr;
        }

        arr[size] = element;
        size++;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        if (index == this.size || arr == null) {
            add(element);
            return;
        }

        if (this.size == capacity) {
            this.capacity *= 1.5;
        }

        int[] newArr = new int[this.capacity];
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                newArr[idx++] = element;
            }
            newArr[idx++] = arr[i];
        }

        arr = newArr;
        size++;
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size || arr == null) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        for (int i = 0; i < size; i++) {
            if (i == index) {
                arr[i] = element;
            }
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size || arr == null) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        return arr[index];
    }

    public int indexOf(int element) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public int lastIndexOf(int element) {
        int idx = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public void remove(int index) {
        if (index < 0 || index >= size || arr == null) {
            throw new IndexOutOfBoundsException(String.format("Lỗi: Index %d vượt quá giới hạn độ dài mảng %d", index, size));
        }

        int[] newArr = new int[this.capacity];
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (!(i == index)) {
                newArr[idx++] = arr[i];
            }
        }
        arr = newArr;
        size--;
    }

    public void removeElement(int element) {
        if (arr == null) {
            throw new NullPointerException("Lỗi: Hiện tại mảng đang rỗng!");
        }

        int[] newArr = new int[this.capacity];
        int count = 0;
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (!(arr[i] == element)) {
                newArr[idx++] = arr[i];
                count++;
            }
        }

        size = count;
        arr = newArr;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append(", ");
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]");
        } else {
            stringBuilder.append("]");
        }

        return stringBuilder.toString();
    }
}
