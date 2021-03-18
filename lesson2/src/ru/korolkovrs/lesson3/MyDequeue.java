package ru.korolkovrs.lesson3;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDequeue<T> {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final static int DEFAULT_CAPACITY = 10;
    private float RISING_FACTOR = 1.5f;

    private T[] list;
    private int size;
    private int capacity;
    private int begin;
    private int end;

    public MyDequeue(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
            logger.log(Level.WARNING, "Error creating a stack with size= " + capacity + ". The default value is used.");
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDequeue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляемый элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insert(T item) throws IllegalStateException {
        if (isFull()) {
            reCapacity();
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
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

    private void reCapacity() {
        int temp = capacity;
        capacity *= RISING_FACTOR;
        T[] newList = (T[]) new Object[capacity];
    }
}
