package com.github.gugumian.note.leetcode.algorithms;

import com.github.gugumian.note.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int index = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[index]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    node = stack.pop();
                    index++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
