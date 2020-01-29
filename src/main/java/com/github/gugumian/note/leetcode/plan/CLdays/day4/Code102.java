package com.github.gugumian.note.leetcode.plan.CLdays.day4;

import com.github.gugumian.note.leetcode.common.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        int total = 1;
        queue.add(root);
        while (queue.size() > 0) {
            if (index == total) {
                total = queue.size();
                index = 0;
                if (!current.isEmpty()) {
                    ans.add(current);
                    current = new ArrayList<>();
                }
            }
            TreeNode cur = queue.poll();
            index++;
            if(cur != null) {
                current.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return ans;
    }



}
