package buoi_7.ss8_generic_stack_queue;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.addLast(10);
        integerMyLinkedList.addLast(20);
        integerMyLinkedList.addLast(30);
        System.out.println(integerMyLinkedList);

        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.addLast("hello");
        System.out.println(stringMyLinkedList);

        for (String element : stringMyLinkedList) {
            System.out.println(element);
        }

        for (int element : integerMyLinkedList) {
            System.out.println(element);
        }
    }
}
