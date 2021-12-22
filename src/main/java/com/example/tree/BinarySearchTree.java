package com.example.tree;

import com.example.tree.printer.BinaryTreeInfo;
import com.example.tree.printer.BinaryTrees;

import java.util.Comparator;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root; // 跟节点
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

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

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new RuntimeException("element mustn't null");
        }
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 根节点
        if (root == null) {
            root = new Node<>(element, null);
        } else {// 非根节点
            Node<E> parent = root, node = root;
            int compare = 0; // 保存compare()结果，用于添加节点
            while (node != null) { // 从root节点循环比较，直到node为空时结束
                parent = node; // 循环中记录parent节点
                compare = compare(element, node.element);
                if (compare > 0) { // e1>e2，获取右子节点继续比较
                    node = node.right;
                } else if (compare < 0) { // e1<d2，获取左子节点继续比较
                    node = node.left;
                } else {// e1 == e2
                    node.element = element; // 对象重新赋值
                    return;
                }
            }

            // 创建新的node挂载到parent上
            Node<E> newNode = new Node<>(element, parent);
            if (compare > 0) {
                parent.right = newNode;
            } else if (compare < 0) {
                parent.left = newNode;
            }
        }
        size++;
    }

    /**
     * @param e1
     * @param e2
     * @return 0：e1=e2
     * 大于0：e1>e2
     * 小于0：e1<e2
     */
    private int compare(E e1, E e2) {
        // 优先使用comparator
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // comparator为null时，将e1、e2强转为Comparable进行比较
        // 没有是实现Comparable将抛异常
        return ((Comparable) e1).compareTo(e2);
    }

    public boolean contains(E element) {
        return false;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node) node).element;
    }

    private static class Node<E> {
        E element;
        Node<E> parent; // 父节点
        Node<E> left; // 左节点
        Node<E> right; // 右节点

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    /**
     * 前序编列
     * @param node
     */
    private void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i : arr) {
            bst.add(i);
        }
        BinaryTrees.println(bst);
        bst.preorderTraversal();
    }
}
