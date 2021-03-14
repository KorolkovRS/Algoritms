package ru.korolkovrs.MyCollections;

public class MyArrayList<T> implements MyList<T> {
    private T[] list;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float MAX_LOAD = 0.75f;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T item) {
        expandArray();
        list[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {
        expandArray();
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + (size - 1));
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    @Override
    public int indexOf(Object item) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + ", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.append("]").toString();
    }

    private void expandArray() {
        if ((size / (float) capacity) >= MAX_LOAD) {
//            System.out.println("expand");
        }
    }
}
