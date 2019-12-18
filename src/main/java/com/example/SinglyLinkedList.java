package com.example;

public class SinglyLinkedList<E> {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList();
        list.add("C");
        list.add("D");
        System.out.println(list);
        list.add(2, "B");
        System.out.println(list);
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

    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;// prev.next = prev.next.next;
        }
        return node.element;
    }

    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(null)) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return -1;
    }

    private Node<E> node(int index) {
        checkRange(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkRangeForAdd(int index) {
        if (index < 0 || index > size) {
            indexOutOfBoundException(index);
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
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

        /*
        while (node != null) {
            node = node.next;
        }
         */
        return sb.toString();
    }
}
