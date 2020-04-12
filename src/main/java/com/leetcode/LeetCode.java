package com.leetcode;

public class LeetCode {

    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode p = new ListNode(-1);
        ListNode head = p;
        while (l1 != null && l2 != null) {
            //如果l1的值小于l2的值，就将p.next指向l1
            // 然后l1继续往后移动一位
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //如果l1和l2不一样长，等遍历完后，将p的next指向没遍历完的链表即可
        // 比如l1长度是3，1->2->3，l2长度是5 1->2->3->8->9
        // 等循环结束时，l1就指向8->9，只要将p.next指向8->9即可
        p.next = (l1 == null ? l2 : l1);
        return head.next;
    }


    /**
     * 237. 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
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
        /*
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        LeetCode code = new LeetCode();
        ListNode newHead = code.reverseList(node1);

        System.out.println(code.hasCycle(node1));
         */
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
        /*
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        LeetCode code = new LeetCode();
        ListNode newHead = code.reverseList(node1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
         */
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(11);
        ListNode node22 = new ListNode(22);
        ListNode node33 = new ListNode(33);
        node11.next = node22;
        node22.next = node33;

        LeetCode leetCode = new LeetCode();
        ListNode head = leetCode.mergeTwoLists(node1, node11);
        System.out.println(head);
    }
}
