package com;

import java.util.Arrays;

public class ArrayList1 {
    private static final int DEFAULT_CAPACITY = 2;
    private int[] elements;
    private int size;

    public ArrayList1() {
        this(DEFAULT_CAPACITY);
    }

    private ArrayList1(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ",size=" + size);
        }
        int oldValue = elements[index];
        for (int i = index; i <= size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return oldValue;
    }

    public void add(int e) {
        add(size, e);
    }

    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index=" + index + ",size=" + size);
        }
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        int[] newElemnets = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newElemnets[i] = elements[i];
        }
        elements = newElemnets;
        System.out.println("oldCapacity = " + oldCapacity + ", newCapacity=" + newCapacity);
    }


    public int update(int index, int e) {
        int oldValue = elements[index];
        elements[index] = e;
        return oldValue;
    }

    public int indexOf(int e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayList1 list = new ArrayList1();
        list.add(0, -1);
        list.add(22);
        list.add(24);
        list.add(26);
        list.add(27);
        System.out.println(list);
//        System.out.println(list.update(0, 222));
//        System.out.println(list.remove(3));
        list.add(4, 99);
        list.add(111);
        list.add(111);
        list.add(111);
        System.out.println(list);
        System.out.println(list.indexOf(99));
    }
}
