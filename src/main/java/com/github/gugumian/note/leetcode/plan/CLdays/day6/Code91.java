package com.github.gugumian.note.leetcode.plan.CLdays.day6;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code91 {

    public int numDecodings(String s) {
        int index = 0;
        int count = 0;
        if (s.charAt(index) == '0') {
            return 0;
        }
        while (index < s.length() - 1) {
            if (s.charAt(index) == '0') {
                count--;
            }
            if (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7'){
                count++;
            }
            index++;
        }
        if (s.charAt(index) > '0') {
            count++;
        }
        return Math.max(count, 0);
    }

}
