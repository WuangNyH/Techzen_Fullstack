package buoi_7.stack_queue;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<E> implements Iterable<E> {
    private int capacity;
    private E[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.capacity = 10;
        stack = (E[]) new Object[capacity];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    @SuppressWarnings("unchecked")
    public void pushToStack(E element) {
        if (this.size == this.capacity) {
            capacity *= 1.5;

            E[] newStack = (E[]) new Object[this.capacity];

            for (int i = 0; i < this.size; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }

        stack[size++] = element;
    }

    public E peekFromStack() {
        checkEmpty();
        return stack[size - 1];
    }

    public E popFromStack() {
        checkEmpty();
        return stack[--size];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return stack[index++];
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < size; i++) {
            output.append(stack[i]);
            if (i != size - 1) {
                output.append(", ");
            }
        }
        output.append("]");
        return output.toString();
    }
}
