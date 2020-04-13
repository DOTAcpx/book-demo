package com.leecode.algorithm._022;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), 0, 0, n, n*2);
        return list;
    }

    public void backtrack(List<String> list, StringBuilder sb, int start, int end, int n, int max){
        if(sb.length() == max){
            list.add(sb.toString());
            return;
        }
        if(start < n){
            sb.append('(');
            backtrack(list, sb, start+1, end, n, max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(end < start){
            sb.append(')');
            backtrack(list, sb, start, end+1, n, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gen = new GenerateParenthesis();
        int n = 3;
        for (String str : gen.generateParenthesis(n)) {
            System.out.println(str);
        }
    }
}
