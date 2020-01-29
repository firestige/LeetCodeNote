package com.github.gugumian.note.leetcode.plan.CLdays.day4;

import java.util.*;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrace(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backTrace(List<List<Integer>> ans, List<Integer> subset, int[] nums, int i) {
        ans.add(new ArrayList<>(subset));
        for(int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backTrace(ans, subset, nums, j+1);
            subset.remove(subset.size() - 1);
        }
    }

}
