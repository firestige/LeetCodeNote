package com.github.gugumian.note.leetcode.plan.CLdays.day7;

import com.github.gugumian.note.leetcode.common.ListNode;

import java.util.List;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            if (tmp.val == cur.val) {
                cur = skipDuplicates(cur);
                if (previous != null) {
                    previous.next = cur;
                } else {
                    head = cur;
                }
            } else {
                previous = tmp;
            }
        }
        return head;
    }

    private ListNode skipDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != head.val) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

}
