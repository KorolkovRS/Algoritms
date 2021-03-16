package ru.korolkovrs.MyCollections;


public class MySortedArrayList<T extends Comparable<T>> extends MyArrayList<T>{
    @Override
    public void add(T item) {
        int i = 0;
        while (i < size() && item.compareTo(super.get(i)) > 0) {
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, T item) {
        add(item);
    }

    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(T item) {
        int begin = 0;
        int end = size() - 1;
        int mid;
        T temp;

        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            temp = get(mid);
            if (item.compareTo(temp) > 0) {
                begin = mid + 1;
            } else if (item.compareTo(temp) < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
