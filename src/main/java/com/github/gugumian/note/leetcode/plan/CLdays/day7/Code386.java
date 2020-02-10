package com.github.gugumian.note.leetcode.plan.CLdays.day7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 9; i > 0; i--) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int i = stack.pop();
            ans.add(i);
            int e = 10;
            while (e > 0) {
                e--;
                int tmp = i*10+e;
                if (tmp > n) {
                    break;
                } else {
                    stack.push(tmp);
                }

            }
        }
        return ans;
    }

    private void dfs(List<Integer> ans, int n, int target) {
        if (n > target){
            return;
        }
        ans.add(n);
        for(int i = 0; i < 10; i++) {
            dfs(ans, n * 10 + i, target);
        }
    }
}
