package com.example.linkedlist;

public class DoublyLinkedListCycle<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

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
                    //", prev=" + prev +
                    //", next=" + next +
                    '}';
        }
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if (index == size) {// last添加
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);
            if (oldLast == null) {// 链表添加的第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node node = new Node(prev, element, next);
            next.prev = node;
            prev.next = node;
            if (next == first) { // index==0;
                first = node;
            }
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
        Node<E> node = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            node = node(index);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if (node == first) { // index = 0
                first = next;
            }

            if (node == last) {// index=size-1
                last = prev;
            }
        }
        size--;
        return node.element;
    }

    public Node<E> node(int index) {
        if (index < (index >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(",");
            sb.append(node);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedListCycle<String> list = new DoublyLinkedListCycle<>();
        list.add("A");
        list.remove(0);
        list.add("B");
        list.add("D");
        list.add("C");
        System.out.println(list);
        System.out.println(list.size);
        System.out.println(list.node(1));

//        System.out.println(list);
//        list.add(2, "b");
//        System.out.println(list);
//        System.out.println("remove=" + list.remove(0));
//        System.out.println(list);
//        System.out.println("remove=" + list.remove(2));
//        System.out.println(list);
    }
}
