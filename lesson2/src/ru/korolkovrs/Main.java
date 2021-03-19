package ru.korolkovrs;

import ru.korolkovrs.MyCollections.MyArrayList;
import ru.korolkovrs.MyCollections.MyList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list;

        list = init();
        ((MyArrayList<Integer>) list).bubbleSort();
        list = init();
        ((MyArrayList<Integer>) list).selectSort();
        list = init();
        ((MyArrayList<Integer>) list).insertSort();
    }

    private static MyList<Integer> init() {
        Random r = new Random();
        int size = 100000;
        MyList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt());
        }
        return list;
    }
}
