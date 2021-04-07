package ru.korolkovrs.lesson8;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainingHashMap<Key, Value> {
    private final float RISING_FACTOR = 1.5f;
    private final float LOAD_FACTOR = 0.75f;
    private Logger logger;
    private int capacity;
    private int size;

    private LinkedList<Node>[] st;

    public ChainingHashMap(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
        logger = Logger.getLogger(ChainingHashMap.class.getName());
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
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

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        checkCapacity();
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            boolean nullFlag = true;
            for (Node node : st[i]) {
                sb.append(node.key).append(" ");
                nullFlag = false;
            }
            if (nullFlag) {
                sb.append("null");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    //реализовать метод удаления.

    public void remove(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        LinkedList<Node> linkedList = st[i];
        linkedList.removeIf(node -> {
            if (node.key.equals(key)) {
                size--;
                return true;
            }
            return false;
        });
    }

    private void checkCapacity() {
        if (((float) size / capacity) >= LOAD_FACTOR) {
            allocate();
        }
    }

    private void allocate() {
        logger.log(Level.INFO,"Before allocate:\n" + this);
        int oldCapacity = capacity;
        capacity *= RISING_FACTOR;
        size = 0;
        LinkedList<Node>[] oldArray = st.clone();
        init();

        for (int i = 0; i < oldCapacity; i++) {
            for (Node node : oldArray[i]) {
                if (node != null) {
                    this.put(node.key, node.value);
                }
            }
        }
        logger.log(Level.INFO,"After allocate:\n" + this);
    }
}



