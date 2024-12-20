package com.leetcode._94;

import java.util.ArrayList;
import java.util.List;

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        invertTree(root,list);
        return list;
    }

    public void invertTree(TreeNode root,List<Integer> list) {
        if (root == null) return ;

        invertTree(root.left,list);

        list.add(root.val);

        invertTree(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);

        root.right = right;
        right.left = left;

        _94_二叉树的中序遍历 obj = new _94_二叉树的中序遍历();
        List<Integer> integers = obj.inorderTraversal(root);
        integers.forEach(System.out::println);


    }
}

