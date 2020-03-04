package com.leecode.algorithm._003;

import java.util.Arrays;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		int maxLength = new LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt");
		System.out.println(maxLength);
	}

	public int lengthOfLongestSubstring(String s) {
    	final char[] cs = s.toCharArray();
    	final int sLength = cs.length;
    	final int[] lengths = new int[sLength];
    	int maxLength = 0;
    	boolean flag = true;
    	int repetition = 0;
    	
    	for (int i = 0; i < sLength; i++,flag = true) {
			for (int j = i - 1; j > -1; j--) {
				if(cs[i] == cs[j]) {
					repetition = repetition>j ? repetition:j;
		    		flag = false;
		    		break;
				}
			}
			
			if(flag) {
				if(i - repetition > maxLength) {
					lengths[i] = maxLength = i - repetition;
				} else if(i == maxLength){
					lengths[i] = ++maxLength;
				} else {
					lengths[i] = lengths[i-1];
				}
			} else {
	    		if(i - repetition >= maxLength) {
	    			if(lengths[i-1] > maxLength) {
	    				lengths[i] = maxLength = lengths[i-1] + 1;
	    			} else {
	    				lengths[i]= maxLength = i - repetition;
	    			}
	    		} else {
	    			lengths[i] = lengths[repetition];
	    		}
			}
		}
        return maxLength;
    }
}
