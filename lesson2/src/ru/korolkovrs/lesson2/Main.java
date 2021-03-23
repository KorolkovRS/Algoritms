package ru.korolkovrs.lesson2;

import ru.korolkovrs.lesson2.MyCollections.MyArrayList;
import ru.korolkovrs.lesson2.MyCollections.MyList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 8;

        MyList<Integer> list = new MyArrayList<>();
        System.out.println(list);
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(100));
        }

//        MyList<Integer> list = new MySortedArrayList<>();
//        System.out.println(list);
//        for (int i = 0; i < size; i++) {
//            list.add(r.nextInt(10));
//            list.add(i);
//        }

        System.out.println(list);
        ((MyArrayList<Integer>) list).insertSort();
        System.out.println(list);
//        list.add(10,5);
//        list.add( 5);
//        list.add( -6);
//        System.out.println(list);
    }
}
