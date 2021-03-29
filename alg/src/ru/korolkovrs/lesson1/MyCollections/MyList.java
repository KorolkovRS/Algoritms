package ru.korolkovrs.lesson1.MyCollections;

public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    int indexOf(T item);
    int size();
    boolean remove(T item);
    T remove(int index);
    T get(int index);
    void set(int index, T item);
}