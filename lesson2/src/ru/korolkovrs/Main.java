package ru.korolkovrs;

import ru.korolkovrs.MyCollections.MyArrayList;
import ru.korolkovrs.MyCollections.MyList;
import ru.korolkovrs.MyCollections.MySortedArrayList;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 10;

//        MyList<Integer> list = new MyArrayList<>();
//        System.out.println(list);
//        for (int i = 0; i < size; i++) {
//            list.add(r.nextInt(100));
//        }

        MyList<Integer> list = new MySortedArrayList<>();
        System.out.println(list);
        for (int i = 0; i < size; i++) {
//            list.add(r.nextInt(10));
            list.add(i);
        }

        System.out.println(list);
        System.out.println(list.indexOf((Integer) 9));
//        list.add(10,5);
//        list.add( 5);
//        list.add( -6);
//        System.out.println(list);
    }
}
