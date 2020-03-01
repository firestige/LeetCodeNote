package com.github.gugumian.note.leetcode.plan.CLdays.day8;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (!digits.isEmpty()) {
            trackBack(ans, digits, new StringBuilder(), 0, digits.length());
        }
        return ans;
    }

    private void trackBack(List<String> ans, String digits, StringBuilder current, int index, int num) {
        char[] words = new char[] {'a', 'd', 'g', 'j', 'm', 'p', 't', 'w', 'z' + 1};
        if (index == num) {
            ans.add(current.toString());
        } else {
            int i = digits.charAt(index) - '2';
            for (char c = words[i]; c < words[i + 1]; c++) {
                current.append(c);
                trackBack(ans, digits, current, index + 1, num);
                current.setLength(index);
            }
        }
    }
}
