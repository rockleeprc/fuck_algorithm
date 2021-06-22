package com.leetcode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
