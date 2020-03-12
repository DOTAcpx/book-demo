package com.leecode.algorithm._005;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        String s = "a";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if("".equals(s)){
            return "";
        }

        char[] cs = s.toCharArray();
        int maxLength = 0, index = 0;
        for (int i = cs.length-1, length = i; i >= 0 && length > maxLength; i--, length = i) {
            for (int j = 0; j < cs.length && length > maxLength; j++,length--) {
                if(cs[j] == cs[i]){
                    boolean eq = true;
                    for (int i1=i,j1=j; j1 < i1; i1--,j1++){
                        if(cs[i1] != cs[j1]){
                            eq = false;
                            break;
                        }
                    }
                    if(eq){
                        index = i; maxLength = length;
                        break;
                    }
                }
            }
        }
        return new String(cs, index - maxLength, maxLength+1);
    }

    public boolean findIsEquals(char[] cs, int i, int j){
        for (;j < i; i--,j++){
            if(cs[i] != cs[j]){
                return false;
            }
        }
        return true;
    }


//
//    public String longestPalindrome(String s) {
//        if("".equals(s)){
//            return "";
//        }
//
//        char[] cs = s.toCharArray();
//        int[] lengths = new int[cs.length];
//        for (int i = 0; i < cs.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if(cs[j] == cs[i]){
//                    int ij = i-j;
//                    if(lengths[i-1] == ij-2) {
//                        lengths[i] = ij;
//                        break;
//                    }else if(ij == 1){
//                        lengths[i] = 1;
//                        break;
//                    }else if(lengths[i-1] == ij-1){
//                        boolean eq = true;
//                        for (int x = j; x < i-1; x++) {
//                            if(lengths[x]+1 != lengths[x+1]){
//                                eq = false;
//                            }
//                        }
//                        if(eq){
//                            lengths[i] = lengths[i-1]+1;
//                        }
//                        break;
//                    }else if(ij == lengths[i-1]){
//                        boolean eq = true;
//                        for (int i1 = j+1,i2=i-1; i1 < i2; i1++,i2--) {
//                            if(cs[i1] != cs[i2]){
//                                eq = false;
//                            }
//                        }
//                        if(eq){
//                            lengths[i] = ij;
//                            break;
//                        }
//                    }else if(ij == 2){
//                        lengths[i] = 2;
//                        break;
//                    }
//                }
//            }
//        }
//
//        int maxLength=0, index=0;
//        for (int i = 0; i < lengths.length; i++) {
//            if(maxLength < lengths[i]){
//                maxLength = lengths[i];
//                index = i;
//            }
//        }
//        System.out.println(Arrays.toString(lengths));
//        return new String(cs, index - maxLength, maxLength+1);
//    }

    // 理解题目错误,认为是前后两个字符相同就叫回文
//    public String longestPalindrome(String s) {
//        char[] cs = s.toCharArray();
//        if(cs.length == 0){
//            return "";
//        }
//
//        int[] lengths = new int[cs.length];
//        boolean have = true;
//
//        for (int i = 0; i < cs.length; i++, have = true) {
//            for (int j = i-1; j >= 0; j--) {
//                if(cs[j] == cs[i]){
//                    for (int x = j; x < i; x++) {
//                        if(lengths[x] != 0) {
//                            have = false;
//                        }
//                    }
//                    if(have){
//                        lengths[i] = i-j;
//                    }
//                    break;
//                }
//            }
//        }
//        int maxLength = 0;
//        int index = 0;
//        for (int i = 0; i < lengths.length; i++) {
//            if(lengths[i] > maxLength) {
//                maxLength = lengths[i];
//                index = i;
//            }
//        }
//        return new String(cs, index - maxLength, maxLength+1);
//    }
}
