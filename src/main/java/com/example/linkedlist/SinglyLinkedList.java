package com.example.linkedlist;

import com.example.AbstractList;

public class SinglyLinkedList<E> extends AbstractList<E> {

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    public E get(int index) {
        checkRange(index);
        return node(index).element;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }



    public void add(int index, E element) {
        checkRangeForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    public E remove(int index) {
        checkRange(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;// prev.next = prev.next.next;
        }
        size--;
        return node.element;
    }

    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    private Node<E> node(int index) {
        checkRange(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(null);
        System.out.println(list.get(list.size - 1));

        System.out.println(list.size() == 6);

        int old = list.remove(5);
        System.out.println(list.get(4) == 5);

        list.add(0, 22);
        System.out.println(list.get(0) == 22);

        System.out.println(list.indexOf(99) == -1);
        System.out.println(list.indexOf(22) == 0);
        System.out.println(list.contains(22));

        list.add(null);
        System.out.println(list.indexOf(null) == 6);

        list.set(3, 88);
        System.out.println(list.get(3) == 88);
    }

}
