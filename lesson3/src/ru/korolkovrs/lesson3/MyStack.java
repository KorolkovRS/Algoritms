package ru.korolkovrs.lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyStack<T> {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private final static int DEFAULT_CAPACITY = 5;
    private float RISING_FACTOR = 1.5f;

    private T[] list;
    private int capacity;
    private int position;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
            logger.log(Level.WARNING, "Error creating a stack with size= " + capacity + ". The default value is used.");
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
        position = capacity;
    }

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public void push(T object) {
        if (position <= 0) {
            resize();
        }
        position--;
        list[position] = object;
    }

    public T pop() throws EmptyStackException {
        if (position == capacity) {
            throw new EmptyStackException();
        }
        T temp = list[position];
        list[position] = null;
        position++;
        return temp;
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[position];
    }

    private void resize() {
        int i = capacity - 1;
        capacity *= RISING_FACTOR;
        T[] newList = (T[]) new Object[capacity];
        position = capacity;

        for (; i > 0; i--) {
            position--;
            newList[position] = list[i];
        }
        list = newList;
    }

    public boolean isEmpty() {
        return position == capacity;
    }


    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
