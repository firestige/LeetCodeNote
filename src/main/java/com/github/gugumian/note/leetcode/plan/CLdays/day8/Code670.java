package com.github.gugumian.note.leetcode.plan.CLdays.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

 示例 1 :

 输入: 2736
 输出: 7236
 解释: 交换数字2和数字7。
 示例 2 :

 输入: 9973
 输出: 9973
 解释: 不需要交换。
 注意:

 给定数字的范围是 [0, 10^8]
 */
public class Code670 {
    public int maximumSwap(int num) {
        StringBuilder ans = new StringBuilder().append(num);
        char[] chars = ans.toString().toCharArray();
        Arrays.sort(chars);
        StringBuilder temp = new StringBuilder().append(chars).reverse();
        for (int i = 0; i < ans.length(); i++) {
            if (temp.charAt(i) > ans.charAt(i)) {
                int a = ans.lastIndexOf(String.valueOf(temp.charAt(i)));
                ans.setCharAt(a, ans.charAt(i));
                ans.setCharAt(i, temp.charAt(i));
                break;
            }
        }
        return Integer.parseInt(ans.toString());
    }

    @Test
    void solution() {
        Assertions.assertEquals(7236, maximumSwap(2736));
    }
}
