package com.example;

public class DoublyLinkedList<E> {

    public static void main(String[] args) {

    }


    private int size;
    private Node<E> head;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;


        @Deprecated
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    public void add(E element) {
        add(size++, element);
    }

    public void add(int index, E element) {

    }

    public E set(int index, E element) {

        return null;
    }

    public E remove(int index) {
        return null;
    }

    private Node node(int index) {
        Node<E> node = head;
        for (int i = 1; i < size; i++) {
            if (index == i) return node;
            node = node.next;
        }
        return node;
    }
}
