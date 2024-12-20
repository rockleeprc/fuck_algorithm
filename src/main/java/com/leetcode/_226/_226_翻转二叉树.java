package com.leetcode._226;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class _226_翻转二叉树 {
    /**
     * 前序遍历，递归调用
     * 根、左、右
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;

        // 左右交换
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        // 递归调用
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    /**
     * 后序遍历，递归调用
     * 左、右、根
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;

        // 递归调用
        invertTree2(root.left);
        invertTree2(root.right);

        // 左右交换
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }

    /**
     * 中序遍历
     * 左、根、右
     *
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return root;

        // 递归调用
        invertTree3(root.left);

        // 左右交换
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        // 已经交换了，访问的还是left
        invertTree3(root.left);

        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 左右交换
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }
}
