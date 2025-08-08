package buoi_7.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.capacity());

        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }

        System.out.println(stack);

//        MyStack<Integer> myStack = new MyStack<>();
//
//        myStack.pushToStack(1);
//        myStack.pushToStack(2);
//        myStack.pushToStack(3);
//        myStack.pushToStack(4);
//
//        for (Integer integer : myStack) {
//            System.out.println(integer);
//        }
//
//        System.out.println(myStack);

    }
}
