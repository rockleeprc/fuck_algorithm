package com.example;

public interface List<E> {
    int size();

    boolean isEmpty();

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E element);

    boolean contains(E element);

    void clear();

    void add(E element);

    void add(int index, E element);

}
