package com;

import com.example.AbstractList;

public class DoublyLinkedList1<E> extends AbstractList<E> {

    public static void main(String[] args) {
        DoublyLinkedList1<Integer> list = new DoublyLinkedList1<>();
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
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    public Node<E> node(int index) {
        Node<E> node = null;
        if (index < (index >> 1)) {// first -> idnex;
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else { // last -> index
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
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

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
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

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node(oldLast, element, null);
            if (oldLast == null) { // size=0 没有元素
                first = last;
            } else { // 尾节点
                oldLast.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node(prev, element, next);
            next.prev = node;
            if (prev == null) { // first 添加
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }
}
