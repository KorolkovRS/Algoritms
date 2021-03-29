package ru.korolkovrs.lesson3.utills;

import ru.korolkovrs.lesson3.MyStack;


public class StringUtils {
    public static String revers(String string) {
        char[] ch = string.toCharArray();
        MyStack<Character> stack = new MyStack<>(ch.length);

        for (int i = 0; i < ch.length; i++) {
            stack.push(ch[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
