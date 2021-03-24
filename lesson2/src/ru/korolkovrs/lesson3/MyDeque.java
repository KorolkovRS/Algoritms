package ru.korolkovrs.lesson3;

import ru.korolkovrs.MyCollections.Deque;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDeque<T> implements Deque<T> {
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
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            reCapacity();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            reCapacity();
        }
        begin = lastIndex(begin);
        list[begin] = item;
        size++;

    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[end - 1];
    }

    @Override
    public T removeFirst() {
        T temp = peekFirst();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    @Override
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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
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

    private void reCapacity() {
        int temp = capacity + begin;
        end = capacity;
        capacity *= RISING_FACTOR;
        T[] newList = (T[]) new Object[capacity];

        for (int i = begin, j = 0; i < temp ; i++, j++) {
            newList[j] = list[nextIndex(i - 1)];
        }
        list = newList;
        begin = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
//        StringBuilder sb = new StringBuilder("[ ");
//        int i = begin;
//        while (i != end) {
//            sb.append(list[i]).append(", ");
//            i = nextIndex(i);
//        }
//        if (size > 0) {
//            sb.setLength(sb.length() - 2);
//        }
//        sb.append(" ]");
//        return sb.toString();
    }
}
