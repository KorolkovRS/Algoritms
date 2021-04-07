package ru.korolkovrs.lesson8;

public class Main {

    public static void main(String[] args) {
        testChainingMap();
        testLinearMap();

    }

    public static void testChainingMap() {
        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(4);

        chm.put(4, "four");
        chm.put(5, "five");
        chm.put(6, "six");
        chm.put(7, "seven");
        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");
        chm.put(2, "twosdfsdf");

        System.out.println(chm.size());
        System.out.println(chm);
        chm.remove(2);
        chm.remove(4);
        System.out.println(chm.size());
        System.out.println(chm);
    }

    public static void testLinearMap() {
        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(4);

        lphm.put(4, "four");
        lphm.put(5, "five");
        lphm.put(6, "six");
        lphm.put(7, "seven");
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.put(2, "twosdfsdf");

        System.out.println(lphm.size());
        System.out.println(lphm);
        lphm.remove(2);
        lphm.remove(4);
        System.out.println(lphm.size());
        System.out.println(lphm);
        lphm.put(2, "fg");
        System.out.println(lphm);
        System.out.println(lphm.get(2));
        lphm.put(4, "fgf");
        System.out.println(lphm);
        lphm.put(11, "eleven");
        System.out.println(lphm);
        lphm.put(9, "nine");
        System.out.println(lphm);
        System.out.println(lphm.get(4));
    }
}
