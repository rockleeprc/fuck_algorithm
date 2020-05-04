package com.leetcode;

/**
 * 206. 反转链表
 * 反转一个单链表
 */
public class _206_反转链表 {
    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        // 1 2
        // newHead = 2  head = 1
        head.next.next = head; // 2.next = 1
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
        // 1 2
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next; // tmp = 2(1.next)    tmp = null
            head.next = newHead; // 1.next(2) = null
            newHead = head; // newHead = 1
            head = tmp; // head = 2
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);

        node1.next = node2;
//        node2.next = node3;

        ListNode newHead = reverseList2(node1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
