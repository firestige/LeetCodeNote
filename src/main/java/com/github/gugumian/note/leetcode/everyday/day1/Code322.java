package com.github.gugumian.note.leetcode.everyday.day1;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
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
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author gugumian
 */
public class Code322 {

    Integer min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        //return dp(coins, amount);
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int dp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i  = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private void dfs(int[] coins, int amount, int index, int count) {
        if (index < 0 || count + amount / coins[index] >= min) {
            return;
        }
        if (amount % coins[index] == 0) {
            min = Math.min(min, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            dfs(coins, amount - i * coins[index], index - 1, count + i);
        }
    }
}
