package com.github.gugumian.note.leetcode.plan.CLdays.day5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code6 {
    public static String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < s.length(); i++) {
            int t = 2 * numRows - 2;
            int row = i % t;
            row = row > numRows - 1 ? t - row : row;
            sbs[row] = Optional.ofNullable(sbs[row]).orElse(new StringBuilder());
            sbs[row].append(s.charAt(i));
        }
        return Arrays.stream(sbs).filter(Objects::nonNull).reduce(StringBuilder::append).orElse(new StringBuilder()).toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }
}
