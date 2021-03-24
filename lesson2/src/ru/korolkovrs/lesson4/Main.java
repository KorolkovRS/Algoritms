package ru.korolkovrs.lesson4;


import ru.korolkovrs.MyCollections.Deque;

import java.util.*;

public class Main {
    public static final int SIZE = 10;
    public static final int INDEX = 5;

    public static void main(String[] args) {
        linkedStackTest();
        linkedDequeTest();
        listIteratorTest();
    }

    public static void linkedStackTest() {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        System.out.println(stack);
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println("size: " + stack.size());

        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(stack.pop());
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(stack.pop());
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println(stack);
    }

    public static void linkedDequeTest() {
        Deque<Integer> deque = new MyLinkedDeque<>();
        System.out.println(deque);
        for (int i = 0; i < 8; i++) {
            deque.addFirst(i);
        }

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        for (int i = 0; i < 8; i++) {
            deque.addLast(i + 100);
        }
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println("size: " + deque.size());

        for (int i = 0; i < 2; i++) {
            System.out.println(deque.removeFirst());
            System.out.println(deque.removeLast());
        }

        System.out.println(deque);
    }

    public static void listIteratorTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            list.insertLast(i);
        }

        list.forEach(integer -> System.out.print(integer + ", "));
        System.out.println();

        ListIterator<Integer> li = list.listIterator();

        int i = 0;
        while (li.hasNext()) {
            System.out.println(li.next());
            i++;
            if (i == INDEX) {
                li.remove();
            }
        }
        list.forEach(integer -> System.out.print(integer + ", "));
        System.out.println();

        i = 0;
        while (li.hasPrevious()) {
            li.previous();
            i++;
            if (i == INDEX) {
                li.remove();
            }
        }
        list.forEach(integer -> System.out.print(integer + ", "));
    }
}
