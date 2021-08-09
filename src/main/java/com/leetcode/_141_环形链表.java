package com.leetcode;

public class _141_环形链表 {
    /**
     * 快慢指针 相遇有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        // 链表为空
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { // 链表遍历技术，快慢指针还没有相遇
            slow = slow.next; // 慢指针一步
            fast = fast.next.next; // 快指针两步

            // 快慢指针相遇
            if (slow == fast)
                return true;
        }
        // 无环
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(hasCycle(node1));
    }
}
