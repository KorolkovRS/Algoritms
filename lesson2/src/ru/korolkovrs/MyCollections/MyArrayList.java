package ru.korolkovrs.MyCollections;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyArrayList<T extends Comparable> implements MyList<T> {
    static Logger logger = Logger.getLogger(Logger.getGlobal().getName());
    private static final int DEFAULT_CAPACITY = 10;

    private T[] list;
    private int size;
    private int capacity;
    private final float RISING_FACTOR = 1.5f;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0: " + capacity);
        }
        list = (T[]) new Comparable[capacity];
        this.capacity = capacity;
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
        checkIndex(index);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public final T remove(int index) {
        checkIndex(index);
        T temp = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
        return temp;
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        list[index] = item;
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
        if (size >= capacity) {
            capacity *= RISING_FACTOR;
            T[] newList = (T[]) new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            list = newList;
            logger.log(Level.ALL, size + "/ " + capacity);
        }
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + (size));
        }
    }

    public void bubbleSort() {
        Long start = System.currentTimeMillis();
        Long count = 0L;
        boolean isSorted;
        for (int i = size - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    swap(j, j + 1);
                    isSorted = false;
                }
//                count++;
            }
            if (isSorted) {
                break;
            }
        }
        Long end = System.currentTimeMillis();
        Long time = end - start;
        logger.log(Level.INFO, String.format("Method: BubbleSort, running time: %d ms," +
                " number of iteration: %d", time, count));
    }

    public void selectSort() {
        Long start = System.currentTimeMillis();
        Long count = 0L;
        int min;
        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (list[min].compareTo(list[j]) > 0 ) {
                    min = j;
                }
//                count++;
            }
            swap(i, min);
        }
        Long end = System.currentTimeMillis();
        Long time = end - start;
        logger.log(Level.INFO, String.format("Method: SelectSort, running time: %d ms," +
                " number of iteration: %d", time, count));
    }

    public void insertSort() {
        Long start = System.currentTimeMillis();
        Long count = 0L;
        T obj;
        for (int i = 1; i < size; i++) {
            obj = list[i];
            int j = i;
            while (j > 0 && obj.compareTo(list[j - 1]) < 0) {
                list[j] = list[j - 1];
                j--;
//                count++;
            }
            list[j] = obj;
        }
        Long end = System.currentTimeMillis();
        Long time = end - start;
        logger.log(Level.INFO, String.format("Method: InsertSort, running time: %d ms," +
                " number of iteration: %d", time, count));
    }

    private void swap(int first, int second) {
        T temp = list[second];
        list[second] = list[first];
        list[first] = temp;
    }
}
