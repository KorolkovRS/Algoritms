package ru.korolkovrs.lesson3;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDeque<T> {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final static int DEFAULT_CAPACITY = 10;
    private float RISING_FACTOR = 1.5f;

    private T[] list;
    private int size;
    private int capacity;
    private int begin;
    private int end;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
            logger.log(Level.WARNING, "Error creating a stack with size= " + capacity + ". The default value is used.");
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void addFirst(T item) {
        if (isFull()) {
            allocateNewList();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void addLast(T item) {
        if (isFull()) {
            allocateNewList();
        }
        begin = lastIndex(begin);
        list[begin] = item;
        size++;

    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[end - 1];
    }

    public T removeFirst() {
        T temp = peekFirst();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeLast() {
        T temp = peekLast();
        end = lastIndex(end);
        size--;
        list[end] = null;
        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int lastIndex(int index) {
        int i = index - 1;

        return (i >= 0) ? i : (list.length - 1);
    }

    private void allocateNewList() {
//        int temp = capacity + begin;
//        end = capacity;
//        capacity *= RISING_FACTOR;
//        T[] newList = (T[]) new Object[capacity];
//
//        for (int i = begin, j = 0; i < temp ; i++, j++) {
//            newList[j] = list[nextIndex(i - 1)];
//        }
//        list = newList;
//        begin = 0;

        end = capacity;
        capacity *= RISING_FACTOR;
        T[] newList = (T[]) new Object[capacity];

        for (int i = begin, j = 0; j < end; i = nextIndex(i), j++) {
            newList[j] = list[i];
        }

        list = newList;
        begin = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        int i = begin;
        while (i != end) {
            sb.append(list[i]).append(", ");
            i = nextIndex(i);
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
