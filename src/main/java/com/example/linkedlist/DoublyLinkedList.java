package com.example.linkedlist;

import com.example.AbstractList;

public class DoublyLinkedList<E> extends AbstractList<E> {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

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


    public void add(int index, E element) {
        if (index == size) {// last添加
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            if (oldLast == null) {// 链表添加的第一个元素
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node node = new Node(prev, element, next);
            next.prev = node;
            if (prev == null) {// first添加 前驱为null
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return node.element;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    public E remove(int index) {
        Node<E> node = node(index);
        E oldValue = node.element;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) { // index = 0
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {// index=size-1
            last = prev;
        } else {
            next.prev = prev;
        }

        size--;
        return oldValue;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (node.element == null) { // null value
                    return i;
                }
            } else {
                if (element.equals(node.element)) { // object compare
                    return i;
                }
            }
            node = node.next;
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public Node<E> node(int index) {
        if (index < (index >> 1)) {
            Node<E> node = first;
            // 从first遍历时找到index前一个节点
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            // 从last遍历时找到index后一个节点
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
            if (i != 0) sb.append(" ");
            sb.append(node);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
