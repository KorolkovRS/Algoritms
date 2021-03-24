package ru.korolkovrs.MyCollections;

public interface Deque<T> {
    void addFirst(T item);

    void addLast(T item);

    T peekFirst();

    T peekLast();

    T removeFirst();

    T removeLast();

    boolean isEmpty();

    int size();
}
