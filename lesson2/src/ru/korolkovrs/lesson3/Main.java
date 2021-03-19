package ru.korolkovrs.lesson3;

import ru.korolkovrs.lesson3.utills.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.revers("Hello world"));

        MyDeque<Integer> dequeue = new MyDeque<>();

//        for (int i = 0; i < 22; i++) {
//            dequeue.insert(i);
//        }
//        System.out.println(dequeue);
//        for (int i = 0; i < 2; i++) {
//            System.out.println(dequeue.remove());
//        }
//        System.out.println(dequeue);
//        for (int i = 0; i < 2; i++) {
//            dequeue.insert(100+i);
//        }
//        System.out.println(dequeue);
//        for (int i = 0; i < 2; i++) {
//            dequeue.insert(200+i);
//        }
//        System.out.println(dequeue);
//        for (int i = 0; i < 2; i++) {
//            System.out.println(dequeue.remove());
//        }
//        System.out.println(dequeue);
//        for (int i = 0; i < 2; i++) {
//            dequeue.insert(300+i);
//        }
//        System.out.println(dequeue);

        for (int i = 0; i < 6; i++) {
            dequeue.addFirst(i);
        }
        System.out.println(dequeue);

        for (int i = 0; i < 2; i++) {
            System.out.println(dequeue.removeFirst());
        }
        System.out.println(dequeue);

        for (int i = 0; i < 4; i++) {
            dequeue.addLast(i);
        }
        System.out.println(dequeue);

        for (int i = 0; i < 2; i++) {
            dequeue.addFirst(i);
        }
        System.out.println(dequeue);

        for (int i = 0; i < 2; i++) {
            System.out.println(dequeue.removeLast());
        }
        System.out.println(dequeue);
    }
}
