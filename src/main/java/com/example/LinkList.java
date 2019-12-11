package com.example;

public class LinkList<E> {
    public static void main(String[] args) {

    }

    private int size;
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;
    }

    public void clear() {
        size = 0;
        first = null;
    }

    public void add(int index,E elemnt){

    }
}
