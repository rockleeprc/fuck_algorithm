package com.leetcode;

/**
 * 1、单向链表，在不知道前驱节点的情况下删除当前节点
 * 2、将当前节点的后继节点value赋值给当前节点的value
 * 3、将当前节点的后继节点指向后继节点的后继节点
 * 4、实际被删除的是当前节点的后继节点
 */
public class _237_删除链表中的节点 {
    /**
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
