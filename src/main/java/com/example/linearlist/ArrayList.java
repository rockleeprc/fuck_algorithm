package com.example.linearlist;


import com.example.AbstractList;

import java.util.Arrays;

/**
 * 动态数组
 */
public class ArrayList<E> extends AbstractList<E> {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(2, 33);

        System.out.println(list.size() == 6);

        int old = list.remove(5);
        System.out.println(list.get(4) == 5);

        list.add(0, 22);
        System.out.println(list.get(0) == 22);

        System.out.println(list.indexOf(99) == -1);
        System.out.println(list.indexOf(22) == 0);
        System.out.println(list.contains(22));

        list.add(null);
        System.out.println(list.indexOf(null) == 6);

        list.set(3, 88);
        System.out.println(list.get(3) == 88);
    }


    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

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
        checkRange(index);
        return elements[index];
    }

    public E set(int index, E element) {
        checkRange(index);

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
        checkRange(index);

        E old = elements[index];
        // 从index+1位置开始向前移动一个位置
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;

        // TODO 缩容
        return old;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E element) {
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
        // 不允许添加大于size的index
        checkRangeForAdd(index);
        ensureCapacity(size + 1);

        // index>size时，index位置后的元素整体向后移动一个位置
        // 从elements最后开始移动
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

}
