package com.leetcode._206;


public class _206_反转链表 {
    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        // head为null、链表中只有一个元素
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList1(head.next);
        // 反转node
        // 原始链表：node1 node2
        // node2.next = node1
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 非递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
            /**
             * loop1：
             * tmp = node2; node2作为临时变量
             * node1.next = newHead; 将node1.next指向newHead
             * newHead = node1; 将newHead指向node1
             * head = node2; 将node2做为head
             */
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode newHead = reverseList2(node1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
