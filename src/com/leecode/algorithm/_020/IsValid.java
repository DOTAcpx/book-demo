package com.leecode.algorithm._020;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *
 * 	左括号必须用相同类型的右括号闭合。
 * 	左括号必须以正确的顺序闭合。
 *
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
    public boolean isValid(String s) {
        boolean big=false, centre=false, small=false;
        char[] cs = s.toCharArray();
        Node node = new Node('y');
        for (char c : cs) {
            switch (c){
                case '(':
                    node=putNode(node, ')');
                    break;
                case '[':
                    node=putNode(node, ']');
                    break;
                case '{':
                    node=putNode(node, '}');
                    break;
                case '}':
                    if(node.val != '}'){
                        return false;
                    }
                    node=node.upper;
                    break;
                case ']':
                    if(node.val != ']'){
                        return false;
                    }
                    node=node.upper;
                    break;
                case ')':
                    if(node.val != ')'){
                        return false;
                    }
                    node=node.upper;
                    break;
            }
        }
        return node.val=='y';
    }

    public Node putNode(Node node, char val) {
        node.next = new Node(val);
        node.next.upper = node;
        return node.next;
    }

    static class Node{
        char val;
        Node(){}
        Node(char val){ this.val = val; }
        Node next;
        Node upper;
    }

}
