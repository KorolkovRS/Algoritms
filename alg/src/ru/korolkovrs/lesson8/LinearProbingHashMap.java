package ru.korolkovrs.lesson8;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearProbingHashMap<Key, Value> {
    private final float RISING_FACTOR = 1.5f;
    private final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int size;
    private final Object DELETED;
    private Logger logger;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        DELETED = new Object();
        init();
    }

    private void init() {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        logger = Logger.getLogger(LinearProbingHashMap.class.getName());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(Key key, Value value){
        // проверка на прввышение лоад фактора. Либо просаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        checkKeyNotNull(key);
        checkCapacity();
        int i = hash(key);
        int step = 1;
        while (keys[i] != null && keys[i] != DELETED) {
            if(keys[i].equals(key)){
                values[i]= value;
                return;
            }
            i = (i+step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }

    public void remove(Key key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = (Key) DELETED;
                values[i] = null;   //Впринципе можно и не занулять
                size--;
                return;
            }
        }
    }

    private void checkCapacity() {
        if (((float) size / capacity) >= LOAD_FACTOR) {
            allocate();
        }
    }

    private void allocate() {
        logger.log(Level.INFO,"Before allocate:\n" + this);
        int oldCapacity = capacity;
        installNewCapacity();
        size = 0;

        Key[] oldKeys = keys.clone();
        Value[] oldValues = values.clone();

        init();

        for (int i = 0; i < oldCapacity; i++) {
            if (oldKeys[i] != null) {
                this.put(oldKeys[i], oldValues[i]);
            }
        }
        logger.log(Level.INFO,"After allocate:\n" + this);
    }

    private void installNewCapacity() {
        int reference = (int) (capacity * RISING_FACTOR);

        //Находим простое число, не меньшее, чем reference
        while (true) {
            int div =2;
            while (div * div <= reference) {
                if (reference % div == 0) {
                    reference++;
                    div = 2;
                    continue;
                }
                div++;
            }
            capacity = reference;
            break;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(keys);
    }
}
