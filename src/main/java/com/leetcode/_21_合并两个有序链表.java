package com.leetcode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _21_合并两个有序链表 {
    /**
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
}
