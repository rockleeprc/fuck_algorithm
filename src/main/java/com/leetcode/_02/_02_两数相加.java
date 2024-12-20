package com.leetcode._02;

public class _02_两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode listNode = addTwoNumbers(l1, l2);
        StringBuilder sb = new StringBuilder();
        for (Integer result; listNode != null; listNode = listNode.next) {
            result = listNode.val;
            sb.append(result);
        }
        System.out.println(sb.reverse());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            // 初始化tail、head节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                // 尾插入
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // 进位值
            carry = sum / 10;
            // 移动链表
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后进位处理
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}


