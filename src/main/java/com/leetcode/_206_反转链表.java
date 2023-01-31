package com.leetcode;


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
        /*
            原始链表：node1 node2
            方法内变量：newHead = node2  head = node1
            当前node.next.next指向当前node
         */
        head.next.next = head; // node2.next = node1
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
            ListNode tmp = head.next; // tmp = node2(node1.next)
            head.next = newHead; // node1.next = null
            newHead = head; // newHead = node1
            head = tmp; // head = node2
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode newHead = reverses(node1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode reverses(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null) {
            ListNode headNext = head.next;
            head.next = newHead;
            newHead = head;
            head = headNext;
        }

        return newHead;
    }
}
