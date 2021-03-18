package ru.korolkovrs.lesson3;

import ru.korolkovrs.lesson3.utills.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.revers("Hello world"));

        MyDeque<Integer> dequeue = new MyDeque<>();
        myDequeTest(dequeue);
    }
    public static void myDequeTest(MyDeque deque) {
        for (int i = 0; i < 12; i++) {
            deque.addFirst(i);
        }
        System.out.println(deque);

        for (int i = 0; i < 2; i++) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

        for (int i = 0; i < 4; i++) {
            deque.addLast(i);
        }
        System.out.println(deque);

        for (int i = 0; i < 2; i++) {
            deque.addFirst(i);
        }
        System.out.println(deque);

        for (int i = 0; i < 2; i++) {
            System.out.println(deque.removeLast());
        }
        System.out.println(deque);
    }
}
