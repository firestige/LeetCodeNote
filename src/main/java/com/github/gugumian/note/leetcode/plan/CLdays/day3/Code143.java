package com.github.gugumian.note.leetcode.plan.CLdays.day3;

import com.github.gugumian.note.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code143 {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> dq = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            dq.add(cur);
            cur = cur.next;
        }
        boolean flag = true;
        if (dq.size() < 3) {
            return;
        }
        cur = dq.pollFirst();
        while (!dq.isEmpty()){
            if (flag) {
                cur.next = dq.pollLast();
            } else {
                cur.next = dq.pollFirst();
            }
            cur = cur.next;
            flag = !flag;
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        Code143 solutuion = new Code143();
        int[] sample = new int[] {1, 2, 3, 4, 5,6};
        ListNode head = null;
        ListNode cur = null;
        for(int i : sample) {
            if(head == null) {
                head = new ListNode(i);
                cur = head;
            } else {
                cur.next = new ListNode(i);
                cur = cur.next;
            }
        }
        solutuion.reorderList(head);
        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
