package ru.korolkovrs.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(pow(-1, 200));

        List<Thing> things = new ArrayList<>();
        things.add(new Thing(5, 5));
        things.add(new Thing(9, 7));
        things.add(new Thing(8, 11));
        things.add(new Thing(1, 2));
        things.add(new Thing(10, 8));
        things.add(new Thing(6, 12));


        Backpack bag = new Backpack(20);
        bag.autoPack(things);
        System.out.println(bag.getThings());
        System.out.println(bag.getWeight());
        System.out.println(bag.getPrice());
        System.out.println(bag.getMask());

    }

    public static Long pow(int a, int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + "<0");
        }

        if (n == 0) {
            return (long) 1;
        }

        if (a == 0) {
            return (long) 0;
        }

        if (a == 1) {
            return (long) 1;
        }

        if (a == -1) {
            return (long) ((n % 2 == 0) ? 1 : -1);
        }

        if (n == 1) {
            return (long) a;
        }
        return pow(a, n - 1) * a;
    }
}
