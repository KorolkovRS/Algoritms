package ru.korolkovrs.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backpack <T extends Packageable> {
    private List<T> things;
    private int totalWeight;
    private int maxWeight;
    private int price;
    private boolean[] mask;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<T> getThings() {
        return things;
    }

    public int getWeight() {
        return totalWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getPrice() {
        return price;
    }

    public String getMask() {
        return Arrays.toString(mask);
    }

    public void autoPack(List<T> things) {
        this.things = things;
        generate(new boolean[things.size()], 0);

        int i = 0;
        List<T> packageThings = new ArrayList<>();

        for (Packageable thing : things) {
            if (mask[i]) {
                packageThings.add((T) thing);
            }
        }
        this.things = packageThings;
    }

    private void generate(boolean[] a, int t) {
        if (t == a.length) {
            int price = 0;
            int weight = 0;
            int i = 0;
            for (Packageable thing : things) {
                if (a[i]) {
                    price += thing.getPrice();
                    weight += thing.getWeight();
                }
                if (weight > maxWeight) {
                    break;
                }
                if (price > this.price) {
                    mask = Arrays.copyOf(a, a.length);
                    this.price = price;
                    totalWeight = weight;
                }
                i++;
            }
            return;
        }
        generate(a, t + 1);
        a[t] = !a[t];
        generate(a, t + 1);
    }
}
