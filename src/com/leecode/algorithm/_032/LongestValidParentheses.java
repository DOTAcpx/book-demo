package com.leecode.algorithm._032;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {
    /**
     *
     作者：lzhlyle
     链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/bian-li-zhong-xin-shuang-zhi-zhen-zhong-xin-kuo-zh/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private Map<Integer, Integer> map = new HashMap<>();
// key: 右括号的索引, value: 对应左括号的索引

    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        // 遍历中心
        for (int c = 0; c < arr.length - 1; c++) {
            if (arr[c] == '(' && arr[c + 1] == ')') {
                int r = expand(arr, c, c + 1);
                max = Math.max(max, r - map.get(r) + 1);
                c = r;
            }
        }
        return max;
    }

    // 中心扩展
    private int expand(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == '(' && arr[r] == ')') {
            l--; r++;
        }
        if (map.containsKey(l)) return expand(arr, map.get(l) - 1, r); // 继续递归扩展
        map.put(r - 1, l + 1); // (右, 左)
        return r - 1;
    }

}
