package com;

public class SingleLinkedList1<E> {
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

    public void update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size=" + size + ",index=" + index);
        }

        Node node = node(index);
        node.element = e;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size=" + size + ",index=" + index);
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node prev = node(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    public Node node(int index) {
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
        sb.append(",first=" + first);
        return sb.toString();
    }

    public static void main(String[] args) {
        SingleLinkedList1<String> list = new SingleLinkedList1<>();
        list.add("a");
        list.add("c");
        list.add("d");
        list.add(0, "x");
        list.add(4, "Q");
        System.out.println(list);
//        list.remove(2);
//        list.update(0,"AA");
//        System.out.println(list.node(0));
        System.out.println(list);
    }
}
