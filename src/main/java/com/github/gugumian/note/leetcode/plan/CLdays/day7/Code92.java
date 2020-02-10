package com.github.gugumian.note.leetcode.plan.CLdays.day7;

import com.github.gugumian.note.leetcode.common.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode conn = prev;
        ListNode tail = cur;
        ListNode tmp;
        while (n > 0) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            n--;
        }
        if (conn != null) {
            conn.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

}
