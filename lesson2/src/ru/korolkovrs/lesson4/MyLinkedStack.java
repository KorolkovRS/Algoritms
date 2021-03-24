package ru.korolkovrs.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedStack<T> {
    private MyLinkedList<T> ll = new MyLinkedList<>();

    public void push(T item){
        ll.insertFirst(item);
    }

    public T peek(){
        return ll.getFirst();
    }

    public T pop() throws NoSuchElementException {
        T first = ll.getFirst();
        ll.removeFirst();
        return first;
    }

    public int size(){
        return ll.size();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }

    @Override
    public String toString() {
        return ll.toString();
    }
}
