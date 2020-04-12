package com;

import java.util.Arrays;

public class ArrayList2 {

    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList2(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public void add(int e) {
        add(size, e);
    }

    private void add(int index, int e) {
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
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        System.out.println("oldCapacity = " + oldCapacity + ",newCapacity = " + newCapacity);
        elements = newElements;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ",size=" + size);
        }

        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }

        int oldValue = elements[index];
        return oldValue;
    }

    public int update(int index, int e) {
        int oldValue = elements[index];
        elements[index] = e;
        return oldValue;
    }

    @Override
    public String toString() {
        return "ArrayList2{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayList2 list = new ArrayList2();
        list.add(0, 11);
        list.add(1, 12);
        list.add(2, 14);
        list.add(99);
        list.add(88);
        list.add(88);
        list.add(88);
        System.out.println(list);
        list.remove(4);
        System.out.println(list);

    }
}
