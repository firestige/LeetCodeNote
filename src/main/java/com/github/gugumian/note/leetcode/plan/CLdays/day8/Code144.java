package com.github.gugumian.note.leetcode.plan.CLdays.day8;

import com.github.gugumian.note.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(TreeNode node, List<Integer> ans) {
        ans.add(node != null ? node.val : null);
        preorder(node.left, ans);
        preorder(node.right, ans);
    }

    public void preorder2(TreeNode node, List<Integer> ans){
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n != null) {
                ans.add(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }
    }
}
