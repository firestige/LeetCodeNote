package com.github.gugumian.note.leetcode.plan.CLdays.day1;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Code322 {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        int index = coins.length - 1;
        while(amount > 0 && index > -1) {
            if (coins[index] <= amount) {
                amount -= coins[index];
                count++;
            } else {
                index--;
            }
        }
        return index > -1 ? count : -1;
    }

    public static void main(String[] args) {
        Code322 solution = new Code322();
        int[] coins = new int[] {1,2,5};
        int amount = 11;
        log.info("{}", solution.coinChange(coins, amount));
    }
}

/*
dp问题，应该从后向前，但是取法有问题，
 */
