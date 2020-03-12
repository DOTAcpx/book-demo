package com.leecode.algorithm._006;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 *
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
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
public class Convert {
    public String convert(String s, int numRows) {
        int length = numRows - 1;
        if(length <= 0){
            return s;
        }
        //定义基础数据
        char[] cs = s.toCharArray();
        char[] newCs = new char[cs.length];

        for (int i=0, index=0, add=length*2, one=add-2, two=2; i < numRows; i++) {
            if(i == 0 || i == length){
                for (int x = i; x < cs.length; x+=add) {
                    newCs[index++]=cs[x];
                }
            } else {
                for (int x=i, addNum = two; x < cs.length; x+=addNum=addNum==two?one:two) {
                    newCs[index++]=cs[x];
                }
                two+=2;
                one-=2;
            }
        }
        return new String(newCs);
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        String s = new Convert().convert(input, 4);
        System.out.println(s);
        System.out.println(s.length() + " == " + input.length());
    }
}
