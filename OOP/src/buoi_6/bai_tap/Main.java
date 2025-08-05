package buoi_6.bai_tap;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        MyArrayList list = new MyArrayList();
//
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(2);
//        list.add(3);
//
//        list.removeElement(2);
//
//        System.out.println(list);

        MyLinkedList list = new MyLinkedList();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println();

        list.add(3, 4);
        System.out.println(list);

    }
}
