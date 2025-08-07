package buoi_7.bai_tap;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TaskManager<E> {
    private Stack<E> stack = new Stack<>();
    private Stack<E> redoStacks = new Stack<>();
    private Queue<E> queue = new LinkedList<>();

    public void pushToStack(E element) {
        stack.push(element);
    }

    public E peekFromStack() {
        return stack.peek();
    }

    public E popFromStack() {
        E value = stack.pop();
        redoStacks.push(value);
        return value;
    }

    public boolean isStackEmpty() {
        return stack.isEmpty();
    }

    public void addToQueue(E element) {
        queue.add(element);
    }

    public E peekFromQueue() {
        return queue.peek();
    }

    public E popFromQueue() {
        return queue.poll();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public void redoElementStack() {
        if (redoStacks.isEmpty()) {
            throw new EmptyStackException();
        }

        stack.push(redoStacks.pop());
        System.out.println("Redo thành công!");
    }

    public Queue<E> getQueue() {
        return queue;
    }
}
