package com.example;

public abstract class AbstractList<E> implements List<E> {
    protected int size;

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBoundException(index);
        }
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            indexOutOfBoundException(index);
        }
    }

    protected void indexOutOfBoundException(int index) {
        throw new IndexOutOfBoundsException("index = " + index + ",size=" + size);
    }
}
