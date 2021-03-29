package ru.korolkovrs.lesson5;

public class Thing implements Packageable {
    private int weight;
    private int price;

    public Thing (int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
