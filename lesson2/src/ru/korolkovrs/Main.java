package ru.korolkovrs;

import ru.korolkovrs.MyCollections.MyArrayList;
import ru.korolkovrs.MyCollections.MyList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 5;

        MyList<Integer> list = new MyArrayList<>();
        System.out.println(list);
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(100));
        }

        System.out.println(list);
        list.add(5, -1);
        System.out.println(list);
    }
}
