package com.example;

public class LinkList<E> {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList();
        list.add("C");
        list.add("D");
        System.out.println(list);
        list.add(2, "B");
        list.add(1, "b");
        System.out.println(list);
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

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        checkRangeForAdd(index);
        if (index == 0) {
            first = new Node<E>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<E>(element, prev.next);
        }
        size++;
    }

    private Node<E> node(int index) {
        checkRange(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = first.next;
        }
        return node;
    }

    private void checkRangeForAdd(int index) {
        if (index < 0 || index > index) {
            indexOutOfBoundException(index);
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= index) {
            indexOutOfBoundException(index);
        }
    }

    private void indexOutOfBoundException(int index) {
        throw new IndexOutOfBoundsException("index = " + index + ",size=" + size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(",");
            sb.append(node.element);
            node = node.next;
        }
        return sb.toString();
    }
}
