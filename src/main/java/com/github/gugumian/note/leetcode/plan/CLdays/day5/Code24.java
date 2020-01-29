package com.github.gugumian.note.leetcode.plan.CLdays.day5;

import com.github.gugumian.note.leetcode.common.ListNode;

import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode previous = head;
        head = head.next;
        while (cur != null) {
            ListNode first = cur;
            ListNode second = cur.next;
            if (second == null) {
                break;
            }
            previous.next = second;
            previous = first;
            cur = second.next;
            second.next = first;
            first.next = cur;
        }
        return head;
    }
}
