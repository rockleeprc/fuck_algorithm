package com.leetcode;

public class LinkedLeetCode {
    /**
     * 237. 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.val;
        node.next = node.next.next;
    }

    /**
     * 141. 环形链表
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * 206. 反转链表
     * 反转一个单链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        LinkedLeetCode code = new LinkedLeetCode();
        ListNode newHead = code.reverseList(node1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
