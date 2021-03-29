package ru.korolkovrs.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 200000;
        List<MyTreeMap<Integer, Integer>> maps = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            maps.add(generate());
        }

        int count = 0;
        for (MyTreeMap map: maps) {
            if (map.isBalanced()) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println((double) count * 100 / size);
    }

    public static MyTreeMap<Integer, Integer> generate() {
        Random r = new Random();
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
        while (map.height() < 6) {
            int num = r.nextInt(201) - 100;
            map.put(num, num);
        }
        return map;
    }
}
