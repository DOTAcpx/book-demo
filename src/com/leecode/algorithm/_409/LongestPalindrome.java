package com.leecode.algorithm._409;

import java.util.LinkedList;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        byte[] bs = new byte[cs.length];
        int maxLength=0;
        for (int i = 0; i < cs.length; i++) {
            if(bs[i] == 1){
                continue;
            }
            for (int j = i+1; j < cs.length; j++) {
                if(cs[i] == cs[j]){
                    maxLength+=2;
                    bs[j]=1;
                    bs[i]=1;
                    break;
                }
            }
        }
        for (byte b : bs) {
            if(b==0){
                maxLength++;
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
    }
}
