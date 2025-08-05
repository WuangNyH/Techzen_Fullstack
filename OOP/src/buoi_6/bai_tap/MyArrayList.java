package buoi_6.bai_tap;

public class MyArrayList {
    private int size;
    private int capacity;
    private int[] arr;

    public MyArrayList() {
        this.capacity = 10;
        arr = new int[capacity];
    }

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

    public void add(int element) {
        if (this.size == this.capacity) {
            this.capacity *= 1.5;

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

        if (index == this.size) {
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
        checkEmpty();
        checkIndex(index);
        arr[index] = element;
    }

    public int get(int index) {
        checkEmpty();
        checkIndex(index);
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
        checkEmpty();
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void removeElement(int element) {
        checkEmpty();
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] != element) {
                arr[idx++] = arr[i];
            }
        }
        size = idx;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
