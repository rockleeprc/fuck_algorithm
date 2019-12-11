package com.example;

public class LinkList<E> {
    public static void main(String[] args) {

    }

    private int size;
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void clear() {
        size = 0;
        first = null;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    public void add(int index, E element) {
        if (index == 0) {
            first.next = new Node<E>(element, first.next);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<E>(element, prev.next);
        }
        size++;
    }

    private Node<E> node(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = first.next;
        }
        return node;
    }

    private void checkRange(int index) {

    }
}
