package com;

public class LinkedList1<E> {
    private int size;
    private Node<E> first;


    public void add(E e) {
        add(size, e);
    }

    private void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("size=" + size + ",index=" + index);
        }

        if (index == 0) {
            first = new Node(e, first);
        } else {
            Node prev = node(index - 1);
            prev.next = new Node(e, prev.next);
        }
        size++;
    }

    private Node node(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        sb.append("[");
        while (node != null) {
            sb.append(node.element).append(" ");
            node = node.next;
        }
        sb.append("]");
        sb.append(",size=" + size);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList1<String> list = new LinkedList1<>();
        list.add("a");
        list.add("c");
        list.add("d");
        System.out.println(list);
        list.add(0, "x");
        list.add(4, "Q");
        System.out.println(list);
    }
}
