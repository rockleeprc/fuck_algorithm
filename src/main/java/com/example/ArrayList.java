package com.example;


import java.util.Arrays;

/**
 * 动态数组
 */
public class ArrayList<E> {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        int old = list.remove(5);
        System.out.println(old);

        list.add(0, 22);
        System.out.println(list);
    }


    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 2;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = (capacity <= DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    /**
     * System.arraycopy(elements,index+1,elements,index,size-index);
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);

        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean constains(E element) {
        return indexOf(element) != -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void add(E element) {
        add(size, element);
    }

    /**
     * System.arraycopy(elements, index, elements, index + 1, size - index);
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("oldCapacity=" + oldCapacity + ",newCapacity" + newCapacity);
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBoundException(index);
        }

    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            indexOutOfBoundException(index);
        }
    }

    private void indexOutOfBoundException(int index) {
        throw new IndexOutOfBoundsException("index = " + index + ",size=" + size);
    }
}
