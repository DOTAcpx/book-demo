package com.leecode.algorithm._009;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int[] bs = new int[11];
        int count = 0;
        while(x != 0){
            bs[count++] = x%10;
            x/=10;
        }
        count--;
        for (int i = 0; i < count; i++, count--) {
            if (bs[i] != bs[count]){
                return false;
            }
        }
        return true;
    }

//    public boolean isPalindrome(int x) {
//        if(x < 0){
//            return false;
//        }
//        int sum = 0;
//        int oldX = x;
//        while(oldX != 0){
//            sum = sum*10 + oldX%10;
//            oldX/=10;
//        }
//
//        return sum == x;
//    }

//    public boolean isPalindrome(int x) {
//        if(x < 0){
//            return false;
//        }
//        char[] cs = String.valueOf(x).toCharArray();
//        for (int start = 0, end = cs.length-1; start < end; start++,end--) {
//            if(cs[start] != cs[end]){
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new IsPalindrome().isPalindrome(x));
    }

}
