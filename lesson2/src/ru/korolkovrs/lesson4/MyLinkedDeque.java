package ru.korolkovrs.lesson4;

import ru.korolkovrs.MyCollections.Deque;

public class MyLinkedDeque<T> implements Deque<T> {
    private MyLinkedList<T> ll = new MyLinkedList<>();

    @Override
    public void addFirst(T item) {
        ll.insertFirst(item);
    }

    @Override
    public void addLast(T item) {
        ll.insertLast(item);
    }

    @Override
    public T peekFirst() {
        return ll.getFirst();
    }

    @Override
    public T peekLast() {
        return ll.getLast();
    }

    @Override
    public T removeFirst() {
        T first = ll.getFirst();
        ll.removeFirst();
        return first;
    }

    @Override
    public T removeLast() {
        T last = ll.getLast();
        ll.removeLast();
        return last;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public String toString() {
        return ll.toString();
    }
}
