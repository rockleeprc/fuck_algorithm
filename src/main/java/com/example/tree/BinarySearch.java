package com.example.tree;

public class BinarySearch<E> {
    public static void main(String[] args) {

    }

    private int size;
    private Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
    }

    public E remove(E element) {
        return null;
    }

    public void add(E element) {
        if (element == null) {
            throw new RuntimeException("element mustn't null");
        }

        if (root == null) {// 根节点
            root = new Node<E>(element, null);
        } else {// 非根节点
            Node<E> parent = root;
            Node<E> node = root;
            int compare = 0;

            while (node != null) {
                compare = compare(element, node.element);
                parent = node.parent; // 记录parent节点
                if (compare > 0) {
                    node = node.right;
                } else if (compare < 0) {
                    node = node.left;
                } else {// 相等
                    node.element = element; // 自定义对象重新赋值
                    return;
                }
            }

            Node<E> newNode = new Node<>(element, parent);
            if (compare > 0) {
                node.right = newNode;
            } else if (compare < 0) {
                node.left = newNode;
            }
        }
        size++;
    }

    private int compare(E element1, E element2) {
        return 0;
    }

    public boolean contains(E element) {
        return false;
    }

    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
