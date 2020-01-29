package com.github.gugumian.note.leetcode.plan.CLdays.day1;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Code39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> out = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        backtrack(nums, out, candidates, 0, target);
        return out;
    }

    public void backtrack(LinkedList<Integer> nums, List<List<Integer>> out, int[] candidates, int start, int target) {
        //target等于0的时候就可以输出了
        if (target == 0) {
            out.add(new ArrayList<>(nums));
            //提前返回，避免target>0的无用判断
            return;
        }
        // target 》 0的时候表示还不够，还需要再候选数组中找数加进组合
        if (target > 0) {
            for(int i = start; i < candidates.length; i++) {
                nums.add(candidates[i]);
                backtrack(nums, out, candidates, i, target - candidates[i]);
                nums.remove(nums.size() - 1);
            }
        }
        //显然target < 0的时候就不应该再继续了
    }

    public static void main(String[] args) {
        Code39 solution = new Code39();
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;
        log.info(solution.combinationSum(candidates, target).toString());
    }
}

/*
看到举出所有可能的组合，首先考虑回溯法
然后发现题目要求可以重复使用元素，但是不能出现重复的组合，就要考虑到过滤回溯过程中出现重复组合的可能
思考出现重复的情况，发现如果从大数进了小数，就有可能出现重复，比如2，2，3和3，2，2
这种情况，可以通过排序解决，即要求组合必然是单调的，所以在回溯的时候，除和为7外，还应该要求从小到大开始回溯，下一层不能选比上一层小的数字。

优化策略，
1. 一般穷举的输出只需要增加操作，而长度未知，这时输出应该使用链表取巧，避免因为顺序表添加元素的重复申请新内存空间和复制带来的开销。
2. 由于回溯输出的时候需要深拷贝当前工作数组，这时链表的表现没有顺序表快，所以当前工作数组应该使用顺序表。

关于回溯法，官方的题解中提到，先画图，然后根据图中的树来解题，是非常好的方法。需要学习
 */
