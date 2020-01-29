package com.github.gugumian.note.leetcode.plan.CLdays.day2;

import com.github.gugumian.note.leetcode.common.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode point = head;
        while(point.next != null) {
            point = point.next;
            size++;
        }
        point.next = head;
        int offset = size - (k % size);
        while(offset > 0) {
            head = head.next;
            point = point.next;
            offset--;
        }
        point.next = null;
        return head;
    }
}
/*
成环然后偏移最后开环，没有难度
 */
