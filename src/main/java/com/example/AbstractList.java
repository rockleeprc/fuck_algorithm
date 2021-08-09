package com.example;

public abstract class AbstractList<E> implements List<E> {
    protected int size;

    public void add(E element) {
        add(size, element);
    }

    protected void checkRangeForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBoundException(index);
        }
    }

    protected void checkRange(int index) {
        if (index < 0 || index >= size) {
            indexOutOfBoundException(index);
        }
    }

    protected void indexOutOfBoundException(int index) {
        throw new IndexOutOfBoundsException("index = " + index + ",size=" + size);
    }
}
