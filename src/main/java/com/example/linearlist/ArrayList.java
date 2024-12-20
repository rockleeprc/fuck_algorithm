package com.example.linearlist;


import com.example.AbstractList;

import java.util.Arrays;

/**
 * 动态数组
 */
public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = (capacity <= DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        // 用所有对象的父类
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
        // 删除最后一个元素，修改size值
        elements[--size] = null;

        trimCapacity();
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
        // 不允许添加大于size的index，但可以添加index=size的值
        checkRangeForAdd(index);
        ensureCapacity(size + 1);

        // index>size时，index位置后的元素整体向后移动一个位置
        // 从elements最后开始移动
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        // 添加新元素，修改size值
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

        // capacity+(capacity/2)，扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("扩容：oldCapacity=" + oldCapacity + ",newCapacity" + newCapacity);
    }

    private void trimCapacity() {
        int newCapacity = elements.length >> 1;
        // 不做处理
        if (size >= newCapacity || size <= DEFAULT_CAPACITY) return;

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        System.out.println("缩容：oldCapacity=" + elements.length + ",newCapacity" + newCapacity);
        elements = newElements;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }
        System.out.println(list);
    }
}
