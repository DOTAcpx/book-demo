package com.leecode.algorithm._005;

/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0,oldI = 0; i < cs.length; i++,oldI = i) {
            for (int j = cs.length; j > i; j--) {
                if(cs[i] == cs[j]){

                }
            }
        }

        return null;
    }
}
