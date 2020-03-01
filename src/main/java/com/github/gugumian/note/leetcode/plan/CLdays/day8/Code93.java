package com.github.gugumian.note.leetcode.plan.CLdays.day8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Code93 {
    //todo 不优雅，需要改进

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if("0000".equals(s)) {
            ans.add("0.0.0.0");
        } else{
            backTrace(ans, new LinkedList<>(), s, -1, 3);
        }


        return ans;
    }

    private void backTrace(List<String> ans, LinkedList<String> ip, String s, int pos, int dots) {
        for (int i = pos + 1; i < Math.min(s.length() - 1, pos + 4); i++) {
            if (valid(s, pos + 1, i + 1)) {
                ip.add(s.substring(pos + 1, i + 1));
                if (dots - 1 == 0) {
                    if (valid(s, i +1, s.length())) {
                        ans.add(ip.stream().reduce((s1, s2) -> s1 + '.' + s2).get() + '.' + s.substring(i + 1));
                    }
                } else {
                    backTrace(ans, ip, s, i, dots - 1);
                }
                ip.removeLast();
            }
        }


    }

    private boolean valid(String s, int start, int end) {
        if (end - start > 4) {
            return false;
        }
        if (end - start > 1) {
            return s.charAt(start) != '0' && Integer.parseInt(s.substring(start, end)) <= 255;
        }
        return true;
    }

    @Test
    void solution() {
        log.info(restoreIpAddresses("2552552551").toString());
    }

}
