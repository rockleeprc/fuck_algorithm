package com.leetcode._21;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this(x, null);
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
