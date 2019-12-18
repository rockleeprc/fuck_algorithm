package com.example;

public class DoublyLinkedList<E> {

    public static void main(String[] args) {
        DoublyLinkedList<String> linked = new DoublyLinkedList<>();
        linked.add("A");
        linked.add("B");
        linked.add("D");
        linked.add("C");
        System.out.println(linked);
        System.out.println("remove="+linked.remove(0));
        System.out.println(linked);
        System.out.println("remove="+linked.remove(2));
        System.out.println(linked);
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

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if (index == 0) {
            Node node = new Node(element, head);
            node.next = head;
            head = node;
        } else {
            Node<E> prev = node(index - 1);
            Node<E> next = prev.next;
            prev.next = new Node<>(element, next);
        }
        size++;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    public E remove(int index) {
        E oldValue = null;
        if (index == 0) {
            oldValue = head.element;
            head = head.next;
        } else {
            Node<E> prev = node(index - 1);
            Node<E> node = prev.next;
            oldValue = node.element;
            prev.next = node.next;
        }
        return oldValue;
    }

    public Node<E> node(int index) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (index == i) return node;
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        int index = 0;
        sb.append("[");
        while (node != null) {
            if (index != 0) {
                sb.append("\r\n");
            }
            sb.append(node);
            node = node.next;
            index++;
        }
        sb.append("]");
        return sb.toString();
    }
}
