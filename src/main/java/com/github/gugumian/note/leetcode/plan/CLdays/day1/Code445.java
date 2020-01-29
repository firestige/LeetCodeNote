package com.github.gugumian.note.leetcode.plan.CLdays.day1;

import com.github.gugumian.note.leetcode.common.ListNode;

import java.util.LinkedList;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();
        while(l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        if (stack2.size() > stack1.size()) {
            LinkedList<ListNode> temp = stack2;
            stack2 = stack1;
            stack1 = temp;
        }
        int rise = 0;
        LinkedList<ListNode> stack3 = new LinkedList<>();
        while (!stack2.isEmpty()) {
            l1 = stack1.pop();
            l2 = stack2.pop();
            int temp = l1.val + l2.val + rise;
            if (temp > 9) {
                temp = temp - 10;
                rise = 1;
            } else {
                rise = 0;
            }
            ListNode cur = new ListNode(temp);
            stack3.push(cur);
        }
        while(!stack1.isEmpty()) {
            l1 = stack1.pop();
            int temp = l1.val + rise;
            if (temp > 9) {
                temp = temp - 10;
                rise = 1;
            } else {
                rise = 0;
            }
            ListNode cur = new ListNode(temp);
            stack3.push(cur);
        }
        if(rise > 0) {
            stack3.push(new ListNode(1));
        }
        ListNode ans = stack3.pop();
        ListNode cur = ans;
        while(!stack3.isEmpty()) {
            cur.next = stack3.pop();
            cur = cur.next;
        }
        return ans;
    }
}

/*
双栈法，最后生成链表的时候可以不适用双向链表，直接生成链表
 */
