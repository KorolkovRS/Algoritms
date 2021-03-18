package ru.korolkovrs.lesson3;

import ru.korolkovrs.lesson3.utills.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.revers("Hello world"));

        MyDequeue<Integer> dequeue = new MyDequeue<>();

        for (int i = 0; i < 14; i++) {
            dequeue.pop();
        }
    }
}
